package com.beginnerlevel.coding;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome_2("A man, a plan, a canal: Panama"));
	}

	public static boolean isPalindrome_2(String s) {
		char[] charMap = new char[256];
		for (int i = 0; i < 10; i++) {
			charMap[i + '0'] = (char) (1 + i);
		}
		for (int i = 0; i < 26; i++) {
			charMap[i + 'A'] = charMap[i + 'a'] = (char) (11 + i);
		}
		
		int l = 0;
		int r = s.length() - 1;
		char cL, cR;
		while(l<r) {
			cL = charMap[s.charAt(l)];
			cR = charMap[s.charAt(r)];
			if(cL!=0 && cR!=0) {
				if(cL!=cR) return false;
				l++;
				r--;
			} else {
				if(cL==0) l++;
				if(cR==0) r--;
			}
		}
		return true;
	}

	public static boolean isPalindrome_1(String s) {
		s = s.replaceAll("[^A-Za-z0-9]", "");
		s = s.toLowerCase();
		char[] cA = s.toCharArray();
		int l = 0;
		int r = cA.length - 1;
		while (l < r) {
			if (cA[l] != cA[r])
				return false;
			l++;
			r--;
		}
		return true;
	}

}
