package com.hackerrank.coding;

import java.util.Arrays;

public class Array_LeftRotation {

	public static void main(String[] args) {
		int[] a = new int[] {41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51};
		int d = 10;
		System.out.println(Arrays.toString(rotLeft(a, d)));
		a = new int[] {33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97};
		d = 13;
		System.out.println(Arrays.toString(rotLeft(a, d)));
		a = new int[] {1,2,3,4,5};
		d = 4;
		System.out.println(Arrays.toString(rotLeft(a, d)));
		
	}
	
	static int[] rotLeft(int[] a, int d) {
        int l = a.length;
        int[] b = new int[l];
        int i = 0;
        int id = d;
        while(id<l)
        	b[i++] = a[id++];
        id = 0;
        while(id<d)
        	b[i++] = a[id++];
        return b;
    }


}
