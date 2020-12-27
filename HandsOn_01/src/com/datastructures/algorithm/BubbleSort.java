package com.datastructures.algorithm;

import java.util.Arrays;

public class BubbleSort {
	
	public static int[] bubbleSort(int[] arr) {
		System.out.println("BubbleSort");
		
		boolean swap = false;
		int temp;

		for (int j = 0; j < arr.length; j++) {
			
			for (int i = 0; i < arr.length-1; i++) {
				swap = false;
				if(arr[i]>arr[i+1]) {
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					swap = true;
				}
			}
		}
		
		System.out.println(Arrays.toString(arr));
		return arr;
	}

}
