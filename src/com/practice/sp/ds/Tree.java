package com.practice.sp.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Tree<E extends Comparable<E>> {
	private Node<E> root;

	public enum Traversal {
		PREORDER, INORDER, POSTORDER, BFS, VERTICAL, TOP
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
	public boolean find(E e) {
		return findNode(root, e);
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
				levelOrder2(root, new LinkedList<>(), sb);
				break;
			case VERTICAL:
				verticalOrderTraversal(sb);
				break;
			case TOP:
				topOrderTraversal(sb);
				break;
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

	private Map<Integer, List<E>> verticalOrderTraversal(StringBuffer sb) {
		Map<Integer, List<E>> m = new TreeMap<>();
		addVerticalElements(root, m, 0);
		sb.append(m.toString());
		return m;
	}

	private void topOrderTraversal(StringBuffer sb) {
		Map<Integer, E> r = topOrder();

		sb.append(r.toString());
	}
	
	public Map<Integer, E> topOrder() {
		Map<Integer, E> result = new HashMap<>();
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

	private void addToMap2(Node<E> current, Map<E, Integer> m, Map<Integer, E> r, int i) {
		if (!m.containsValue(i)) {
			m.put(current.data, i);
			r.put(i, current.data);
		} else {
			m.put(current.data, i);
		}
	}

	/*private Map<Integer, List<E>> verticalOrderTraversal2() {
		Map<Integer, List<E>> m = new TreeMap<>();
		//addVerticalElements2(root, m, new LinkedList<>(), 0);
		return m;
	}*/

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
	private void levelOrder2(Node<E> current, Queue<Node<E>> q, StringBuffer sb) {
		if(current == null) return;
		if(current == root) q.add(current);

		if(!q.isEmpty()) {
			if (current.left != null) q.add(current.left);
			if (current.right != null) q.add(current.right);

			sb.append(q.poll().data).append(", ");
			levelOrder2(q.peek(), q, sb);
		}
	}

	private void addVerticalElements2(Map<Integer, List<E>> m, Queue<Node<E>> queue) {
		if(root == null) return;

		queue.add(root);
		addToMap(root, m, 0);

		while(!queue.isEmpty()) {
			Node<E> current = queue.poll();

			if (current.left != null) {
				addToMap(current.left, m, 0);
				queue.add(current.left);
			}
			if (current.right != null) {
				addToMap(current.right, m, 0);
				queue.add(current.right);
			}
			queue.poll();
		}
	}

	private void addToMap(Node<E> current, Map<Integer, List<E>> m, int i) {
		List<E> temp = m.get(i);
		if (temp == null) {
			temp = new ArrayList<>();
			temp.add(current.data);
			m.put(i, temp);
		}else {
			temp.add(current.data);
		}
	}

	private void addVerticalElements(Node<E> current, Map<Integer, List<E>> m, int hd) {
		if(current == null) return;

		if(m.get(hd) == null) {
			List<E> temp = new ArrayList<>();
			temp.add(current.data);
			m.put(hd, temp);
		} else if(m.get(hd) != null){
			m.get(hd).add(current.data);
		}

		addVerticalElements(current.left, m, hd - 1);
		addVerticalElements(current.right, m, hd + 1);
	}

	public int height() {
		return findHeight(root);
	}
	private int findHeight(Node current) {
		if(current == null) return 0;

		int leftHeight = findHeight(current.left);
		int rightHeight = findHeight(current.right);

		return Math.max(leftHeight, rightHeight) + 1;
	}

	private boolean findNode(Node<E> current, E e) {
		if(current == null) return false;
		if(e.equals(current.data)) return true;

		if(e.compareTo(current.data) < 0)
			return findNode(current.left, e);
		else
			return findNode(current.right, e);
	}

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>();
		int[] nums = {1, 14, 3, 7, 4, 5, 15, 6, 13, 10, 11, 2, 12, 8, 9};
//		int[] nums = {6, 4, 8, 3, 5, 7, 9, 8};
//		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
//		int[] nums = {37,23,108,59,86,64,94,14,105,17
//				,111,65,55,31,79,97,78,25,50,22,66,46
//				,104,98,81,90,68,40,103,77,74,18,69,82
//				,41,4,48,83,67,6,2,95,54,100,99,84,34,88
//				,27,72,32,62,9,56,109,115,33,15,91,29,85
//				,114,112,20,26,30,93,96,87,42,38,60,7,73
//				,35,12,10,57,80,13,52,44,16,70,8,39,107,106
//				,63,24,92,45,75,116,5,61,49,101,71,11,53,43
//				,102,110,1,58,36,28,76,47,113,21,89,51,19,3};
//		int[] nums = {1,14,3,7,4,5,15,6,13,10,11,2,12,8,9};
		for(int num : nums) tree.add(num);

//		System.out.println("PREORDER: " + tree.traversal(Traversal.PREORDER));
//		System.out.println("INORDER: " + tree.traversal(Traversal.INORDER));
//		System.out.println("POSTORDER: " + tree.traversal(Traversal.POSTORDER));
		System.out.println("BFS: " + tree.traversal(Traversal.BFS));
//
//		System.out.println("Tree height: "  + tree.height());
//		System.out.println("Find: " + tree.find(13));
		System.out.println("Top: "  + tree.traversal(Traversal.TOP));
		System.out.println("Vertical: "  + tree.traversal(Traversal.VERTICAL));
//		System.out.println("Vertical: "  + tree.verticalOrderTraversal2());

	}

}
