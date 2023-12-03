package complexJSON;

public class Details {

	
	private String companyName;
	private String emailId;
	
	
	public Details(String companyName, String emailId) {
		this.companyName=companyName;
		this.emailId=emailId;
	}
	
	public String getCompanyname() {
		return companyName;
	}
	public void setCompanyname(String companyName) {
		this.companyName = companyName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
