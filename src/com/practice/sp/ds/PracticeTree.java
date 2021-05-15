package com.practice.sp.ds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PracticeTree<E extends Comparable<E>> {
	private static class Node<E extends Comparable<E>> {
		private E data;
		private Node<E> left;
		private Node<E> right;
		Node(E data) {
			this.data = data;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("[")
					.append(left != null ? left.data: null)
					.append(", ")
					.append(data).append(", ")
					.append(right != null ? right.data: null)
					.append("]");
			return sb.toString();
		}
	}

	Node<E> root;

	public void add(E e) {
		if(root == null) {
			root = insert(root, e);
		} else insert(root, e);
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

	public String preOrder() {
		return preOrder(root, new StringBuilder()).toString();
	}
	public String inOrder() {
		return inOrder(root, new StringBuilder()).toString();
	}
	public String postOrder() {
		return postOrder(root, new StringBuilder()).toString();
	}
	public String levelOrder() {
		return levelOrder(root);
	}
	public Map<Integer, List<E>> verticalOrder() {
		Map<Integer, List<E>> map = new HashMap<>();
		verticalOrder(root, map, 0);
		return map;
	}
	public int height() {
		return depth(root);
	}
	public Collection<E> leftView() {
		Map<Integer, E> result = new LinkedHashMap<>();
		leftView(root, 1, result);
		return result.values();
	}
	public Collection<E> rightView() {
		Map<Integer, E> result = new LinkedHashMap<>();
		rightView(root, 1, result);
		return result.values();
	}

	private StringBuilder preOrder(Node current, StringBuilder result) {
		if(current == null) return result;

		result.append(current.data).append(", ");
		preOrder(current.left, result);
		preOrder(current.right, result);

		return result;
	}
	private StringBuilder inOrder(Node current, StringBuilder result) {
		if(current == null) return result;

		inOrder(current.left, result);
		result.append(current.data).append(", ");
		inOrder(current.right, result);

		return result;
	}
	private StringBuilder postOrder(Node current, StringBuilder result) {
		if(current == null) return result;

		postOrder(current.left, result);
		postOrder(current.right, result);
		result.append(current.data).append(", ");

		return result;

	}
	private String levelOrder(Node<E> root) {
		Queue<Node<E>> queue = new LinkedList<>();
		queue.add(root);
		StringBuilder sb = new StringBuilder();

		while(!queue.isEmpty()) {
			Node<E> current = queue.poll();

			if(current.left != null) queue.add(current.left);
			if(current.right != null) queue.add(current.right);

			sb.append(current.data).append(", ");
		}

		return sb.toString();
	}
	private int depth(Node current) {
		if(current == null) return 0;

		int left = depth(current.left);
		int right = depth(current.right);

		return Math.max(left, right) + 1;
	}
	private void verticalOrder(Node<E> current, Map<Integer, List<E>> map, int hd) {
		if(current == null) return ;

		if(map.containsKey(hd)) {
			List<E> temp = map.get(hd);
			temp.add(current.data);
		} else {
			List<E> temp = new ArrayList<>();
			temp.add(current.data);
			map.put(hd, temp);
		}

		verticalOrder(current.left, map, hd-1);
		verticalOrder(current.right, map, hd+1);

	}

	public Map<Integer, E> topOrder() {
		Map<Integer, E> result = new LinkedHashMap<>();
		Map<E, Integer> hdMap = new HashMap<>();

		Queue<Node<E>> queue = new LinkedList<>();

		if(root != null) {
			queue.add(root);
			add2Map(result, hdMap, root, 0);
		}

		while(!queue.isEmpty()) {
			Node<E> current = queue.poll();
			int hd = hdMap.get(current.data);

			if(current.left != null) {
				queue.add(current.left);
				add2Map(result, hdMap, current.left, hd - 1);
			}

			if(current.right != null) {
				queue.add(current.right);
				add2Map(result, hdMap, current.right, hd + 1);
			}
		}
		return result;
	}

	private void add2Map(Map<Integer, E> result, Map<E, Integer> helperMap, Node<E> node, int hd) {
		if(!result.containsKey(hd)) {
			result.put(hd, node.data);
		}
		helperMap.put(node.data, hd);
	}
	private void leftView(Node<E> node, int level, Map<Integer, E> result) {
		if(node == null) return;

		if(!result.containsKey(level)) {
			result.put(level, node.data);
		}
		leftView(node.left, level + 1, result);
		leftView(node.right, level + 1, result);
	}
	private void rightView(Node<E> node, int level, Map<Integer, E> result) {
		if(node == null) return;

		if(!result.containsKey(level)) {
			result.put(level, node.data);
		}
		rightView(node.right, level + 1, result);
		rightView(node.left, level + 1, result);
	}

	public static void main(String[] args) {
		PracticeTree<Integer> tree = new PracticeTree<>();
		int[] nums = {1, 14, 3, 7, 4, 5, 15, 6, 13, 10, 11, 2, 12, 8, 9};
		for(int num: nums) tree.add(num);

		System.out.println(tree);

		System.out.println(tree.preOrder());
		System.out.println(tree.inOrder());
		System.out.println(tree.postOrder());
		System.out.println(tree.levelOrder());
		System.out.println("height: " + tree.height());
		System.out.println(tree.verticalOrder());
		System.out.println(tree.topOrder());
		System.out.println(tree.leftView());
		System.out.println(tree.rightView());
	}

}
