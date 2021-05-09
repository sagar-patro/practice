package com.practice.sp.solutions;

import java.util.Arrays;

public final class Math {

	public static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a%b);
	}

	//Finds prime numbers with in the range
	public static boolean[] sieveOfEratosthenes(int range) {
		boolean[] isPrime = new boolean[range + 1];
		Arrays.fill(isPrime, true);

		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i*i < range; i++) {
			for (int j = 2*i; j <= range; j+=i) {
				isPrime[j] = false;
			}
		}

		return isPrime;
	}

	public static void main(String[] args) {
		System.out.println(gcd(18, 21));

		boolean[] primes = sieveOfEratosthenes(200);
		for (int i = 0; i < primes.length; i++) {
			System.out.println(i + ": " + primes[i]);
		}


	}
}
