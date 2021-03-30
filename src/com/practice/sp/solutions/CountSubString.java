package com.practice.sp.solutions;

import java.util.Arrays;

//Find count of sub-string in a string
public class CountSubString {

	public static void SubString(String str, String match)
	{
		//#1
		System.out.println(Arrays.asList("abcddbbabchfgrggh".split("abc")));

		//#2
		int n = str.length();
		int count = 0;
		int m = match.length();
		for (int i = 0; i <= n - m; i++) {
			int endLimit = i + m > n ? n : i + m;
			if (match.equals(str.substring(i, endLimit))) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args)
	{
		String str = "abcddbb abchfgrggh";
		SubString(str, "abc");
	}
}
