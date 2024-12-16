//Ian Mwai Gachoki
//3132394

package griffith;

public class Lecturer extends Account {

	// Private attribute to store lecturer's office location
	private String office;
	
	// Constructor initializing lecturer with first name, last name, and office location
	public Lecturer (String firstName, String lastName, String office) {
		 // Calling the parent Account constructor to set up email based on naming convention
		super (firstName, lastName, firstName +"." + lastName +"@student.griffit.ie");
		
		this.office=office;
	}
	
	// Setter method for office
	public void setOffice (String office) {
		this.office=office;
	}
	
	// Getter method for office
	public String getOffice (String office) {
		return office;
	}
}
