package JavaBasics;

public class ArrayConcept {

	public static void main(String[] args) {


			//array: to store similar data type values in a array variable
		
			//1. int array;
			//lowest bound/index = 0
			//upper bound/index = n-1( n is size of array)
			//one dimation array
			// disadvantages of array 
			//size is fixed - static array - To  overcome this problem --- we use collections--ArrayList,HashTable ---use dynamic array
			//stores only similar data type - only int or char or boolean. Not able to store name, age, salary in single array--- we use Object array to store different data type
		
		
			int i[] = new int[4];
			i[0] = 10;
			i[1] = 20;
			i[2] = 30;
			i[3] = 40;
		System.out.println(i[2]);
		System.out.println(i[3]);
		
		//System.out.println(i[4]); // ArrayIndexOutOfBoundsException
		
		//length of the array
		
		System.out.println(i.length);
		
		//print all the values of array: use for loop
		for(int j=0; j<i.length; j++)
		{
			System.out.println(i[j]);
		}
		
		
		//2. double array
		double d[] = new double[3];
		d[0] = 10.23;
		d[1] = 20.34;
		d[2] = 30.12;
		System.out.println(d[2]);
		
		//3. char array
		char c[] = new char[3];
		c[0] = 'A';
		c[1] = '@';
		c[2] = '$';
		System.out.println(c[2]);
		
		
		//4. boolean array
		boolean b[] = new boolean[2];
		b[0] = true;
		b[1] = false;
		
		System.out.println(b[1]);
		
		//5. String array
		String s[] = new String[2];
		s[0] = "Vaishali";
		s[1] = "Chaudhari";
				
		System.out.println(s[1]);
				
		//6. Object array:store different data type values--- Object is class - super class in JAVA
		Object obj[] = new Object[6];
		obj[0] = "Vaishali";
		obj[1] = 18;
		obj[2] = 12.34;
		obj[3] = "1/1/2017";
		obj[4] = '$';
		obj[5] = "London";
				
		System.out.println(obj[5]);
		System.out.println(obj.length);
		

	}

}
