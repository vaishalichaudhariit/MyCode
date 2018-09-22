package AbstractionConcept;

public abstract class Bank {

	//one abstract method is compulsory in abstract class. and any no of non abstracts methods 
	//partial abstraction
	//Abstraction means hiding the implementation logic
	//100% abstraction in Interface
	
	public abstract void loan(); //abstract method --no method body only declaration
	// abstract method need to define in the child class
	
	public void credit(){
		System.out.println("Bank ---credit");
	}
	
	public void debit(){
		System.out.println("Bank ---debit");
	}
}
