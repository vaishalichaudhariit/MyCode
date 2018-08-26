package OOPsConceptPart1;

public class FunctionsInJava {
	
	//main method-->starting point of execution
	public static void main(String[] args) {
		
		// new FunctionsInJava()---> Object of class 
		// FunctionsInJava obj---> Object Reference name of the class
		
 		FunctionsInJava obj = new FunctionsInJava();
 		
 		//one object will be created, obj is the reference variable, referring to this object
 		//after creating the object, the copy of all non static methods will be given to this object 		
 		
		obj.test();
		int i = obj.pqr();
		System.out.println("i: " +i );
		String s1 = obj.qa();
		System.out.println("s1: " + s1);
		int val = obj.division(20, 10);
		System.out.println("val: " +val);
	}
	
		// Non static method
		//void -- does not return any value
		//return type = void		
		public void test(){ //no input, no output
		System.out.println("test method");	
		}
	
		
		
		//retrun type --> int
		public int pqr(){ //no input, some output
			System.out.println("PQR method");
			int a=10;
			int b=20;
			int c=a+b;
			
			return c;
			
		}
		
		//retrun type --> String
		public String qa(){//no input, some output
		System.out.println("QA method");
		String s = "Selenium";
		
		return s;
		}

		
		//x,y-->input parameters/arguments
		//retrun type --> int
		public int division(int x, int y){
			System.out.println("Division Method");
			int d = x/y;
			
			return d;
		}
}
