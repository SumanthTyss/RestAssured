package pojoClassForSerializationAndDeSerialization;

public class PojoClass {
	String empName;
	String empID;
	String email;
	int phNum;
	
	public PojoClass(String empName, String empID, String email, int phNum) {
		super();
		this.empName = empName;
		this.empID = empID;
		this.email = email;
		this.phNum = phNum;
	}
	
	 PojoClass() {
		
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhNum() {
		return phNum;
	}

	public void setPhNum(int phNum) {
		this.phNum = phNum;
	}
	 
	
	
	

}
