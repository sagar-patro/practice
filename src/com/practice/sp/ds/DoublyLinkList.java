package com.practice.sp.ds;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

public class DoublyLinkList<E> {
	private final static Logger log =
			Logger.getLogger(DoublyLinkList.class.getName());
	private Node<E> first;
	private Node<E> last;
	private long size;

	private static class Node<E> {
		Node<E> prev;
		E data;
		Node<E> next;
		Node(Node<E> prev, E data, Node<E> next) {
			this.prev = prev;
			this.data = data;
			this.next = next;
		}
		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append("{");
			sb.append(prev != null ? prev.data : null).append(", ");
			sb.append(data).append(", ");
			sb.append(next != null ? next.data : null);
			sb.append("}");
			return sb.toString();
		}
	}

	public boolean add(E e) {
		addFirst(e);
		return true;
	}
	public E remove() {
		return removeFirst();
	}

	private void addFirst(E e) {
		Node<E> temp = first;
		Node<E> newNode = new Node<>(null, e, temp);
		first = newNode;

		if(temp == null) last = newNode;
		else temp.prev = newNode;
		size++;
	}
	public void addLast(E e) {
		Node<E> temp = last;
		Node<E> newNode = new Node<>(last, e, null);
		last = newNode;
		if(temp == null) first = newNode;
		else temp.next = newNode;
		size++;
	}

	private E removeFirst() {
		Node<E> temp = first;
		if(temp == null)  throw new NoSuchElementException("Linked list is empty");
		first = first.next;
		first.prev = null;
		size--;
		return temp.data;
	}
	public E removeLast() {
		Node<E> temp = last;
		if(temp == null) throw new NoSuchElementException("Linked list is empty");

		Node<E> prev = last.prev;
		last = prev;
		if(prev == null) first = null;
		else last.next = null;
		return temp.data;
	}

	public String toString() {
		if(first == null) return "[]";
		StringBuffer sb = new StringBuffer();
		sb.append("[");

		for(Node<E> x = first; x != null; x = x.next) {
			sb.append(x.toString());
		}
		sb.append(", ").append("]");
		return sb.toString();
	}


	public static void main(String[] args) {
		DoublyLinkList<Integer> doublyLinkList = new DoublyLinkList<>();
		doublyLinkList.add(3);
		doublyLinkList.add(2);
		doublyLinkList.add(1);
		doublyLinkList.addLast(4);

		doublyLinkList.remove();
		doublyLinkList.removeLast();

		log.info(doublyLinkList.toString());
	}
}
