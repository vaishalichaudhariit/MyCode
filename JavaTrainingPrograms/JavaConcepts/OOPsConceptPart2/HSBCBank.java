package OOPsConceptPart2;

public class HSBCBank implements USBank, UKBank{ //We are achieving Multiple Inheritance --2 parents--Is a relationship 

	//If a class is implementing any Interface, then its mandatory to define/override all the method of Interface
	//Overriding from USBank
	public void credit() {
		System.out.println("HSBC - credit");
		
	}
	//Overriding from USBank
	public void debit() {
		System.out.println("HSBC - debit");
	}

	//Overriding from USBank
	public void trasferMoney() {
		System.out.println("HSBC - transferMoney");
		
	}
	//separate method of HSBCBank class
	public void educationLoan(){
		System.out.println("HSBC - TransferMoney");
	}
	
	//Overriding from UKBank
	public void mutualFund(){
		System.out.println("HSBC---Mutual Fund");
	}
	public void carLoan(){
		System.out.println("HSBC-CarLoan");
	}
}
