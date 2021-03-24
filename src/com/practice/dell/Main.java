package com.practice.dell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args)
	{
		// Let us create a list of strings
		List<String> list = new ArrayList<String>();
		list.add("DoSelect");
		list.add("InMobi");
		list.add("CampusHash");
		list.add("mKhoj");
		list.add("Microsoft");

		System.out.println("Original: " + list);

		Collections.rotate(list, -2);

		System.out.println("Rotated: " + list);
	}
}


