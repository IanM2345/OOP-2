//Ian Mwai Gachoki
//3132394

package griffith;

public class OrdinaryStudent extends Student {
  
	// Constructor initializing an ordinary student with a fixed 300 credits and 3 years of study
	public OrdinaryStudent (String firstName, String lastName, int id) {
		super (firstName, lastName, id, 300, 3);
	}
	
	// Overriding d method to display ordinary student-specific information
	public void displayInfo() {
        System.out.println("Ordinary Student: " + getFirstName() + " " + getLastName());
    }
}
