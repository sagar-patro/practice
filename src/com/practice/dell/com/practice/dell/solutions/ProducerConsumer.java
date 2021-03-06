package com.practice.dell.com.practice.dell.solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

	public static void main(String[] args) {

		MyQueue<Integer> myQueue = new MyQueue<>();
		Runnable producer = () -> {
			try {
				while(true) {
					myQueue.put(2);
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(producer);
		t1.start();
		t2.start();

		Runnable consumer = () -> {
			try {
				while(true) {
					System.out.print(myQueue.take());
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread t3 = new Thread(consumer);
		t3.start();

	}

}

class MyQueue<E> {
	private Queue<E> queue;
	private int max = 10;
	private ReentrantLock lock = new ReentrantLock(true);

	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();


	public MyQueue() {
		queue = new LinkedList<>();
	}

	public void put(E e) throws InterruptedException {
		lock.lock();
		try {
			while(queue.size() == max) {
				notFull.await();
			}
			queue.add(e);
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}

	}

	public E take() throws InterruptedException {
		lock.lock();
		try {
			while(queue.isEmpty()) {
				notEmpty.await();
			}
			E e = queue.poll();
			notFull.signalAll();
			return e;
		} finally {
			lock.unlock();
		}
	}
}
