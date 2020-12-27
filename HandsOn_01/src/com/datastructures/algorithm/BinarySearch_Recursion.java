package com.datastructures.algorithm;

public class BinarySearch_Recursion {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
		int search = 91;
		int start = 0;
		int end = arr.length - 1;

		System.out.println("Recursion");
		search = 2;
		System.out.println("Index of first element " + search + " from {2, 5, 8, 12, 16, 23, 38, 56, 72, 91} "
				+ binarySearchRecursion(arr, start, end, search));
		search = 16;
		System.out.println("Index of middle element " + search + " from {2, 5, 8, 12, 16, 23, 38, 56, 72, 91} "
				+ binarySearchRecursion(arr, start, end, search));
		search = 91;
		System.out.println("Index of end element " + search + " from {2, 5, 8, 12, 16, 23, 38, 56, 72, 91} "
				+ binarySearchRecursion(arr, start, end, search));

		search = 23;
		System.out.println("Index of element " + search + " from {2, 5, 8, 12, 16, 23, 38, 56, 72, 91} "
				+ binarySearchRecursion(arr, start, end, search));
		
		System.out.println("Iterative");
		
		search = 2;
		System.out.println("Index of first element " + search + " from {2, 5, 8, 12, 16, 23, 38, 56, 72, 91} "
				+ binarySearchIterative(arr, start, end, search));
		search = 16;
		System.out.println("Index of middle element " + search + " from {2, 5, 8, 12, 16, 23, 38, 56, 72, 91} "
				+ binarySearchRecursion(arr, start, end, search));
		search = 91;
		System.out.println("Index of end element " + search + " from {2, 5, 8, 12, 16, 23, 38, 56, 72, 91} "
				+ binarySearchRecursion(arr, start, end, search));

		search = 23;
		System.out.println("Index of element " + search + " from {2, 5, 8, 12, 16, 23, 38, 56, 72, 91} "
				+ binarySearchRecursion(arr, start, end, search));

	}

	private static int binarySearchRecursion(int[] arr, int start, int end, int search) {
		int mid = (start + end) / 2;
		if (search == arr[mid]) {
			return mid;
		} else if (search > arr[mid]) {
			start = mid + 1;
			return binarySearchRecursion(arr, start, end, search);
		} else if (search < arr[mid]) {
			end = mid - 1;
			return binarySearchRecursion(arr, start, end, search);
		}
		return -1;
	}

	private static int binarySearchIterative(int[] arr, int start, int end, int search) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (search == arr[mid]) {
				return mid;
			}
			
			if (search > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

}
