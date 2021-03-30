package com.practice.sp.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalanceBrackets {

	public static void main(String[] args) {
		System.out.println(isBalanced("[({})]"));
		System.out.println(isBalanced("[({})["));
	}

	public static boolean isBalanced(String s) {
		Stack<String> stack = new Stack<>();
		final String allowed = "({[]})";
		Map<String, String> map = new HashMap<>();
		map.put("(", ")");
		map.put("{", "}");
		map.put("[", "]");

		for(char c: s.toCharArray()) {
			String eachChar = String.valueOf(c);
			if(!allowed.contains(eachChar)) return false;

			if(stack.isEmpty()) stack.push(eachChar);
			else {
				String peek = stack.peek();
				if(eachChar.equals(map.get(peek))) {
					stack.pop();
				} else {
					stack.push(eachChar);
				}
			}
		}

		return stack.isEmpty();
	}
}
