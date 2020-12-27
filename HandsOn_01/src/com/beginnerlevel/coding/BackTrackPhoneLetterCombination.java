package com.beginnerlevel.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

/*
23
ad, ae, af
00, 01, 02
bd, be, bf
10, 11, 12
cd, ce, cf
20, 21, 22

234
adg, adh, adi
000, 001, 002
bdg, bdg, bdi
100, 101, 102
cdg, cdh, cdi
200, 201, 202

aeg, aeh, aei
010, 011, 012
beg, beg, bei
110, 111, 112
ceg, ceh, cei
210, 211, 212

afg, afh, afi
020, 011, 012
bfg, bfg, bfi
110, 111, 112
cfg, cfh, cfi
210, 211, 212 
 */

public class BackTrackPhoneLetterCombination {

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinations("234"));
	}

	public static List<String> letterCombinations(String digits) {
		if (digits.length() == 0)
			return new ArrayList<>();

		String[] dict = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		List<String> combos = new ArrayList<>();
		backtrack(combos, digits.toCharArray(), "", dict);
		return combos;
	}

	public static void backtrack(List<String> combos, char[] digits, String s, String[] dict) {
		if (s.length() == digits.length) {
			combos.add(s);
			return;
		}
		int i = s.length();
		int digit = digits[i] - '0';
		for (char letter : dict[digit].toCharArray()) {
			backtrack(combos, digits, s + Character.toString(letter), dict);
		}
	}

	public static List<String> letterCombinationsIterative(String digits) {
		List<String> list = new ArrayList<String>();
		if (digits.length() == 0)
			return list;
		String[] strArr = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		int len = digits.length();
		int[] counter = new int[len];
		while (counter[0] < strArr[digits.charAt(0) - '0'].length()) {
			while (counter[len - 1] < strArr[digits.charAt(len - 1) - '0'].length()) {
				int i = 0;
				StringBuilder sb = new StringBuilder();
				while (i < len) {
					sb.append(strArr[digits.charAt(i) - '0'].charAt(counter[i]));
					if (i == len - 1)
						counter[i]++;
					i++;
				}
				list.add(sb.toString());
			}
			for (int j = len - 1; j > 0; j--) {
				if (counter[j] >= strArr[digits.charAt(j) - '0'].length()
						&& counter[j - 1] < strArr[digits.charAt(j - 1) - '0'].length()) {
					counter[j] = 0;
					counter[j - 1]++;
				}
			}
		}
		return list;
	}
}
