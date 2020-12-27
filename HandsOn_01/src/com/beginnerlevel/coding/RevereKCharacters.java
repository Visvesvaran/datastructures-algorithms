package com.beginnerlevel.coding;

import java.util.ArrayList;
import java.util.List;

public class RevereKCharacters {

	// Given a string and an integer k, you need to reverse the first k characters
	// for every 2k characters counting from the start of the string. If there are
	// less than k characters left, reverse all of them. If there are less than 2k
	// but greater than or equal to k characters, then reverse the first k
	// characters and left the other as original.
	// Example:
	// Input: s = "abcdefg", k = 2
	// Output: "bacdfeg"
	// Restrictions:
	// The string consists of lower English letters only.
	// Length of the given string and k will in the range [1, 10000]

	public static void main(String[] args) {
		String s = "abcdefghijklmnopqrstuvwxyz";
		int k = 27;
		if (k > 0 && k < 10001) {
			if(k > s.length()) {
				k = s.length();
			}
			String subS = s.substring(0, k);
			String[] subArray = subS.split("");
			StringBuffer bf = new StringBuffer();
			for (int i = subArray.length - 1; i > -1; i--) {
				bf.append(subArray[i]);
			}
			bf.append(s.substring(k, s.length()));
			System.out.println(bf);
		}

	}

}
