package com.beginnerlevel.coding;

import org.apache.commons.lang3.StringUtils;

public class StringLongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = new String[] {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs));
		strs = new String[] {"flower","foow","flight"};
		System.out.println(longestCommonPrefix(strs));
		strs = new String[] {"flower","flow",""};
		System.out.println(longestCommonPrefix(strs));
	}
	public static String longestCommonPrefix_1(String[] strs) {
		String result = "";
		result  = StringUtils.getCommonPrefix(strs);
		return result;
	}
	public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        StringBuilder s = new StringBuilder();        
        int j=0;
        int k=0;
        while(k<strs[0].length()){
            char c = strs[0].charAt(k);
            for(int i=0;i<strs.length;i++){
                if(j<strs[i].length() && c == strs[i].charAt(j)){
                    if(i == strs.length-1){
                        s = s.append(c);
                        j++;
                        k++;
                    }
                } else {
                	k = strs[0].length();
                    break;
                }
            }
        }
        return s.toString();   
	}
		

}
