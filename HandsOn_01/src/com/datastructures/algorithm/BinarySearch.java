package com.datastructures.algorithm;

public class BinarySearch {

	public static void binary(int search, int[] x) {
		System.out.println("BinarySearch");

		int lIndex = 0;
		int hIndex = x.length - 1;
		int shiftIndexBy = 0;
		int mIndex = (int) Math.floor((double) (hIndex - lIndex) / 2);

		while (search != x[mIndex] && search >= x[0] && search <= x[x.length - 1]) {
			if (search < x[mIndex]) {
				hIndex = mIndex - 1;
				shiftIndexBy = (int) Math.floor((double) (hIndex - lIndex) / 2);
				mIndex = hIndex - shiftIndexBy;
			} else if (search > x[mIndex]) {
				lIndex = mIndex + 1;
				shiftIndexBy = (int) Math.floor((double) (hIndex - lIndex) / 2);
				mIndex = lIndex + shiftIndexBy;
			}
		}

		if (search == x[mIndex]) {
			System.out.println("Found " + search);
		} else {
			System.out.println("Not found " + search);
		}
	}

}
