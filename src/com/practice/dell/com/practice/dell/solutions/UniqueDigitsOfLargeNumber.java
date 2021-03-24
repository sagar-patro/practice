package com.practice.dell.com.practice.dell.solutions;

import java.util.Scanner;

public class UniqueDigitsOfLargeNumber {


	private static StringBuffer uniqueDigits(final String input) {
		if(null == input) return null;
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < input.length(); i++) {
			if(!contains(result, input.charAt(i))) {
				result.append(input.charAt(i));
			}
		}
		return result;
	}

	private static boolean contains(StringBuffer source, char c) {
		for (int i = 0; i < source.length(); i++) {
			if(c == source.charAt(i)) return true;
		}
		return false;
	}

	private static Long largestNumber(StringBuffer input) {
		if(null == input || input.length() == 0) {return null;}

		StringBuffer result = new StringBuffer();
		long largest = 0;
		char hash = '#';
		for (int i = 0; i < input.length(); i++) {

			int indexToReplace = 0;
			for (int j = 0; j < input.length(); j++) {
				if (hash == input.charAt(j)) continue;

				Long temp = Long.valueOf(String.valueOf(input.charAt(j)));
				if (temp > largest) {
					indexToReplace = j;
					largest = temp;
				}
			}
			result.append(largest);
			largest = 0;
			input.setCharAt(indexToReplace, hash);
		}
		return Long.valueOf(result.toString());
	}

	public static void main(String[] args) {
		System.out.println("Enter a large number: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		StringBuffer uniqueDigits = uniqueDigits(input);
		System.out.println("Unique digits: " + uniqueDigits);

		Long result = largestNumber(uniqueDigits);
		System.out.println("Largest number: " + result);
	}
}
