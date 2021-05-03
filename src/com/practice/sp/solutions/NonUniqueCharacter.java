package com.practice.sp.solutions;

import java.util.HashSet;
import java.util.Set;

public class NonUniqueCharacter {
	public static void main(String[] args) {
		String s = "aaabcffgg";
		nonUniqueCharacter(s);
		uniqueCharacter(s);
	}

	private static void nonUniqueCharacter(String s) {
		Set<Character> a = new HashSet<>();
		Set<Character> b = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);

			if(a.contains(cur)) b.add(cur);
			else a.add(cur);
		}

		System.out.println(b);
	}

	private static void uniqueCharacter(String s) {
		Set<Character> a = new HashSet<>(); //a
		Set<Character> b = new HashSet<>(); //a

		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);

			if(!a.contains(cur)) {
				a.add(cur);
				b.add(cur);
			} else if(a.contains(cur)) {
				b.remove(cur);
			}
		}

		System.out.println(b);
	}
}
