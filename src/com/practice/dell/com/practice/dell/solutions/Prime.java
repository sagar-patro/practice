package com.practice.dell.com.practice.dell.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Prime {

	public static void main(String args[]) {
		List<Integer> nums = new ArrayList<>();
		for(int i = 1; i <= 100000; i++) {
			nums.add(i);
		}
		long t1 = System.currentTimeMillis();
		nums.stream()
				.filter(e -> isPrime(e, Math.sqrt(e)))
				.collect(Collectors.toList());
		long t2 = System.currentTimeMillis();

		System.out.println("square root: " + (t2-t1));

		t1 = System.currentTimeMillis();

		nums.stream()
				.filter(Prime::isPrime2)
				.collect(Collectors.toList());
		t2 = System.currentTimeMillis();

		System.out.println("Regular: " + (t2-t1));
	}

	//o(sqrt(n))
	static boolean isPrime(int num, double n) {
		if(num <= 1) {return false;}
		if(num <= 3) {return true;}
		if(num % 2 == 0 || num % 3 == 0) {return false;}

		for(int i = 5; i <= n; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

	//o(n)
	public static boolean isPrime2(int num) {
		if(num <= 1) {return false;}
		if(num <= 3) {return true;}
		if(num % 2 == 0 || num % 3 == 0) {return false;}
		for(int i = 5; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}



}
