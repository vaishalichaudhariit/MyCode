package AbstractionConcept;

public class TestBank {

	public static void main(String[] args) {
		
		//Compile time polymorphism
		HDFCBank hb = new HDFCBank();
		hb.credit();
		hb.debit();
		hb.loan();
		hb.funds();
		
		//Run time polymorphism
		Bank b = new HDFCBank();
		b.credit();
		b.debit();
		b.loan();
		//b.funds; - Not available for Bank reference because it's child class method
		
		

	}

}
