//Ian Mwai Gachoki
//3132394

package griffith;

public class HonorStudent extends Student {

	// Constructor initializing an honor student with a fixed 360 credits and 4 years of study
	public HonorStudent (String firstName, String lastName, int id) {
		super (firstName, lastName, id, 360, 4);
	}
	
	// Overriding  method to display honor student-specific information
	public void displayInfo() {
	    System.out.println("Honor Student: " + getFirstName() + " " + getLastName());
	}
}
