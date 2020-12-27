package com.beginnerlevel.coding;

public class q2 {
	public static void main(String[] args) {
		String s = "Strawberry";
		int k = 5;
		System.out.println(s.length());
		String s1 = s.substring(2, 5);
		System.out.println(s1);
		System.out.println(s1.length());
		String s2 = s.substring(k, s.length());
		System.out.println(s2);
		System.out.println(s2.length());

	}
}
