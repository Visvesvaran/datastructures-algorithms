package com.beginnerlevel.coding.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.beginnerlevel.coding.RotateArrayEasy;

public class RotateArrayEasyTest {
	
	@Test
	public void testRotate_1() {
		RotateArrayEasy r = new RotateArrayEasy();
		int[] nums = new int[] {1,2,3,4,5,6,7};
		int k = 3;
		r.rotate_1(nums, k);
		assertEquals(new int[] {5,6,7,1,2,3,4}, nums);
		
	}
	
	@Test
	public void testRotate_2() {
		RotateArrayEasy r = new RotateArrayEasy();
		int[] nums = new int[] {1,2};
		int k = 3;
		r.rotate_1(nums, k);
		assertEquals(new int[] {2,1}, nums);
		
	}
}
