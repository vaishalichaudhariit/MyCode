package JavaBasics;

public class FinallyBlock {

	public static void main(String[] args) {
	
			test1();
			test2();
			division();
			division1();

	}

	public static void test1(){
		
		try{
			System.out.println("inside try block");
		}catch (Exception e){
			System.out.println("inside catch block");
		}
		finally
		{
			System.out.println("inside finally block");
		}
	}
	public static void test2(){
		try{
			System.out.println("Inside test2 - try");
			//System.exit(0);
		}
		finally{
			System.out.println("Inside test2 - finally");
		}
	}
	
	public static void division(){
		int i = 10;
		try{
			System.out.println("Inside division try block");
			int k = i/0;
		}catch(ArithmeticException e){
			System.out.println("Inside catch block");
			System.out.println("Divide by zero error");
		}
		finally{
			System.out.println("execute this code after any exception");
		}
	}
	
	//Exception throw java.lang.ArithmeticException: / by zero. It will not going to catch block
	public static void division1(){
		int i = 10;
		try{
			System.out.println("Inside division try block");
			//System.exit(0);
			int k = i/0;
		
			
		}catch(NullPointerException e){
			System.out.println("division1 ---Inside catch block");
			System.out.println("division1 ---Divide by zero error");
		}
		finally{
			System.out.println("division1 ---execute this code after any exception");
		}
	}
}
