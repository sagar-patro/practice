package com.practice.sp.solutions;

import java.util.HashMap;
import java.util.Map;

public class StringRelated {
	
	public static void main(String args[]) {

	}

	public static boolean isPalindrome(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			char left = s.charAt(i);
			char right = s.charAt(j);

			if(left != right) return false;
		}
		return true;
	}

	public static boolean areAnagram(String s1, String s2) {
		if(s1.length() != s2.length()) return false;

		Map<Character, Integer> count = new HashMap<>();
		for (char c: s1.toCharArray()) {

			if(count.containsKey(c)) {
				int v = count.get(c);
				count.put(c, ++v);
			} else {
				count.put(c, 1);
			}
		}

		for (char c: s2.toCharArray()) {

			if(!count.containsKey(c)) {
				return false;
			}
			if(count.containsKey(c)) {
				int v = count.get(c);
				count.put(c, --v);
			}
		}

		return count.entrySet().stream().noneMatch(e -> e.getValue() > 0);
	}
}
