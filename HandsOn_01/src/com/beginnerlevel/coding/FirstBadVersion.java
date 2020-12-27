package com.beginnerlevel.coding;

public class FirstBadVersion {

	public static void main(String[] args) {
		int n = 2126753390;
		firstBadVersion(n);
	}
	public static int firstBadVersion(int n) {
		int s = 0;
        int e = n;
        while (s<e) {
            int mid = s + (e - s) / 2;
            
            if (isBadVersion(mid)) {
                e = mid;
            } else {
                s = mid+1;
            }
        }
        
        return e;
	}
	
	public static int firstBadVersion_1(int n) {
		int ok = -1;
        int ng = n;
        while (Math.abs(ok - ng) > 1) {
            int mid = ok + (ng - ok) / 2;
            
            if (isBadVersion(mid)) {
                ng = mid;
            } else {
                ok = mid;
            }
        }
        
        return ng;
	}
	public static int firstBadVersion_2(int n) {
		int m = 0;
		int previousM = 0;
		previousM = helper(n, previousM, (n-m)/2);
        for(int i = previousM; i<n;i++){
            if(isBadVersion(i)){
                return i;
            }
        }
        return n;
	}
	
	public static int helper(int n, int previousM, int m) {
		while((n-m)/2>0&&!isBadVersion(m)){
        	previousM = m;
            m = m + (n-m)/2;
        }
		if(n== previousM) {
			return previousM;
		} else {
		return helper(m, previousM, previousM + (m-previousM)/2);
		}
	}

	public static boolean isBadVersion(int n) {
		if(n >= 1702766719) {
			return true;
		} else {
			return false;
		}
	}
	

}
