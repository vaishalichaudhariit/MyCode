package JavaBasics;

public class ChildClass extends ParentClass { // 1st called the parent class default construction
	
	//Constructor Overloading
	public ChildClass()
	{
		super(10,20);//Call to Parent Class Parameter constructor explicitly. But default constructor will not called
					//super keyword should be the 1st statement in the child class constructor
					//If super keyword not written then default constructor of the Parent class called
					//super keyword should be single statement
		System.out.println("In Child Class Constructor");
	}
	public ChildClass(int i )
	{
		super(i);
		System.out.println("In Child Class Single parameter Constructor i:" + i);
	}
	
	public ChildClass(int i , int j)
	{
		super(i,j);
		System.out.println("In Child Class multiple parameter Constructor i:" +i);
		System.out.println("In Child Class multiple parameter Constructor j:" +j);
	}
	
	public static void main(String[] args) {
		ChildClass cc = new ChildClass(); //output -In Parent Class Constructor, In Child Class Constructor
		ChildClass cc1 = new ChildClass(40);
		ChildClass cc2 = new ChildClass(50,60);
	}

}
