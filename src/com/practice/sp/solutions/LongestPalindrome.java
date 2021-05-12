package com.practice.sp.solutions;

import java.util.LinkedHashSet;
import java.util.Set;

public class LongestPalindrome {

	int maxLength = 0;
	int rs = -1;

	private void longestPalindrome(String s) { //ramabccba
		Set<String> palindromes = new LinkedHashSet<>();

		for (int i = 0; i < s.length() - 1; i++) {
			expandRange(s, i, i, palindromes);
			expandRange(s, i, i + 1, palindromes);
		}

		String result = s.substring(rs, rs + maxLength);

		System.out.println("longest palindrome: " + result);
		System.out.println("all palindromes: " + palindromes);
	}

	private void expandRange(String s, int start, int end, Set<String> palindromes) {
		while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			palindromes.add(s.substring(start, end + 1));

			start--;
			end++;

		}

		if(end - start - 1 > maxLength) {
			maxLength = end - start - 1;
			rs = start + 1;
		}
	}

	public static void main(String[]  args) {
		LongestPalindrome lp = new LongestPalindrome();
		lp.longestPalindrome("ramabccba");
	}
}
