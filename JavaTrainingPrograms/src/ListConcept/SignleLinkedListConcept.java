package ListConcept;

import java.util.Iterator;
import java.util.LinkedList;

public class SignleLinkedListConcept {

	public static void main(String[] args) {
		
		LinkedList<String> sll = new LinkedList<String>();
		
		//add
		sll.add("Test");
		sll.add("Selenium");
		sll.add("QTP");
		
		//print 
		System.out.println("content of LinkedList: " + sll);
		
		//add First
		sll.addFirst("Start");
		//add Last
		sll.addLast("Complete");
		
		//print element after added First and Last
		System.out.println("content of LinkedList: " + sll);
		
		//Get
		System.out.println("get element: " + sll.get(0));
		
		//Set
		sll.set(0, "Shri Ganesha");
		System.out.println("Get element value set: " + sll.get(0));
		
		//remove
		sll.remove(0);
		System.out.println("Get element after remove (0): " + sll);
		
		//remove First element
		sll.removeFirst();
		System.out.println("Get element after remove First: " + sll);
		
		//remove Last element
		sll.removeLast();
		System.out.println("Get element after remove Last: " + sll);
		
		
		//How to print call the contain of LinkedList
		//For loop
		System.out.println("******************For Loop");
		for(int i=0;i<sll.size();i++)
		{
			System.out.println("Print Linked list value with for loop: " + sll.get(i));
		}
		//Advance For loop - For each
		System.out.println("******************For Each");
		for(String str:sll)
		{
			System.out.println("Print Linked list value with for loop: " + str);
		}
		//Iterator
		System.out.println("******************Ierator");
		Iterator<String> it = sll.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
		
		
		//While loop
		System.out.println("******************While Loop");
		int num =0;
		while(sll.size()>num)
		{
			System.out.println(sll.get(num));
			num++;
		}
		
	}

}
