package GSON;

public class NewRequisition {

	private String jobCode;

	private String internalJobTitle;

	private String postedJobTitle;

	private String positions;

	private String division;

	private String location;

	private String department;

	private String businessJustification;

	private String divisionCode;

	private String hiringManager;

	private String recruiter;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public NewRequisition() {
	}

	/**
	 * 
	 * @param hiringManager
	 * @param positions
	 * @param division
	 * @param location
	 * @param department
	 * @param internalJobTitle
	 * @param jobCode
	 * @param divisionCode
	 * @param businessJustification
	 * @param recruiter
	 * @param postedJobTitle
	 */
	public NewRequisition(String jobCode, String internalJobTitle,
			String postedJobTitle, String positions, String division,
			String location, String department, String businessJustification,
			String divisionCode, String hiringManager, String recruiter) {
		super();
		this.jobCode = jobCode;
		this.internalJobTitle = internalJobTitle;
		this.postedJobTitle = postedJobTitle;
		this.positions = positions;
		this.division = division;
		this.location = location;
		this.department = department;
		this.businessJustification = businessJustification;
		this.divisionCode = divisionCode;
		this.hiringManager = hiringManager;
		this.recruiter = recruiter;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getInternalJobTitle() {
		return internalJobTitle;
	}

	public void setInternalJobTitle(String internalJobTitle) {
		this.internalJobTitle = internalJobTitle;
	}

	public String getPostedJobTitle() {
		return postedJobTitle;
	}

	public void setPostedJobTitle(String postedJobTitle) {
		this.postedJobTitle = postedJobTitle;
	}

	public String getPositions() {
		return positions;
	}

	public void setPositions(String positions) {
		this.positions = positions;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getBusinessJustification() {
		return businessJustification;
	}

	public void setBusinessJustification(String businessJustification) {
		this.businessJustification = businessJustification;
	}

	public String getDivisionCode() {
		return divisionCode;
	}

	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}

	public String getHiringManager() {
		return hiringManager;
	}

	public void setHiringManager(String hiringManager) {
		this.hiringManager = hiringManager;
	}

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}

}
