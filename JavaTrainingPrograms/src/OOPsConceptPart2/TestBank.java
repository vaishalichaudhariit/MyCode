package OOPsConceptPart2;

public class TestBank {

	public static void main(String[] args) {
		
		//USBank b = new USBank(); Can not instantiate USBank Interface
		
		//Interface variable
		System.out.println(USBank.min_bal);
		
		//USBank.min_bal = 200; - Not able to change value of Interface variable because Interfase variable is default Static and final by nature
		
		HSBCBank hs = new HSBCBank();
		hs.credit();
		hs.debit();
		hs.trasferMoney();
		hs.educationLoan();
		hs.carLoan();
		hs.mutualFund();
		//dynamic polymorphism
		//child class object can be referred by parent Interface refernce var
		USBank us = new HSBCBank();
		us.credit();
		us.debit();
		us.trasferMoney();
		//us.educationLoan(); - Not able to access this child class method
		//us.carLoan(); - Not able to access this child class method

	}

}
