package com.practice.dell.com.practice.dell.solutions;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Number of distinct anagrams in a word
public class Anagram {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			Map<String, Integer> ocr = findEachCharCount(str);
			BigInteger denominator =
					ocr.values().stream()
							.map(Anagram::factorial)
							.reduce(BigInteger.valueOf(1), BigInteger::multiply);
			BigInteger numerator = factorial(str.length());
			System.out.println(numerator.divide(denominator));
		}
	}

	private static BigInteger factorial(int n) {
		if(n == 1 || n == 0) { return BigInteger.valueOf(1); }
		return BigInteger.valueOf(n).multiply(factorial(n-1));
	}

	private static Map<String, Integer> findEachCharCount(String s) {
		Map<String, Integer> result = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			if(null != result.get(String.valueOf(s.charAt(i)))) {
				int c = result.get(String.valueOf(s.charAt(i)));
				result.put(String.valueOf(s.charAt(i)), ++c);
			} else {
				result.put(String.valueOf(s.charAt(i)), 1);
			}
		}
		return result;
	}
}
