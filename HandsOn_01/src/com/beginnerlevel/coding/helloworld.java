package com.beginnerlevel.coding;

public class helloworld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printHelloWorld();
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
		
	}

	/**
	 * 
	 */
	private static void printHelloWorld() {
		System.out.println("Hello World");
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median = 0.0;
		double total = 0.0;
		
        int m = nums1.length;
        int n = nums2.length;
        
        if((m+n)%2 == 0) {
        	for (int i = 0; i < nums1.length; i++) {
        		total = total + nums1[i];
			}
        	
        	for (int i = 0; i < nums2.length; i++) {
        		total = total + nums2[i];
			}
        	median = total/(m+n);
        }
        
        return median;
    }

}
