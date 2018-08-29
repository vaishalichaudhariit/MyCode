package ListConcept;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapConcept {

	public static void main(String[] args) {
		
		
		
		//Java HashMap class implements the map interface. It inherits AbstractMap class and implements Map interface.
		//The important points about Java HashMap class are: A HashMap contains values based on the key. It contains only unique elements. 
		//It may have one null key and multiple null values. It maintains no order.
		//hashmap is non-synchronised -- not thread safe It gives Concurrent modification exception -- in case of Fail - Fast condition

		//HashMap is a class implements Map Interface
		//extends Abstract Map
		//it contains only unique elements
		//stored the values – key\value pair
		//it may have null key and multiple null values
		// it maintains no order
		// Multithreading support by hashmap
		//hashmap is non-synchronized – not thread safe 
		//Fail fast condition – concurrent modification exception – modify Map structure – add or remove element from HashMap object  - when Tread 3 is trying to add or remove element and simultaneously Tread1 and Tread 2 trying to access same element.

		/*Key                Value
		1	A
		2	B

		Simultaneously  all threads trying above objects T1 (updated value of 1 as C), T2   (trying to access 1 key value expecting A and will get C as updated by T1)
*/
		HashMap<Integer, String> hm = new HashMap<Integer,String>();
		hm.put(1,"Selenium");
		hm.put(2, "QTP");
		hm.put(3, "TestComplete");
		hm.put(4, "RFT");
		
		System.out.println(hm.get(1));
		System.out.println(hm.get(4));
		
		for(Entry m: hm.entrySet()){
			System.out.println(m.getKey() + " " + m.getValue());
		}
		System.out.println(hm);
		hm.remove(3);
		System.out.println(hm);
		
		//
		HashMap<Integer, Employee> empHM = new HashMap<Integer,Employee>();
		Employee e1 = new Employee("Tom", 27, "Dev");
		Employee e2 = new Employee("Peter", 26, "QA");
		Employee e3 = new Employee("Steve", 25, "Admin");
		
		empHM.put(1, e1);
		empHM.put(2, e2);
		empHM.put(3, e3);
		
		//traverse the hashmap:
		for(Entry<Integer, Employee> m:empHM.entrySet()){
			int key = m.getKey();
			Employee e = m.getValue();
			System.out.println(key + "Info");
			System.out.println(e.name + " " + e.age + " " +e.dept);
		}
		
		/*Output -
		1Info
		Tom 27 Dev
		2Info
		Peter 26 QA
		3Info
		Steve 25 Admin*/
}
}
