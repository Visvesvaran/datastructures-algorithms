package com.beginnerlevel.coding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram_3("tab","bat"));
	}
	public static boolean isAnagram_3(String s, String t) {
		 if(s.length() != t.length()) return false;
	        int[] map = new int[128];
	        for(char c: s.toCharArray())
	            map[c]++;
	        for(char c: t.toCharArray())
	            map[c]--;
	        for(int i: map)
	            if(i != 0)
	                return false;
	        return true;
	}
	public static boolean isAnagram_2(String s, String t) {
		if(s.length()!=t.length()) return false;
        char[] sCharArray = s.toCharArray();
        Arrays.sort(sCharArray);
        char[] tCharArray = t.toCharArray();
        Arrays.sort(tCharArray);
        for(int i=0;i<s.length();i++){
            if(sCharArray[i] != tCharArray[i]) return false;
        }
        return true;
	}
	 public static boolean isAnagram_1(String s, String t) {
	        List<Character> charList = new LinkedList<>();
	        if(s.length() == t.length()){
	            for(int i=0;i<s.length();i++){
	                charList.add(s.charAt(i));
	            }
	            for(int i=0;i<t.length();i++){
	                charList.remove(charList.indexOf(t.charAt(i)));
	            }
	            if(charList.isEmpty()) return true;
	        }
	        return false;
	    }

}
