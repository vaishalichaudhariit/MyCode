package OOPsConceptPart1;

public class MethodOverloading {

	public static void main(String[] args) {
		MethodOverloading obj = new MethodOverloading();
		obj.sum();
		obj.sum(10);
		obj.sum(10, 20);

	}
	
	//main method overloading not used in JAVA
	public static void main(int p){
		System.out.println("This is the main method overloading with int parameter");
	}
	
	public static void main(String q){
		System.out.println("This is the main method overloading with String parameter");
	}
	
	//You can not create a method inside a method
	//Duplicate method ---i.e. same method name with same number of arguments not allowed
	
	
	//Method overloading -->when the method name is same with different arguments or input parameters with difference data type within the same class
	public void sum(){ //0 input param
		System.out.println("Sum method--zero param");
	}
	
	public void sum(int i){//1 input param
		System.out.println("Sum method one input parameter--i:" +i);
	}
	
	public void sum(double d){//1 input param
		System.out.println("Sum method one input parameter--double d:" +d);
	}
	
	public void sum(int i, int j){ //2 input params
		System.out.println("Sum method 2 input parameeter---sum of i+j:" +(i+j));
	}
	
}
