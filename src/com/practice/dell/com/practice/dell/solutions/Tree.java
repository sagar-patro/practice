package com.practice.dell.com.practice.dell.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class Tree<E extends Comparable<E>> {
	private Node<E> root;

	public enum Traversal {
		PREORDER, INORDER, POSTORDER, BFS
	}

	private static class Node<E extends Comparable<E>> {
		private E data;
		private Node<E> left;
		private Node<E> right;
		Node(E data) {
			this.data = data;
		}
	}

	public boolean add(E e) {
		if(root == null) {
			root = insert(null, e);
		} else insert(root, e);
		return true;
	}

	private Node<E> insert(Node<E> current, E e) {
		if(current == null) {
			return new Node<>(e);
		}

		if(e.compareTo(current.data) < 0) {
			current.left = insert(current.left, e);
		} else if(e.compareTo(current.data) > 0) {
			current.right = insert(current.right, e);
		}
		return current;
	}

	public String traversal(Traversal traversal) {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		switch(traversal) {
			case PREORDER:
				preOrder(root, sb);
				break;
			case INORDER:
				inOrder(root, sb);
				break;
			case POSTORDER:
				postOrder(root, sb);
				break;
			case BFS:
				levelOrder(sb);
		}
		sb.append("]");
		return sb.toString();
	}

	private void preOrder(Node current, StringBuffer sb) {
		if(current == null) return;
		sb.append(current.data).append(", ");
		preOrder(current.left, sb);
		preOrder(current.right, sb);
	}
	private void inOrder(Node current, StringBuffer sb) {
		if(current == null) return;
		inOrder(current.left, sb);
		sb.append(current.data).append(", ");
		inOrder(current.right, sb);
	}
	private void postOrder(Node current, StringBuffer sb) {
		if(current == null) return;
		postOrder(current.left, sb);
		postOrder(current.right, sb);
		sb.append(current.data).append(", ");
	}

	private String levelOrder(StringBuffer sb) {
		if (root == null) return "";
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			Node current = queue.peek();
			sb.append(current.data).append(", ");
			if (current.left != null) queue.add(current.left);
			if (current.right != null) queue.add(current.right);
			queue.poll();
		}
		return sb.toString();
	}

	public int height() {
		return findHeight(root);
	}
	private int findHeight(Node root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		int[] nums = {6, 4, 8, 3, 5, 7, 9, 8};
//		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		for(int num : nums) {
			tree.add(num);
		}

		System.out.println("PREORDER: " + tree.traversal(Traversal.PREORDER));
		System.out.println("INORDER: " + tree.traversal(Traversal.INORDER));
		System.out.println("POSTORDER: " + tree.traversal(Traversal.POSTORDER));
		System.out.println("BFS: " + tree.traversal(Traversal.BFS));

		System.out.println("Tree height: "  + tree.height());
	}

}
