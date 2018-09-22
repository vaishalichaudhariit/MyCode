package OOPsConceptPart2;

public class BMW extends Car { // has - a - relationship

		// Method Overriding - when same method is present in parent class as well as in child with the same name and same number of argument.
	
	public void start(){
		System.out.println("BMW-->Start");
	}
	
	
	public void theftSafetly(){
		System.out.println("BMW-->theftSafetly");	
	}
	
}
