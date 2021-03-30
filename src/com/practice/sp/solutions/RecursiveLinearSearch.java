package com.practice.sp.solutions;

public class RecursiveLinearSearch {
	public static void main(String args[]) {
		int a[] = {1,2,3,4,6,5};
		System.out.println("Result = " + recursiveLinearSearch(a, 0, 8));
	}

	private static int recursiveLinearSearch(int[] a, int index, int x) {
		if(index >= a.length) {return -1;}
		if(a[index] == x) {
			return index;
		}
		return recursiveLinearSearch(a, index + 1, x);
	}
}
