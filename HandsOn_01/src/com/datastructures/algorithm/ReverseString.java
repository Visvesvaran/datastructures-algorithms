package com.datastructures.algorithm;

public class ReverseString {

	public static void main(String[] args) {
		char[] s = new char[] {'h','e','l','l','o'};
		reverseString(s);
		System.out.println(s);
	}

	public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}
