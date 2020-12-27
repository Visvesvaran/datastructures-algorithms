package com.beginnerlevel.coding.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseIntegerTest {

	@Test
	public void testZeroAndOne() {
		assertEquals(0, ReverseIntegerTest.reverseInteger(0));
		assertEquals(1, ReverseIntegerTest.reverseInteger(1));
	}
	
	private static int reverseInteger(int input) {
		int target = 0;
		boolean isNegative = input < 0 ? true:false;
		if (isNegative) input = input * -1;		
		while (input > 0) {
			target = target*10 + input%10;
			input = input/10;
		}
		if (isNegative) target = target * -1;
		return target;
	}

}
