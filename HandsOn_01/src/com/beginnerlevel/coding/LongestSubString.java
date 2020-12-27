package com.beginnerlevel.coding;

import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubString {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		char[] str = s.toCharArray();
		int[] map = new int[256];
		int left = 0;
		int right = 0;
		int d = Integer.MIN_VALUE;
		int counter = 0;

		while (right < str.length) {
			if (map[str[right++]]++ > 0)
				counter++;

			while (counter > 0) {
				if (map[str[left++]]-- > 1)
					counter--;
			}

			d = Math.max(d, right - left);
		}

		return d;
	}

	// HashSet
	public static int lengthOfLongestSubstring_1(String input) {
		Set<Character> set = new HashSet<>();
		int res = 0, n = input.length();
		for (int left = 0, right = 0; left < n && right < n;) {
			if (!set.contains(input.charAt(right))) {
				set.add(input.charAt(right++));
				res = Math.max(res, right - left);
			} else {
				set.remove(input.charAt(left++));
			}
		}
		return res;
	}
}
