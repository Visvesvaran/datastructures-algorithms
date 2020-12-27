package com.beginnerlevel.coding;

public class MathPowerOfThree {

	public static void main(String[] args) {
		System.out.println(isPowerOfThree(27));
		System.out.println(isPowerOfThree(45));
	}
	public static boolean isPowerOfThree(int n) {
		System.out.println(Math.log10(n) / Math.log10(3));
		return (Math.log10(n) / Math.log10(3)) % 1 == 0;
	}
	public static boolean isPowerOfThree_1(int n) {
		for(int i=0;i<n;i++){
			if(Math.pow(3,i)>3)
				return false;
            if(n == Math.pow(3,i))
                return true;
        }
        return false;
    }
	
}
