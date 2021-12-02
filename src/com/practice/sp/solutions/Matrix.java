package com.practice.sp.solutions;

import java.util.Arrays;

public class Matrix {
	public static void main(String args[]) {
		int[][] matrix = new int[3][3];

		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 4;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;

		Arrays.stream(calculateSumOfAllDiagonals(matrix)).boxed().map(String::valueOf)
				.reduce((a, b)-> a + ", " + b).ifPresent(System.out::println);

		Arrays.stream(sumOfDiagonals(matrix)).boxed().map(String::valueOf)
				.reduce((a, b)-> a + ", " + b).ifPresent(System.out::println);

		rotate(matrix);
	}



	private static int[] calculateSumOfAllDiagonals(int[][] m) {
		int[] result = new int[m.length*2 - 1];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length ; j++) {
				result[i+j] += m[i][j];
			}
		}
		return result;
	}

	private static int[] sumOfDiagonals(int[][] m) {
		int psum = 0;
		int ssum = 0;
		for (int i = 0; i < m.length; i++) {
			psum += m[i][i];
			ssum += m[i][m.length - i - 1];
		}

		return new int[] {psum, ssum};
	}

	//Transpose + reverse
	public static void rotate(int[][] m) {
		int[][] n = new int[m.length][m.length];

		//Transpose
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m.length; j++) {
				n[j][i] = m[i][j];
			}
		}

		//reverse
		for(int i = 0; i < m.length; i++) {
			for(int j = m.length - 1; j >= 0; j--) {
				m[i][m.length - 1 - j] = n[i][j];
			}
		}

		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m.length; j++) {
				System.out.print(m[i][j] + ", ");
			}
			System.out.println();
		}

	}
}
