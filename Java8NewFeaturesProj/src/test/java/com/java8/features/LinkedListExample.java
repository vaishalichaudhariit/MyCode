package com.java8.features;

import java.util.LinkedList;

public class LinkedListExample {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();

		// add method for integer ArrayList
		list.add(1);
		list.add(2);
		list.add(6);
		list.add(4);
		System.out.println(list);
		list.add(5);
		System.out.println(list);
		list.add(2,8); // Add elements on particular index
		System.out.println(list);
		list.addLast(7);
		System.out.println(list);
		list.addFirst(0);
		System.out.println(list);
	}

}
