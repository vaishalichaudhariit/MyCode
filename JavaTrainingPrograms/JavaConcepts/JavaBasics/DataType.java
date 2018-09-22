package JavaBasics;

public class DataType {

	public static void main(String[] args) {
		
		//+ concatenation operator
		//println is used to print value on new line
		//print - just write to print on console
		
		int i=10;
		System.out.println("i:" +i);
		float f=12.40f; //32 bit
		System.out.println(f);
		
		double d= 12.30; //64 bit
		System.out.println(d);
		
		char cha = 'A';
		System.out.println(cha);
		
		String str = new String("Testing");
		System.out.println(str);
		
		String str1 = "Vaishali";
		System.out.println(str1);
		
		int j = 20;
		int k = 30;
		System.out.println(j+k);
		String x = "Hello";
		String y = "World";
		
		
		double d2 = 12.30;
		double d3 = 12.40;
		
		System.out.println(j+k+x+y);		
		System.out.println(x+y+j+k);
		System.out.println(x+y+(j+k));
		System.out.println(j+k+x+y+j+x+k+y);
		System.out.println(j+k+x+y+j+k);
		
		System.out.println(d2+d3);
		System.out.println(x+y+d2+d3);
		
		System.out.println("HelloWorld");
		System.out.println("10");
		
		System.out.println("j+k+x+y:" +j+k+x+y);
		
		//Comparison operator
		
		if(j<k)
		{
			System.out.println("K is greater than j");
		}
		else
		{
			System.out.println("K is less than J");
		}
		
		if(j==k)			
		{
			System.out.println("K equals j");
		}
		else
		{
			System.out.println("K not equals J");
		}
		
		
		if(i<j & i<k)
		{
			System.out.println("j is greater than i");
		}
		else
		{
			System.out.println("i is greater than j");
		}
	}

}
