package AbstractionConcept;

public class HDFCBank extends Bank{
	
	//Method overriding
	public void loan(){
		System.out.println("HDFC--Loan Method");
	}
	
	public void funds(){
		System.out.println("HDFC--Funds Method");
	}
}
