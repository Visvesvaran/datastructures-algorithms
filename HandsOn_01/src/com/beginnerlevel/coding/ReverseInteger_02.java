package com.beginnerlevel.coding;

import java.util.Scanner;

/*Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
Input: 1534236469
*/

public class ReverseInteger_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("PLease enter a number : ");
		Scanner readInput = new Scanner(System.in);
		int input = readInput.nextInt();
		readInput.close();
		int target = reverseNumber(input);
		System.out.println("Integer 		= "+input);
		System.out.println("Reversed Integer 	= "+target);
	}
	
	private static int reverse(int x) {
		int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
	}

	/**
	 * @param input
	 * @param target
	 * @return
	 */
	private static int reverseNumber(int input) {
		int target = 0;
		while (input != 0) {
			int pop = input % 10;
			input /= 10;
			if (target > Integer.MAX_VALUE/10 || (target == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (target < Integer.MIN_VALUE/10 || (target == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
			target = target*10 + pop;
		}
		return target;
	}

}
