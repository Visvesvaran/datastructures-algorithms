package com.datastructures.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Duplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {9,8,8,7,6,5,5 };
		containsDuplicate_HashTable(nums);
		System.out.println(Arrays.toString(nums));
	}
	
	public static boolean containsDuplicate_MinMax(int[] nums) {
		int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int x : nums){
            min = Math.min(x, min);
            max = Math.max(x, max);
        }
        
        boolean buckets[] = new boolean[max-min+1];
        
        for(int x : nums){
            if(buckets[x-min] == true){
                return true;
            }
            buckets[x-min] = true;
        }
        return false;
	}

	public static boolean containsDuplicate_HashSet(int[] nums) {
		Set<Integer> set = new HashSet<>(nums.length);
		for(int i=0; i < nums.length; i++){
			if(set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
        }
		return false;
	}
	
	public static boolean containsDuplicate_HashTable(int[] nums) {
		Hashtable<Integer, Integer> ht = new Hashtable<>();
		for(int i=0; i < nums.length; i++){
			if(ht.containsKey(nums[i])) {
				return true;
			}
			ht.put(nums[i], i);
        }
		return false;
	}
	
	public static boolean containsDuplicate_Sort(int[] nums) {
		for(int i=0; i < nums.length; i++){
        	for(int j=i+1; j < nums.length; j++) {
        		if(nums[i] > nums[j]) {
        			int temp = nums[i];
        			nums[i] = nums[j];
        			nums[j] = temp;
        		} else if(nums[i] == nums[j]) {
        			return true;
        		}
        	}
        }
		return false;
	}
	public static boolean containsDuplicate_timeLimitExceeded(int[] nums) {
		for(int i=0; i < nums.length; i++){
        	for(int j=i+1; j < nums.length; j++) {
        		if(nums[i] == nums[j]) {
        			return true;
        		}
        	}
        }
        return false;
	}

}
