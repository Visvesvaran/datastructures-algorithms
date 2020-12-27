package com.beginnerlevel.coding;

import org.apache.commons.lang3.StringUtils;

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("babad"));
		System.out.println(longestPalindrome("aaabaaaa"));
		System.out.println(longestPalindrome("abceba"));

	}

	public static String longestPalindrome(String s) {
		int[] arr = new int[2];
		for (int i = 0; i <= s.length() - 1; i++) {
			palindrome(s, i, i, arr);
			palindrome(s, i, i + 1, arr);
		}

		return s.substring(arr[0], arr[0] + arr[1]);
	}

	private static void palindrome(String s, int low, int high, int[] arr) {
		while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
			low--;
			high++;
		}

		if (arr[1] < high - low - 1) {
			arr[1] = high - low - 1;
			arr[0] = low + 1;
		}
	}

	public static String longestPalindrome_1(String s) {
		int len = s.length();
		int l = 0;
		int r = len - 1;
		if (len < 2) {
			return s;
		}
		if (len == 2) {
			if (s.charAt(l) == s.charAt(r)) {
				return s;
			}
			return s.substring(l, r);
		}
		String pal = "";
		while (l < r && pal.length() < r + 1 - l) {
			if (!isPalindrome(s, l, r)) {
				int m = l;
				int n = r;
				while (l < r - 1) {
					if (isPalindrome(s, ++l, r)) {
						if (pal.length() < r + 1 - l) {
							pal = s.substring(l, r + 1);
							break;
						}
					}
				}
				l = m;
				while (l + 1 < r) {
					if (isPalindrome(s, l, --r)) {
						if (pal.length() < r + 1 - l) {
							pal = s.substring(l, r + 1);
							break;
						}
					}
				}
				r = n;
				l++;
				r--;
			} else {
				if (pal.length() > r + 1 - l) {
					return pal;
				}
				return s.substring(l, r + 1);
			}
		}
		if (pal.length() == 0) {
			pal = s.substring(0, 1);
		}
		return pal;
	}

	public static boolean isPalindromeReverse(String s) {
		boolean result = false;
		int j = s.length();
		for (int i = 0; i < s.length(); i++) {
			if (s.substring(i, i + 1).equalsIgnoreCase(s.substring(j - 1, j))) {
				result = true;
			} else {
				result = false;
				break;
			}
			j--;
		}
		return result;
	}

	public static boolean isPalindrome(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}

}
