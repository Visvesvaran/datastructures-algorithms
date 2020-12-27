package com.beginnerlevel.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Intersect {

	public static void main(String[] args) {
		int[] nums1 = new int[] { 2, 1, 3 };
		int[] nums2 = new int[] { 1, 2 };
		System.out.println(Arrays.toString(intersect(nums1, nums2)));
	}
	public static int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null){
            return null;
        }
        
        HashMap<Integer, Integer> store = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i: nums1){
            if(store.containsKey(i)){
                store.put(i, store.get(i)+1);
            }else{
                store.put(i,1);
            }
        }
        
        for(int i: nums2){
            if(store.containsKey(i) && store.get(i) >0 ){
                ans.add(i);
                store.put(i, store.get(i)-1);
            }
        }
        
        int[] key = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            key[i] = ans.get(i);
        }
        return key;
	}
	public static int[] intersect_sort(int[] nums1, int[] nums2) {
		int[] ans = new int[nums1.length];
    	int l1 = nums1.length,l2 = nums2.length;
    	int size = 0;
    	
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	
        int i1 = 0,i2 = 0;
    	while(i1 < l1 && i2 < l2)
        {
            if(nums1[i1] > nums2[i2])
                i2++;
            else if(nums1[i1] < nums2[i2])
                i1++;
            else
            {
                nums1[size++] = nums1[i1];
                i1++;i2++;
            }
        }
    	
    	return Arrays.copyOfRange(nums1, 0, size);
	}
	public static int[] intersect_1(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();

		int i = 0;
		while (i < nums1.length) {
			for (int j = 0; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					list.add(nums1[i]);
					if (nums2[j] != Integer.MIN_VALUE)
						nums2[j] = Integer.MIN_VALUE / 10;
					else
						nums2[j] = Integer.MAX_VALUE / 10;
					break;
				}
			}
			i++;
		}

		int[] nums3 = new int[list.size()];
		int k = 0;
		for (int n : list) {
			nums3[k] = n;
			k++;
		}
		return nums3;
	}
}
