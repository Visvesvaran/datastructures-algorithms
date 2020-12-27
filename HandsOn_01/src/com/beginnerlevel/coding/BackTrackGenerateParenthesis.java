package com.beginnerlevel.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/* 
 
 */

public class BackTrackGenerateParenthesis {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

	static char o = '(';
	static char c = ')';

	public static List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		if (n == 0)
			return list;
		generate(o, ""+o, 2 * n, list);
		return list;
	}

	public static void generate(char ch, String s, int len, List<String> list) {
		if (s.length() >= len) {
			if (isValid(s.toCharArray())) {
				if (!list.contains(s))
					list.add(s);
			}
			return;
		}
		generate(c, s+c, len, list);
//		s.substring(0, s.length()-1);
		generate(o, s+o, len, list);
	}

	public static boolean isValid(char[] sChar) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < sChar.length; i++) {
			if (sChar[i] == o)
				st.push(o);
			else {
				if (st.isEmpty())
					return false;
				st.pop();
			}
		}
		if (!st.isEmpty())
			return false;
		return true;
	}
}
