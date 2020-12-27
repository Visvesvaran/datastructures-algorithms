package com.beginnerlevel.coding;

import org.apache.commons.lang3.StringUtils;

/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)

The above arrows point to positions where the corresponding bits are different. 
 */
public class HammingDistance {

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
		System.out.println(hammingDistance(680142203, 1111953568));
	}

	public static int hammingDistance(int x, int y) {
		// n&(1<<i)
		for (int i = 0; i < 32; i++) {
			System.out.println((1 << i));
			System.out.println(x&(1 << i));
			System.out.println(y&(1 << i));
		}
		int c=0;
		for(int i=0;i<32;i++){
            if((x&(1 << i))>0 != (y&(1 << i))>0)
                c++;
        }
		return c;
	}

	public static int hammingDistance_1(int x, int y) {
		int c = 0;
		String x1 = "";
		String y1 = "";
		if (Integer.toBinaryString(x).length() > Integer.toBinaryString(y).length()) {
			x1 = Integer.toBinaryString(x);
			y1 = Integer.toBinaryString(y);
		} else {
			x1 = Integer.toBinaryString(y);
			y1 = Integer.toBinaryString(x);
		}
		x = 0;
		y = 0;
		for (; x < x1.length() - y1.length(); x++) {
			if (x1.charAt(x) != '0') {
				c++;
			}
		}
		while (x < x1.length() && y < y1.length()) {
			if (x1.charAt(x) != y1.charAt(y)) {
				c++;
			}
			x++;
			y++;
		}
		return c;
	}

	public static String intToBinary(int n) {
		String s = "";
		while (n > 0) {
			s = ((n % 2) == 0 ? "0" : "1") + s;
			n = n / 2;
		}
		return s;
	}
}
