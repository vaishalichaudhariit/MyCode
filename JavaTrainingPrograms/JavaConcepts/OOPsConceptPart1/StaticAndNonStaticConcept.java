package OOPsConceptPart1;

public class StaticAndNonStaticConcept {
	
	//global vars: the scope of global vars will be available across all the functions with some conditions
	
	String name = "Vaishali";//non static global variable
	static int age = 25; //static global variable
	
	//Separate memory space allocated to static method or static variables
	
	
	public static void main(String[] args) {
		
		
		//How to call static method and variables
		//1.direct calling:
		sum();
		//2.calling by class name:
		StaticAndNonStaticConcept.sum();
		
		System.out.println(age);
		System.out.println(StaticAndNonStaticConcept.age);
		
		//how to call non static methods and vars
		StaticAndNonStaticConcept obj = new StaticAndNonStaticConcept();
		obj.sendMail();
		System.out.println(obj.name);
		
		//Can I access static methods by using object reference? yes
		obj.sum(); //But not good practice
	}
	
	
	public void sendMail(){//non static method
		System.out.println("send email method");
	}
	
	public static void sum(){ //static method
		System.out.println("Sum method");
	}
	

}
