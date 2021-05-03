package com.practice.sp.solutions;

public class CountOccurrence {
	public static void main(String[] args) {
		countOccurrence("asaasassa");
	}

	private static void countOccurrence(String s) {

		StringBuffer sb = new StringBuffer();

		int count = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			char current = s.charAt(i);
			char next = s.charAt(i + 1);

			if(count == 1) sb.append(current);

			if(current == next) {
				count++;
			} else if(count > 1) {
				sb.append(count);
				count = 1;
			}
		}
		if(count > 1) sb.append(count);
		else sb.append(
				s.charAt(s.length() - 1)
		);

		System.out.println(sb.toString()); //asa2sas2a
	}
}
