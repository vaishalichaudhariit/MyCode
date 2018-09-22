package OOPsConceptPart2;

public interface USBank {
	
	 int min_bal =100;
	
	public void credit();
	
	public void debit();
	
	public void trasferMoney();
	
	// Only method declaration
	//No method body, Only method prototype
	//In Interface we can declare the variables, vars are by default static in nature
	//Interface vars value will not be changed. Because Interface vars are static and final (Constant) default by nature
	//no static method in Interface
	//no main method in Interface
	//We can not create the object of InterfaceS
	//Interface is abstract in nature

}
