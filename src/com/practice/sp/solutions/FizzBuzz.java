package com.practice.sp.solutions;

/**
 * if n % 5 == 0; print Fizz
 * if n % 3 == 0; print Buzz
 * if n % 5 && n && 3 == 0; print FizzBuzz
 * 1 <= n <= 100
 */

public class FizzBuzz {

	public static void main(String args[]) {
		int n = 20;
		int fizz = 0, buzz = 0;
		for(int i = 1; i <= n; i++) {
			String data = "";
			fizz++; buzz++;
			if(fizz == 5) {
				data += "Fizz";
				fizz = 0;
			}
			if(buzz == 3) {
				data += "Buzz";
				buzz = 0;
			}
			if(data.isEmpty()) {
				System.out.println(i);
			} else
				System.out.println(data);
		}

	}
}
