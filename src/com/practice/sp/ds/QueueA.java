package com.practice.sp.ds;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QueueA<E> {
	private E[] data;
	private int maxSize;
	private int front;
	private int rear;

	public QueueA(int maxSize) {
		data = (E[])new Object[maxSize];

		this.maxSize = maxSize;
		front = -1;
		rear = -1;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		sb.append(Arrays.stream(data).map(String::valueOf)
				.reduce((a, b) -> new StringBuffer().append(a).append(", ").append(b).toString())
				.orElse(""))
		.append("]");
		return sb.toString();
	}
	public int size() { return rear + 1; }
	public boolean add(E e) {
		if(front == -1 && rear == -1) {
			data[++rear] = e;
			front++;
			return true;
		} else {
			if(rear < maxSize - 1) {
				data[++rear] = e;
				return true;
			}
		}
		return false;
	}

	public E remove() {
		if(front == -1 && rear == -1) return null;
		if(front == rear) {
			E e = data[front];
			front = -1;
			rear = -1;
			return e;
		}
		return data[front++];
	}

	public static void main(String[] args) {
		QueueA<Integer> q = new QueueA<>(5);
		IntStream.range(0, 10).boxed().forEach(q::add);

		System.out.println(q.toString());
		System.out.println(q.size());


	}

}
