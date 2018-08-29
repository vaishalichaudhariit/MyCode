package ListConcept;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

public class HashTableConcept {

	public static void main(String[] args) {
		// hashCode Number - Unique no. provided by JVM -32bit int
		//In case of obj cloning then hashCode number is same for 2 obj of class
		//stores the value on the basis of key-value
		//key-->Object-->hashCode-->Value
		//<hashCode,value> e.g. <342434,"Tom">
		//It is similar to hashMap, but its is synchronized
		//hashTable is synchronized, thread safe, at a time one object accessed by one Thread, then other Threads cannot access that object
		
		Hashtable ht1 = new Hashtable<>();
		ht1.put(1, "Tom");
		ht1.put(2,"Peter");
		ht1.put(3,"Vaishali");
		
		//create a clone copy/shallow copy:
		Hashtable ht2 = new Hashtable();
		ht2 = (Hashtable)ht1.clone();
		
		System.out.println("The value of ht1: " +ht1);
		System.out.println("The value of ht2: " +ht2);
		
		//clear:
		ht1.clear();
		System.out.println("The value of ht1: " +ht1);
		System.out.println("The value of ht2: " +ht2);
		
		//contains value:
		Hashtable ht3 = new Hashtable();
		ht3.put("A","Vaishali");
		ht3.put("B","Manager");
		ht3.put("C","Selenium");
		
		if(ht3.containsValue("Vaishali"))
			System.out.println("Value is found");
		
		
		//print all the values from hashtable using ---Enumeration---elements()
		Enumeration e = ht3.elements();
		System.out.println("pring values from ht3");
		
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}
		
		//get all the values from hashtable using ---entrySet()---set of hashtable values:
		System.out.println("print values from ht3 using entry set");
		
		Set s = ht3.entrySet();
		System.out.println(s);
		
		Hashtable ht4 = new Hashtable();
		ht4.put("A","Vaishali");
		ht4.put("B","Manager");
		ht4.put("C","Selenium");
		ht4.put("C","Selenium"); // it contains only unique values
		//ht4.put(null,"Selenium"); // no null key and null values
		//ht4.put("D",null);// not allowed - Null point exception
		
		System.out.println("values from ht1");
		System.out.println(ht1);
		
		
		//check both the hashtables are equal or not:
		if(ht3.equals(ht4)){
			System.out.println("both are equal");
		}
		
		//get the value from a key:
		System.out.println(ht4.get("A"));
		
		//get the hashcode of hashtable object:
		
		System.out.println("the hascode value of the ht2:" + ht2.hashCode());
		
		//Generic:
		Hashtable <String, String>ht5 = new Hashtable<String, String>();
		ht5.put("A","Vaishali");
		ht5.put("B","Manager");
		ht5.put("C","Selenium");
		
		//Difference between HashMap and Hashtable
		//Hashtable is unique, not accept null, don't use multiple threading, improve performance don't use Hashtable - because hashtable is Synchronized, thread safe- at a time only on thread can access, sequential threading 
		//HashMap non synchronized,allow multiple thread at time can access hashMap object. problem - if T1 has changed value or removed then T2 will get null value, fatal condition
		
	}

}
