package com.beginnerlevel.coding;

public class AtoI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("A man, a plan, a canal: Panama"));
		System.out.println(myAtoi("934"));
		System.out.println(myAtoi("-934"));
		System.out.println(myAtoi("   010"));
		System.out.println(myAtoi("  010 934"));
		System.out.println(myAtoi(" "));
		System.out.println(myAtoi("-"));
		System.out.println(myAtoi("+"));
		System.out.println(myAtoi("+-"));
		System.out.println(myAtoi("+-2"));
		System.out.println(myAtoi("2147483646"));
		System.out.println(myAtoi("3.34"));
	}

	public static int myAtoi_Index(String str) {
		str = str.trim();
		int index = 0, sign = 1, total = 0;
		// 1. Empty string
		if (str.length() == 0)
			return 0;

		// 2. Remove Spaces
		while (str.charAt(index) == ' ' && index < str.length())
			index++;

		// 3. Handle signs
		if (str.charAt(index) == '+' || str.charAt(index) == '-') {
			sign = str.charAt(index) == '+' ? 1 : -1;
			index++;
		}

		// 4. Convert number and avoid overflow
		while (index < str.length()) {
			int digit = str.charAt(index) - '0';
			if (digit < 0 || digit > 9)
				break;

			// check if total will be overflow after 10 times and add digit
			if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

			total = 10 * total + digit;
			index++;
		}
		return total * sign;
	}

	public static int myAtoi_charCode(String str) {
		boolean neg = false;
		long result = 0;
		boolean readingDig = false;
		for (int i = 0; i < str.length(); i++) {
			char s = str.charAt(i);
			if (s == '-' && !readingDig) {
				neg = true;
				readingDig = true;
			} else if (s == '+' && !readingDig) {
				readingDig = true;
			} else if (s > 47 && s < 58) {
				readingDig = true;
				result = result * 10;
				result += (s - '0');
			} else if (s != 32 || readingDig) {
				break;
			}
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
				if (neg) {
					return Integer.MIN_VALUE;
				} else {
					return Integer.MAX_VALUE;
				}
			}
		}
		if (neg) {
			result = result * -1;
		}
		return (int) result;
	}

	public static int myAtoi(String s) {
		if (s.length() == 0)
			return 0;

		char[] map = new char[256];
		for (int i = 0; i < 10; i++) {
			map[i + '0'] = (char) (1 + i);
		}

		map['-'] = (char) (1 + 11);
		map['+'] = (char) (1 + 12);
		map[' '] = (char) (1 + 13);

		if (map[s.charAt(0)] == 0)
			return 0;

		char[] numMap = new char[256];
		for (int i = 0; i < 10; i++) {
			numMap[i + '0'] = (char) (1 + i);
		}

		char c = s.charAt(0);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (numMap[c] != 0)
				sb.append(c);
		}

		if (sb.toString().isEmpty())
			return 0;

		char[] numSymbolMap = new char[256];
		for (int i = 0; i < 10; i++) {
			numSymbolMap[i + '0'] = (char) (1 + i);
		}

		numSymbolMap['-'] = (char) (1 + 11);
		numSymbolMap['+'] = (char) (1 + 12);

		sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (numSymbolMap[c] != 0)
				sb.append(c);
		}

		char whiteSpace = ' ';
		int ws = whiteSpace;

		char[] symbolMap = new char[256];
		symbolMap['-'] = (char) (1 + 11);
		symbolMap['+'] = (char) (1 + 12);

		if (symbolMap[sb.charAt(0)] != 0 && symbolMap[sb.charAt(1)] != 0)
			return 0;

		sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if (sb.length() == 0 && ws != s.charAt(i) && map[s.charAt(i)] == 0)
				return 0;
			if (i > 0 && sb.length() > 0 && numMap[s.charAt(i)] == 0) {
				if (symbolMap[s.charAt(i - 1)] != 0)
					return 0;
				if (numMap[s.charAt(i - 1)] != 0)
					break;
			}
			if (map[s.charAt(i)] != 0) {
				if (ws != s.charAt(i))
					sb.append(s.charAt(i));
			} else
				break;
		}

		Double result = (Double) 0.0;
		if (!sb.toString().isEmpty()) {

			result = Double.parseDouble(sb.toString());
		}
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return Integer.parseInt(sb.toString());
	}
}
