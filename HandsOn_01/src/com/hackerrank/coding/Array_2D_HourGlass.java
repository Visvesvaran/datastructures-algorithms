package com.hackerrank.coding;

public class Array_2D_HourGlass {

	public static void main(String[] args) {
		
		int[][] arr = new int[][] {
			{1,1,1,0,0,0},
			{0,1,0,0,0,0},
			{1,1,1,0,0,0},
			{0,0,2,4,4,0},
			{0,0,0,2,0,0},
			{0,0,1,2,4,0}			
		};
		System.out.println(hourglassSum(arr));
		arr = new int[][] {
			{-9,-9,-9,1,1,1},
			{0,-9,0,4,3,2},
			{-9,-9,-9,1,2,3},
			{0,0,8,6,6,0},
			{0,0,0,-2,0,0},
			{0,0,1,2,4,0}			
		};
		System.out.println(hourglassSum(arr));
		arr = new int[][] {
			{1,1,1,0,0,0},
			{0,1,0,0,0,0},
			{1,1,1,0,0,0},
			{0,0,2,4,4,0},
			{0,0,0,2,0,0},
			{0,0,1,2,4,0}			
		};
		System.out.println(hourglassSum(arr));
		
	}
	
	static int hourglassSum(int[][] arr) {
        int sum = Integer.MIN_VALUE;
        for(int i=1;i<5;i++){
            for(int j=1;j<5;j++){
                int temp = (
                arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] +
                + arr[i][j] + 
                arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1]
                );                        
                if(temp>sum){
                    sum = temp;
                }
            }
        }
        return sum;
    }

}
