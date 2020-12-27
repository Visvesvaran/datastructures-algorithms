package com.beginnerlevel.coding;

import java.util.HashMap;
import java.util.LinkedList;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(first("eetcode"));
	}

	public static int firstUniqChar(String s) {
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		int n = s.length();
		// build hash map : character and how often it appears
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			count.put(c, count.getOrDefault(c, 0) + 1);
		}

		// find the index
		for (int i = 0; i < n; i++) {
			if (count.get(s.charAt(i)) == 1)
				return i;
		}
		return -1;
	}

	public static int first(String s) {
		int index = -1;

		for (int i = 'a'; i <= 'z'; i++) {
			int tmp = s.indexOf(i);

			if (tmp >= 0 && tmp == s.lastIndexOf(i) && (index == -1 || tmp < index)) {
				index = tmp;
			}
		}
		return index;
	}
}
