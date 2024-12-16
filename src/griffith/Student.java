//Ian Mwai Gachoki
//3132394

package griffith;

public abstract class Student extends Account {

	 // Private attributes for student ID, credits, and years in study
	private int id;
	private int credits;
	private int years;
	
	// Constructor initializing student with first name, last name, ID, credits, and years in study
	public Student (String firstName, String lastName, int id, int credits, int years) {
		// Calling the parent Account constructor to set up email using the provided naming convention
		super(firstName, lastName,firstName +"." + lastName +"@student.griffith.ie" );
		this.id=id;
		this.credits=credits;
		this.years=years;
	}
	
	 // Setter method for ID
	public void setId(int id) {
		this.id=id;
	}
	
	// Getter method for ID
	public int getId() {
		return id;
	}
	
	// Setter method for credits
	public void setCredits (int credits) {
		this.credits=credits;
	}
	
	 // Getter method for credits
	public int getCredits () {
		return credits;
	}
	
	// Setter method for years
	public void setYears(int years) {
		this.years=years;
	}
	
	// Getter method for years
	public int getYears () {
		return years;
	}

	// Overriding  method to compare students by their unique ID
	public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id; 
    }

	// Overriding  method to generate a hash based on student ID
    public int hashCode() {
        return Integer.hashCode(id); 
    }

 // Method to display student's full information in a formatted way
    public void displayInfo() {
        System.out.println(getFirstName() + " " + getLastName() + " (ID: " + id + ")");
    }
}
