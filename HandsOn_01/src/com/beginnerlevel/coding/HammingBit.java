package com.beginnerlevel.coding;

/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

But I think it's also useful to note that ^ is just one of a family of operators that are collectively known as bitwise operators:

Operator    Name         Example     Result  Description
a & b       and          3 & 5       1       1 if both bits are 1.
a | b       or           3 | 5       7       1 if either bit is 1.
a ^ b       xor          3 ^ 5       6       1 if both bits are different.
~a          not          ~3          -4      Inverts the bits.
n << p      left shift   3 << 2      12      Shifts the bits of n left p positions. Zero bits are shifted into the low-order positions.
n >> p      right shift  5 >> 2      1       Shifts the bits of n right p positions. If n is a 2's complement signed number, the sign bit is shifted into the high-order positions.
n >>> p     right shift  -4 >>> 28   15      Shifts the bits of n right p positions. Zeros a
*/
public class HammingBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingDistance(1, 4));
	}

	public static int hammingDistance(int x, int y) {
		int xor = x ^ y; 
	    int setBits = 0; 
	  
	    while (xor > 0)  
	    { 
	        setBits += xor & 1; 
	        xor >>= 1; 
	    } 
	  
	    return setBits;
	}
	
	public static String intToBinary(int n)
	{
	    String s = "";
	    while (n > 0)
	    {
	        s =  ( (n % 2 ) == 0 ? "0" : "1") +s;
	        n = n / 2;
	    }
	    return s;
	}

}
