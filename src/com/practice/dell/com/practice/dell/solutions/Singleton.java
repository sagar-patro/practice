package com.practice.dell.com.practice.dell.solutions;

public class Singleton {
	private static class Holder {
		private static Singleton singleton = new Singleton();
	}

	private Singleton() {}

	public static Singleton getInstance() {
		return Holder.singleton;
	}
}
