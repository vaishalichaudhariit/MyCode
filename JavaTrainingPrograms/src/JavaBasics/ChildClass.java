package JavaBasics;

//import JavaBasics.ParentClass;

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
	
	public static void test()
	{
		System.out.println("In Child Class public static method");
	}
	private static void test_private()
	{
		System.out.println("In Child Class private static  method");
	}
	
	public  void print()
	{
		System.out.println("In Child Class public print method");
	}
	protected void test_protected()
	{
		System.out.println("In Child Class protected  method");
	}
	//Cannot override final method of parent class
	/*final static void test_finalstatic()
	{
		System.out.println("In Parent Class final static method");
	}*/
	
	public void setup(){
		test();
		//test_private(); Private method of Parent class is not accessible
		test_protected();
		test_finalstatic();
		
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
		
		cc.test_private();
		cc.test_protected();
		ChildClass.test();
		ChildClass.test_finalstatic();
		
		ParentClass pc = new ParentClass();
		pc.test_protected();
		ParentClass.test();
		ParentClass.test_finalstatic();
		
		ParentClass pc1 = new ChildClass();
		pc1.test_protected();
		//ParentClass.test_private(); or pc1.test_private(); Private method of Parent class not visible in child class
		pc1.print(); //parent class
		ParentClass.test();
		ParentClass.test_finalstatic();
		
	/*	Output ->
	 * Value of i:10
	 * 
		Value of j:20
		In Child Class Constructor
		Value of i:40
		In Child Class Single parameter Constructor i:40
		Value of i:50
		Value of j:60
		In Child Class multiple parameter Constructor i:50
		In Child Class multiple parameter Constructor j:60
		In Child Class private  method
		In Child Class protected  method
		In Child Class public static method
		In Parent Class final static method
		In Parent Class Constructor
		In Parent Class protected  method
		In Parent Class public static method
		In Parent Class final static method
		Value of i:10
		Value of j:20
		In Child Class Constructor
		In Child Class protected  method
		In Parent Class public static method
		In Parent Class final static method*/
		
		
		
	}

	
}
