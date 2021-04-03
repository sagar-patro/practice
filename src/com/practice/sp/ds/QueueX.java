package com.practice.sp.ds;

import java.util.logging.Logger;
import java.util.stream.IntStream;

public class QueueX<E> {
	private static final Logger log =
			Logger.getLogger(QueueX.class.getName());
	private DoublyLinkList<E> data;
	private int maxSize;
	private int size;

	public QueueX(int maxSize) {
		this.data = new DoublyLinkList<>();
		this.maxSize = maxSize;
		this.size = 0;
	}
	public int size() {
		return this.size;
	}

	public boolean add(E e) {
		if(size == maxSize) return false;
		data.addLast(e);
		size++;
		return true;
	}
	public E remove(){
		if(size == 0) return null;
		size--;
		return data.remove();
	}
	@Override
	public String toString() {
		return data.toString();
	}

	public static void main(String[] args) {
		QueueX<Integer> q = new QueueX<>(10);
		IntStream.range(0, 10).boxed().forEach(q::add);

		log.info(q.toString());

	}
}
