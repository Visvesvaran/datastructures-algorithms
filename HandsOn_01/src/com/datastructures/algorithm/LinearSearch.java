package com.datastructures.algorithm;

/*
DECLARE INTEGER i, srch = ...
DECLARE INTEGER x[] = [ ... ]
FOR i = 0 TO LENGTH(x) - 1
   IF x[i] EQ srch THEN
      PRINT "Found ", srch
      END
   END IF
NEXT i
PRINT "Not found", srch
END
*/

public class LinearSearch {
	public static void oneDimensionalArray(int linearSearch, int[] x) {
		System.out.println("LinearSearch");
		boolean found = false;
		for (int i = 0; i < x.length; i++) {
			if(linearSearch == x[i]) {
				found = true;
				System.out.println("Found "+linearSearch);
				break;
			} 
		}
		if (found == false) {
			System.out.println("Not found "+linearSearch);
		}
	}
}
