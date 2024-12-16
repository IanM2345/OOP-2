//Ian Mwai Gachoki
//3132394

package griffith;

public abstract class Account {
	
	// Private attributes to store account holder's first name, last name, and email
	private String firstName;
	private String lastName;
	private String email;
	
	
	// Constructor initializing first name, last name, and email for an account
	public Account (String firstName, String lastName, String email){
		
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		
	}
	
	// Setter method for firstName
	public void setFirstName( String firstName) {
		this.firstName = firstName;
	}
	
	// Getter method for firstName
	public String getFirstName () {
		return firstName;
		
	}
	
	// Setter method for lastName
	public void setLastName (String lastName) {
		this.lastName=lastName;
	}
	
	// Getter method for lastName
	public String getLastName () {
		return lastName;
		
	}
	
	// Setter method for email
	public void setEmail (String email) {
		this.email=email;
	}
	
	 // Getter method for email
	public String getEmail () {
		return email;
		
	}

}

