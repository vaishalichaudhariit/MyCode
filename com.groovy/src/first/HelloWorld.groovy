/**
 * 
 */
package first

/**
 * @author Vaishali.Chaudhari
 *
 */
class HelloWorld {

	static main(args) {
		def input = 10 as double; // run time decide the data type
		def status = true;
		int a;
		float b;
		double c;
		char d;
		int i=10;
		int j=40;
		
		
		def addValue = sumOfTwoNumbers i,j
		println addValue
		
		println input
		println status
		println"Welcome to Grrovy"
		System.out.println("Vaishali here");
		
		println sumOfTwoNumbers(20, 20)
		println sumOfTwoNumbers(10.20, 20.10)
	}
	static def sumOfTwoNumbers(a,b){//Not require to mention data type for arg
		//return a+b; Not require return keyword
		a+b
	}
}
