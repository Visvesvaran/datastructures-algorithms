package com.datastructures.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*There are a number of spherical balloons spread in two-dimensional space. 
 * For each balloon, provided input is the start and end coordinates of the horizontal diameter. 
 * Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. 
 * Start is always smaller than end. There will be at most 104 balloons.
 * 
 * An arrow can be shot up exactly vertically from different points along the x-axis.
 * A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
 * There is no limit to the number of arrows that can be shot.
 * An arrow once shot keeps travelling up infinitely. 
 * The problem is to find the minimum number of arrows that must be shot to burst all balloons.
 * Input int[][] points = new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
 * Output 2*/
public class ActivitySelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = new int[][] { { Integer.MIN_VALUE, Integer.MAX_VALUE } };
		System.out.println(points.length);
		System.out.println(points[0].length);

		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points[i].length; j++) {
				System.out.println(points[i][j]);
			}
		}

		findMinArrowShots(points);
	}
	
	public static void sortbyColumn(int arr[][], int col) {
		// Using built-in sort function Arrays.sort
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			// Compare values according to columns
			public int compare(final int[] entry1, final int[] entry2) {

				// To sort in descending order revert
				// the '>' Operator
				if (entry1[col] > entry2[col])
					return 1;
				else
					return -1;
			}
		}); // End of function call sort().
	}

	public static int findMinArrowShots(int[][] points) {
		int arrow = 0;
		if (points.length > 0) {
			sortbyColumn(points, 1);
			arrow = 1;
			int last = points[0][0];
			if (points[0].length > 1) {
				last = points[0][1];
			}
			for (int i = 0; i < points.length; i++) {
				if (last < points[i][0]) {
					last = points[i][1];
					arrow++;
				}
			}
		}

		return arrow;
	}
	
	public int findMinArrowShots_FAST(int[][] points) {
        if(points == null || points.length == 0)
            return 0;
        
        Arrays.sort(points, (a, b) -> (a[1] - b[1]));
        
        int prev = points[0][1];
        int result = 1;
        for (int i=1; i<points.length; i++) {
            if(prev < points[i][0]){
                prev = points[i][1];
                result++;
            }
           
        }
        
        return result;
    }
}
