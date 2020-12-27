package com.beginnerlevel.coding;

public class Sort_Merge2SortedArrays {

	public static void main(String[] args) {
		int[] num1 = new int[] { 1,2,3,0,0,0 };
		int[] num2 = new int[] { 2,5,6 };
		merge(num1, 3, num2, 3);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		 if (n == 0) return;
	        int i1 = m - 1;
	        int i2 = n - 1;
	        int i = m + n - 1;
	        while (i1 >= 0 && i2 >= 0) {
	            if (nums1[i1] >= nums2[i2]) {
	                nums1[i--] = nums1[i1--];
	            } else {
	                nums1[i--] = nums2[i2--];
	            }
	        }
	        while (i2 >= 0) {
	            nums1[i--] = nums2[i2--];
	        }
	}
	public static void merge_1(int[] nums1, int m, int[] nums2, int n) {
		for (int j = 0; j < n; j++) {
			int i = m - 1;
			while (i>=0 && nums1[i] > nums2[j]) {
				nums1[i + 1] = nums1[i];
				i--;
			}
			nums1[i+1] = nums2[j];
			m++;
		}
	}

}
