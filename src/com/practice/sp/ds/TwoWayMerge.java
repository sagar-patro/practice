package com.practice.sp.ds;

import java.util.Arrays;

public class TwoWayMerge {
	public static int[] merge(int[] a, int[] b) {
		int i= 0; int j= 0; int k = 0;
		int[] c = new int[a.length + b.length];

		while(i < a.length && j < b.length) {
			if(a[i] < b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}

		for (;  i < a.length ; i++) c[k++] = a[i];
		for (;  j < b.length ; j++) c[k++] = b[j];
		return c;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 6, 7};
		int[] b = {3, 4, 8, 9, 10};

		System.out.println(
				Arrays.stream(merge(a, b)).boxed()
						.map(String::valueOf)
						.reduce((i, j) -> i + ", " + j)
		);
	}
}
