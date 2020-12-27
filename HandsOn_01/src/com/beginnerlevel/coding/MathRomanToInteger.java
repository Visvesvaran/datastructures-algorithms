package com.beginnerlevel.coding;

import java.util.HashMap;

/*
 Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4. 
 */
public class MathRomanToInteger {

	public static void main(String[] args) {
		 System.out.println(romanToInt("I"));
		 System.out.println(romanToInt("II"));
		 System.out.println(romanToInt("III"));
		 System.out.println(romanToInt("IV"));
		 System.out.println(romanToInt("V"));
		 System.out.println(romanToInt("VI"));
		 System.out.println(romanToInt("VII"));
		 System.out.println(romanToInt("VIII"));
		 System.out.println(romanToInt("IX"));
		 System.out.println(romanToInt("X"));
		 System.out.println(romanToInt("XL"));
		 System.out.println(romanToInt("L"));
		 System.out.println(romanToInt("XC"));
		 System.out.println(romanToInt("C"));
		 System.out.println(romanToInt("CD"));
		 System.out.println(romanToInt("D"));
		 System.out.println(romanToInt("CM"));
		 System.out.println(romanToInt("M"));
		System.out.println(romanToInt("MCMXCIV"));

	}

	public static int romanToInt(String s) {
		char[] c = s.toCharArray();
		int sum = 0;
		for (int i = 0; i < c.length; i++) {
			switch (c[i]) {
			case 'M':
				sum += 1000;
				break;
			case 'D':
				sum += 500;
				break;
			case 'C':
				if (i + 1 < c.length && (c[i + 1] == 'D' || c[i + 1] == 'M')) {
					sum -= 100;
				} else {
					sum += 100;
				}
				break;
			case 'L':
				sum += 50;
				break;
			case 'X':
				if (i + 1 < c.length && (c[i + 1] == 'L' || c[i + 1] == 'C')) {
					sum -= 10;
				} else {
					sum += 10;
				}
				break;
			case 'V':
				sum += 5;
				break;
			case 'I':
				if (i + 1 < c.length && (c[i + 1] == 'V' || c[i + 1] == 'X')) {
					sum -= 1;
				} else {
					sum += 1;
				}
				break;
			}
		}
		return sum;
    }
	
	public static int romanToInt_3(String s) {
		int i = 0;
		for (int j = 0; j < s.length(); j++) {
			if ('I' == s.charAt(j)) {
				i += 1;
				if (j + 1 < s.length()) {
					if ('V' == s.charAt(j + 1)) {
						i += 5 - 2;
						j++;
						continue;
					} else if ('X' == s.charAt(j + 1)) {
						i += 9 - 2;
						j++;
						continue;
					}
				}
			} else if ('V' == s.charAt(j)) {
				i += 5;
			} else if ('X' == s.charAt(j)) {
				i += 10;
				if (j + 1 < s.length()) {
					if ('L' == s.charAt(j + 1)) {
						i += 50 - 20;
						j++;
						continue;
					} else if ('C' == s.charAt(j + 1)) {
						i += 100 - 20;
						j++;
						continue;
					}
				}
			} else if ('L' == s.charAt(j)) {
				i += 50;
			} else if ('C' == s.charAt(j)) {
				i += 100;
				if (j + 1 < s.length()) {
					if ('D' == s.charAt(j + 1)) {
						i += 500 - 200;
						j++;
						continue;
					} else if ('M' == s.charAt(j + 1)) {
						i += 1000 - 200;
						j++;
						continue;
					}
				}
			} else if ('D' == s.charAt(j)) {
				i += 500;
			} else if ('M' == s.charAt(j)) {
				i += 1000;
			}
		}
		return i;
	}

	public static int romanToInt_2(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int i = 0;
		for (int j = 0; j < s.length(); j++) {
			i = i + map.get(s.charAt(j));
			if (j + 1 < s.length()) {
				if ('I' == s.charAt(j)) {
					if ('V' == s.charAt(j + 1) || 'X' == s.charAt(j + 1)) {
						i = i + map.get(s.charAt(j + 1)) - 2 * map.get(s.charAt(j));
						j++;
						continue;
					}
				} else if ('X' == s.charAt(j)) {
					if ('L' == s.charAt(j + 1) || 'C' == s.charAt(j + 1)) {
						i = i + map.get(s.charAt(j + 1)) - 2 * map.get(s.charAt(j));
						j++;
						continue;
					}
				}
				if ('C' == s.charAt(j)) {
					if ('D' == s.charAt(j + 1) || 'M' == s.charAt(j + 1)) {
						i = i + map.get(s.charAt(j + 1)) - 2 * map.get(s.charAt(j));
						j++;
						continue;
					}
				}
			}
		}
		return i;
	}

	public static int romanToInt_1(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int i = 0;
		for (int j = 0; j < s.length(); j++) {
			if (map.containsKey(s.charAt(j))) {
				if ('V' == s.charAt(j) && j - 1 >= 0 && 'I' == s.charAt(j - 1)) {
					i = i + map.get(s.charAt(j)) - 2 * map.get(s.charAt(j - 1));
				} else if ('X' == s.charAt(j) && j - 1 >= 0 && 'I' == s.charAt(j - 1)) {
					i = i + map.get(s.charAt(j)) - 2 * map.get(s.charAt(j - 1));
				} else if ('L' == s.charAt(j) && j - 1 >= 0 && 'X' == s.charAt(j - 1)) {
					i = i + map.get(s.charAt(j)) - 2 * map.get(s.charAt(j - 1));
				} else if ('C' == s.charAt(j) && j - 1 >= 0 && 'X' == s.charAt(j - 1)) {
					i = i + map.get(s.charAt(j)) - 2 * map.get(s.charAt(j - 1));
				} else if ('D' == s.charAt(j) && j - 1 >= 0 && 'C' == s.charAt(j - 1)) {
					i = i + map.get(s.charAt(j)) - 2 * map.get(s.charAt(j - 1));
				} else if ('M' == s.charAt(j) && j - 1 >= 0 && 'C' == s.charAt(j - 1)) {
					i = i + map.get(s.charAt(j)) - 2 * map.get(s.charAt(j - 1));
				} else {
					i = i + map.get(s.charAt(j));
				}
			}
		}
		return i;
	}

}
