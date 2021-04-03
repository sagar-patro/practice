package com.practice.sp.solutions;

public class MedianSortedArrays {
	public static double findMedianSortedArrays(int[] a, int[] b) {
		int n = a.length + b.length;
		Integer[] median = new Integer[2];
		if(n % 2 != 0) {
			median[0] = n/2;
		} else {
			median[0] = (n - 1)/2;
			median[1] = (n + 1)/2;
		}

		int[] c = mergeArray(a, b, median);

		if(median[1] == null) {
			return c[c.length - 1];
		} else {
			return (c[c.length - 1] + c[c.length - 2])/2.0;
		}

	}

	public static int[] mergeArray(int[] a, int[] b, Integer[] median) {
		int i = 0;
		int j = 0;
		int k = 0;
		int range;
		if(null != median[1]) range = median[1] + 1;
		else range = median[0] + 1;

		int[] c = new int[range];

		while(i < a.length
				&& j < b.length
				&& k < range) {
			if(a[i] < b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}

		for (;  i < a.length && k < range ; i++) c[k++] = a[i];
		for (;  j < b.length && k < range ; j++) c[k++] = b[j];
		return c;
	}

	public static void main(String[] args) {
		int[] a = new int[]{1, 3};
		int[] b = new int[] {2};
		System.out.println(findMedianSortedArrays(a, b));
	}
}
