package com.learningdatastructures.stack;
/*Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23
Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.*/

public class BasicCalculator {
	
	public int calculate(String expression) {
		char[] charExpression = expression.toCharArray();
		int a,b;
		char c;
		int temp1 = 0;
		int temp2 = 0;
		int output = 0;
		boolean add = false;
		String regex = "\\d+";
		StringBuilder t = new StringBuilder();
		for (int i = 0; i < charExpression.length; i++) {
			String s1 = expression.substring(i, i+1);
			if(s1.matches(regex)){
				temp1 = Integer.valueOf(s1);
			} else if("+".equals(s1)) {
				add = true;
				continue;
			}
			if(add) {
				output = output + temp1;
				add = false;
			}
		}
		
		return output;
	}

}
