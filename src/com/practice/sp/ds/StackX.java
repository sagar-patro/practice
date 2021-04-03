package com.practice.sp.ds;

public class StackX<E> {
	private E[] elems;
	private int size;
	private int top;

	public StackX(int size) {
		this.size = size;
		this.elems = (E[]) new Object[size];
		this.top = -1;
	}
	private boolean isFull() {
		return top == size - 1;
	}
	public boolean isEmpty() {
		return top == -1;
	}

	public boolean push(E e) {
		if(this.isFull()) return false;
		elems[++top] = e;
		return true;
	}
	public E pop() {
		if(this.isEmpty()) return null;
		return elems[top--];
	}
	public E peek() {
		return elems[top];
	}
	public static String reverse(String s) {
		StackX<Character> stack = new StackX<>(s.length());
		for (int i = 0; i < s.length(); i++) {
			stack.push(s.charAt(i));
		}

		StringBuffer reverse = new StringBuffer();
		while(!stack.isEmpty()) {
			reverse.append(stack.pop());
		}
		return reverse.toString();
	}

	public static void main(String[] args) {
		System.out.println(reverse("sagar patro"));
	}
}
