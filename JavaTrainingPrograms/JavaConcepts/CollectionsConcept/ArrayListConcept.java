package CollectionsConcept;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListConcept {

	public static <E> void main(String[] args) {
		int a[] = new int[3]; //static array - Size is fixed
		
		//resolve static array issue - use dynamic array
		//1. can contain duplicate values/elements
		//2. Maintains insertion order
		//3. Synchronized
		//4. allows random access to fetch the element because it stores the values on the basis of indexes
		ArrayList al = new ArrayList();
		al.add(10); //0
		al.add(20); //1
		al.add(30); //2
		System.out.println(al.size());
		al.add(40); //3
		al.add(50); //4
		al.add(50); //5
		al.add(12.50); //Float
		al.add(true); // Boolean
		al.add("Test"); // String
		al.add('a'); // Char
		
		
		System.out.println(al.size()); // Size of array
		System.out.println(al.get(4)); // to get value from an Index
		//to print all the value from arraylist:
		//1. for loop
		//2. using iterator
		for (int i=0;i<al.size();i++){
		System.out.println(al.get(i));	
		}
		
		//non generic vs generic (what kind of value - int, string, char, float) : after JDK 5
		ArrayList<Integer> al1 =new ArrayList<Integer>(); // Integer ArrayList
		al1.add(100);
		//al1.add("Selenium");
		
		
		ArrayList<String> al2 =new ArrayList<String>(); // String ArrayList
		al2.add("Testing");
		al2.add("Selenium Testing");
		al2.add("Cucumber Testing");
		
		ArrayList<E> al3 =new ArrayList<E>(); // all type of data in the ArrayList
		
		//Employee class Objects
		Employee el = new Employee("Vaishali", 27, "QA");
		Employee e2 = new Employee("Tom", 28, "DEV");
		Employee e3 = new Employee("Peter", 29, "Admin");
		
		//create arraylist: with Employee class name
		ArrayList<Employee> al4 = new ArrayList<Employee>();
		al4.add(el);
		al4.add(e2);
		al4.add(e3);
		
		
		//Iterator to traverse the values:
		Iterator<Employee> it = al4.iterator();
		while(it.hasNext())
		{
			Employee emp =it.next();
			System.out.println(emp.name);
			System.out.println(emp.age);
			System.out.println(emp.dept);
		}
			
			//****************************
			ArrayList<String> al5 = new ArrayList<String>();
			al5.add("Dev");
			al5.add("Java");
			al5.add("JavaScript");
			
			ArrayList<String> al6 = new ArrayList<String>();
			al6.add("Test");
			al6.add("VB");
			al6.add("VBScript");
			
			al5.addAll(al6);
			
			for (int i=0;i<al5.size();i++)
			{
				System.out.println("Add All :" + al5.get(i));
			}
			
			//removeAll:
			al5.removeAll(al6);
			for(int i =0; i<al5.size(); i++)
			{
				System.out.println("Remove All :" + al5.get(i));
			}
			
			//retainAll()
			ArrayList<String> al7 = new ArrayList<String>();
			al7.add("Test");
			al7.add("Java");
			
			
			ArrayList<String> al8 = new ArrayList<String>();
			al8.add("Test");
			al8.add("Dot Net");
			
			
			al7.retainAll(al8);
			
			for (int i=0;i<al7.size();i++)
			{
				System.out.println("Retain All :" + al7.get(i));
			}
		
	}

}
