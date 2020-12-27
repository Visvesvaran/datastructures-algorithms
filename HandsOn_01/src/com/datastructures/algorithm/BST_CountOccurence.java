package com.datastructures.algorithm;

public class BST_CountOccurence {

	/*
	 * Count number of occurrences (or frequency) in a sorted array. Given a sorted
	 * array arr[] and a number x, write a function that counts the occurrences of x
	 * in arr[]. Expected time complexity is O(Logn) Examples:
	 * 
	 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,}, x = 2 Output: 4 // x (or 2) occurs 4
	 * times in arr[]
	 * 
	 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,}, x = 3 Output: 1
	 * 
	 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,}, x = 1 Output: 2
	 * 
	 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,}, x = 4 Output: -1 // 4 doesn't occur in
	 * arr[]
	 */
	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 1, 2, 2, 2, 2, 3 };
		int search = 0;
		int start = 0;
		int end = arr1.length - 1;
		
		search = 2;
		System.out.println("{1, 1, 2, 2, 2, 2, 3}");
		System.out.println("First occurrence of element " + search +" is "+ binarySearchIterative_FirstOccurrence(arr1, start, end, search));
		System.out.println("Last occurrence of element " + search +" is "+ binarySearchIterative_LastOccurrence(arr1, start, end, search));
		System.out.println("Number of occurrence of element " + search +" is "+ (binarySearchIterative_LastOccurrence(arr1, start, end, search) - binarySearchIterative_FirstOccurrence(arr1, start, end, search) + 1));
		search = 3;
		System.out.println("{1, 1, 2, 2, 2, 2, 3}");
		System.out.println("First occurrence of element " + search +" is "+ binarySearchIterative_FirstOccurrence(arr1, start, end, search));
		System.out.println("Last occurrence of element " + search +" is "+ binarySearchIterative_LastOccurrence(arr1, start, end, search));
		System.out.println("Number of occurrence of element " + search +" is "+ (binarySearchIterative_LastOccurrence(arr1, start, end, search) - binarySearchIterative_FirstOccurrence(arr1, start, end, search) + 1));
		search = 1;
		System.out.println("{1, 1, 2, 2, 2, 2, 3}");
		System.out.println("First occurrence of element " + search +" is "+ binarySearchIterative_FirstOccurrence(arr1, start, end, search));
		System.out.println("Last occurrence of element " + search +" is "+ binarySearchIterative_LastOccurrence(arr1, start, end, search));
		System.out.println("Number of occurrence of element " + search +" is "+ (binarySearchIterative_LastOccurrence(arr1, start, end, search) - binarySearchIterative_FirstOccurrence(arr1, start, end, search) + 1));
		
		int[] arr2 = new int[] { 1, 2, 2, 3, 3, 3, };
		end = arr2.length - 1;
		
		search = 2;
		System.out.println("{1, 2, 2, 3, 3, 3,}");
		System.out.println("First occurrence of element " + search +" is "+ binarySearchIterative_FirstOccurrence(arr2, start, end, search));
		System.out.println("Last occurrence of element " + search +" is "+ binarySearchIterative_LastOccurrence(arr2, start, end, search));
		System.out.println("Number of occurrence of element " + search +" is "+ (binarySearchIterative_LastOccurrence(arr2, start, end, search) - binarySearchIterative_FirstOccurrence(arr2, start, end, search) + 1));
		search = 3;
		System.out.println("{1, 2, 2, 3, 3, 3,}");
		System.out.println("First occurrence of element " + search +" is "+ binarySearchIterative_FirstOccurrence(arr2, start, end, search));
		System.out.println("Last occurrence of element " + search +" is "+ binarySearchIterative_LastOccurrence(arr2, start, end, search));
		System.out.println("Number of occurrence of element " + search +" is "+ (binarySearchIterative_LastOccurrence(arr2, start, end, search) - binarySearchIterative_FirstOccurrence(arr2, start, end, search) + 1));
		search = 1;
		System.out.println("{1, 2, 2, 3, 3, 3,}");
		System.out.println("First occurrence of element " + search +" is "+ binarySearchIterative_FirstOccurrence(arr2, start, end, search));
		System.out.println("Last occurrence of element " + search +" is "+ binarySearchIterative_LastOccurrence(arr2, start, end, search));
		System.out.println("Number of occurrence of element " + search +" is "+ (binarySearchIterative_LastOccurrence(arr2, start, end, search) - binarySearchIterative_FirstOccurrence(arr2, start, end, search) + 1));
		
		search = 4;
		System.out.println("{1, 2, 2, 3, 3, 3,}");
		System.out.println("First occurrence of element " + search +" is "+ binarySearchIterative_FirstOccurrence(arr2, start, end, search));
		System.out.println("Last occurrence of element " + search +" is "+ binarySearchIterative_LastOccurrence(arr2, start, end, search));
		int occ = 0;
		if(-1 == binarySearchIterative_LastOccurrence(arr2, start, end, search)) occ = 0;
		System.out.println("Number of occurrence of element " + search +" is "+ occ);
		
	}

	private static int binarySearchIterative_FirstOccurrence(int[] arr, int start, int end, int search) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (search == arr[mid]) {
				while (mid - 1 >= start && search == arr[mid - 1]) {
					mid--;
				}
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
	
	private static int binarySearchIterative_LastOccurrence(int[] arr, int start, int end, int search) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (search == arr[mid]) {
				while (mid + 1 <= end && search == arr[mid + 1]) {
					mid++;
				}
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
