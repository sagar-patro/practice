package com.practice.dell.com.practice.dell.solutions;

import java.util.logging.Logger;

public class LinkList<E> {
	private final static Logger log =
			Logger.getLogger(LinkList.class.getName());

	private Node<E> first;
	private Node<E> last;
	private long size;

	private static class Node<E> {
		E data;
		Node<E> next;

		Node(E data, Node next) {
			this.data = data;
			this.next = next;
		}

		public String toString(){
			StringBuffer sb = new StringBuffer();
			sb.append(data.toString())
					.append(", ");
			if(next != null) {
				return sb.append(next.toString()).toString();
			}
			return sb.toString();
		}
	}

	public long getSize() {
		return this.size;
	}
	public boolean add(E e) {
		addLast(e);
		return true;
	}
	public E remove() {
		return removeFirst();
	}
	public void removeAll() {
		first = null;
		last = null;
		size = 0;
	}
	private E removeFirst() {
		Node<E> result = first;
		if(result == null) {
			return null;
		} else {
			first = first.next;
		}
		size--;
		if(size == 0) {last = null;}
		return result.data;
	}

	private E removeLast() {
		if(first == null) {return null;}
		if(first.next == null) {
			E e = last.data;
			first = last = null;
			return e;
		}
		Node<E> current = first;
		Node<E> prev = null;
		while(current.next != null) {
			prev = current;
			current = current.next;
		}

		last = prev;
		last.next = null; //gotta test a bit more because of probable NPE
		return current.data;
	}

	private void addLast(E e) {
		Node<E> temp = last;
		Node<E> newNode = new Node<>(e, null);
		last = newNode;

		if(temp == null) {
			first = newNode;
		} else {
			temp.next = last;
		}
		size++;
	}

	public void addFirst(E e) {
		Node<E> temp = first;
		Node<E> newNode = new Node<>(e, temp);
		first = newNode;
		if(temp == null) {
			last = newNode;
		}
		size++;
	}

	public long find(E e) {
		if(first == null) return -1L;
		long index = 0;
		if(e == null) {
			for(Node x = first; x != null; x = x.next) {
				if(x.data == null) return index;
				index++;
			}
		} else {
			for(Node x = first; x != null; x = x.next) {
				if(e.equals(x.data)) return index;
				index++;
			}
		}
		return index;
	}

	public void reverseIterator() {
		if(first == null) {
			return;
		}
		last = first;
		Node<E> current = first;
		Node<E> previous = null;
		while(first.next != null) {
			first = current.next;
			current.next = previous;
			previous = current;
			current = first;
		}
		first.next = previous;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[")
				.append(null != first ? first.toString() : null)
				.append("]");
		return sb.toString();
	}

	public static void main(String[] args) {
		LinkList<Integer> linkedList = new LinkList<>();
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.addFirst(1);
		linkedList.addFirst(0);

		System.out.println(linkedList.find(4));

		log.info(linkedList.toString());
		linkedList.removeLast();
		linkedList.remove();
		linkedList.reverseIterator();

		log.info(linkedList.toString());

		log.info(linkedList.toString());
	}
}
