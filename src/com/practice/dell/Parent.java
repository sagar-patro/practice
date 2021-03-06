package com.practice.dell;

public class Parent {

	int i = 0;

	private void test() {
		System.out.println(i);
	}

	public static void main(String args[]) {

		Parent p = new Child();
		new Parent().test();

	}
}
