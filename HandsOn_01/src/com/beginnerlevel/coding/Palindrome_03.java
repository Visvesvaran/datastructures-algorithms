package com.beginnerlevel.coding;

import java.util.Scanner;

public class Palindrome_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner readInput = new Scanner(System.in);
		System.out.print("Please enter the number ");
		int input1 = readInput.nextInt();
		readInput.close();
		int output1 = 0;
		output1 = reverseInteger(input1, output1);
		System.out.println("Input Number ::>> " + input1 + " and Output Number ::>> " + output1);
		if (output1==input1) {
			System.out.println("This is a PALINDROME number");
		} else {
			System.out.println("This is NOT a palindrome number");
		}
	}

	/**
	 * @param input
	 * @param output
	 * @return 
	 */
	private static int reverseInteger(int input, int output) {
		int lastDigit = 0;
		boolean isNegative = input < 0? true:false;
		if(isNegative) input = input * -1;
		while (input > 0) {
			lastDigit = input%10;
			output = output*10 + lastDigit;
			input = input/10;
		}
		if(isNegative) output = output * -1;
		return output;
	}
}
