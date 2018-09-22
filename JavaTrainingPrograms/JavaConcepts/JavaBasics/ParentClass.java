package JavaBasics;

public class ParentClass {
	int i=0;
	int j=0;
	public ParentClass()
	{
		System.out.println("In Parent Class Constructor");
	}
	
	public static void test()
	{
		System.out.println("In Parent Class public static method");
	}
	public  void print()
	{
		System.out.println("In Parent Class public print method");
	}
	private static void test_private()
	{
		System.out.println("In Parent Class private static method");
	}
	protected void test_protected()
	{
		System.out.println("In Parent Class protected  method");
	}
	final static void test_finalstatic()
	{
		System.out.println("In Parent Class final static method");
	}
	
	public ParentClass(int i)
	{
		System.out.println("Value of i:" +i);
	}

	public ParentClass(int i, int j)
	{
		System.out.println("Value of i:" +i);
		System.out.println("Value of j:" +j);
	}

	public static void main(String[] args) {

		test_private();

	}

}
