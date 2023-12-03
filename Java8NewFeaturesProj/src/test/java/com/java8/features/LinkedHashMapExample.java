package com.java8.features;
// Java Program to maintain insertion order
// of the elements in HashMap with LinkedHashMap

import java.util.*;
import java.util.Map.Entry;
public class LinkedHashMapExample {


	public static void main(String args[])
	{
		/*
		 * // creating a hashmap HashMap<String, String> hm = new LinkedHashMap<>();
		 * 
		 * // putting elements hm.put("01", "aaaaaaa"); hm.put("03", "bbbbbbb");
		 * hm.put("04", "zzzzzzz"); hm.put("02", "kkkkkkk");
		 * 
		 * // printing LinkedHashMap System.out.println("Iterate over LinkedHashMap");
		 * for (Map.Entry<String, String> entry : hm.entrySet()) {
		 * System.out.println(entry.getKey() + " => " + ": " + entry.getValue()); }
		 */

		// creating a Linkedhashmap
		LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>();

		// putting elements
		hm.put("01", "aaaaaaa");
		hm.put("03", "bbbbbbb");
		hm.put("04", "zzzzzzz");
		hm.put("02", "kkkkkkk");

		System.out.println("Iterate over original HashMap");
		
		Set<Entry<String, String>> s = hm.entrySet();

		// printing Linkedhashmap
		for (Map.Entry<String, String> entry : s) {
			System.out.println(entry.getKey() + " => " + ": " + entry.getValue());
		}
	}
}

