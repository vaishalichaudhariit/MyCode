package JavaBasics;

public class IncrementandDecrementForLoop {

	public static void main(String[] args) {
		int i =1;
		int j = i++; // Post increment
		
		System.out.println("i:" +i);//2
		System.out.println("j:" +j);//1
		
		
		int k =1;
		int l = ++k; // Pre increment
		System.out.println("k:" +k);//2
		System.out.println("l:" +l);//2
		
		int m =2;
		int n = m--; // Post decrement
		System.out.println("m:" +m);//1
		System.out.println("n:" +n);//2
		
		
		int o = 2;
		int p = --o; // Pre decrement
		System.out.println("o:" +o);//1
		System.out.println("p:" +p);//1
		
		/*
		 * Output
		 * i:2
			j:1
			k:2
			l:2
			m:1
			n:2
			o:1
			p:1

		 */

	}

}
