package com.java8.features;
// Java program to add elements in
// Array List using add() method

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {


	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<>();

		// add method for integer ArrayList
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(2);
		System.out.println(list);
		list.add(5);
		System.out.println(list);
		list.add(2,6); // Add elements on particular index
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);	
	}
}


