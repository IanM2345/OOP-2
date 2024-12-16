//Ian Mwai Gachoki
//3132394

package griffith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main (String [] args) {
		
		// Initializing lecturers with specific attributes
		Lecturer lecturerOne= new Lecturer ("Saturo", "Gojo", "SpecialGrade");
		Lecturer lecturerTwo= new Lecturer ("Jinpachi", "Ego", "BlueLock");
		Lecturer lecturerThree = new Lecturer ("Ha", "Jinsung","FUG");
		
		// Initializing subjects and assign associated lecturers and credits
		Subject subjectOne = new Subject ("Ryoiki Tenkai", lecturerOne, 5);
		Subject subjectTwo = new Subject ("Ego", lecturerTwo, 10);
		Subject subjectThree = new Subject ("Shinsu Control", lecturerThree,5);
		
		// Enrolling students in subjectOne as either honor or ordinary student and IDs
		subjectOne.enroll(new HonorStudent("Yuta", "Okkotsu", 0));
        subjectOne.enroll(new OrdinaryStudent("Yuji", "Itadori", 1));
        subjectOne.enroll(new HonorStudent ("Roronoa","Zoro",3));
        subjectOne.enroll("Maki", "Zenin", 99,2);
        subjectOne.enroll("Aoi", "Todo", 7, 3);
        subjectOne.enroll("Kinji", "Hakari", 27, 3);
        
     // Enrolling students in subjectTwo as either honor or ordinary student and IDs
        subjectTwo.enroll(new HonorStudent ("Rin","Itoshi",10));
        subjectTwo.enroll(new OrdinaryStudent ("Yoichi", "Isagi",11));
        subjectTwo.enroll(new HonorStudent ("Roronoa","Zoro",3));
        subjectTwo.enroll("Seishiro","Nagi",6,1);
        subjectTwo.enroll("Shoei","Baro",13,2);
        subjectTwo.enroll("Maki", "Zenin", 99,2);
        
      // Enrolling students in subjectThree as either honor or ordinary student and IDS
        subjectThree.enroll(new HonorStudent("25th", "Bam",21));
        subjectThree.enroll(new OrdinaryStudent("Karaka","God of Fug",333));
        subjectThree.enroll(new HonorStudent ("Roronoa","Zoro",3));
        subjectThree.enroll("Aoi", "Todo", 7, 3);
        subjectThree.enroll("Hwa","Ryun", 20,0);
        
        // Displaying enrolled students in subjectOne  with  either honor or ordinary student labels
        System.out.println("=== Students in Ryoiki Tenkai ===");
        for (Student student : subjectOne.getStudents()) {
            String type = (student instanceof HonorStudent) ? "BSCH" : "BSCO"; 
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - " + type);
        }

     // Displaying enrolled students in subjectTwo  with  either honor or ordinary student labels
        System.out.println("\n=== Students in Ego ===");
        for (Student student : subjectTwo.getStudents()) {
            String type = (student instanceof HonorStudent) ? "BSCH" : "BSCO";
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - " + type);
        }

     // Displaying enrolled students in subjectThree  with  either honor or ordinary student labels
        System.out.println("\n=== Students in Shinsu Control ===");
        for (Student student : subjectThree.getStudents()) {
            String type = (student instanceof HonorStudent) ? "BSCH" : "BSCO";
            System.out.println(student.getFirstName() + " " + student.getLastName() + " - " + type);
        }

     // Identifying and displaying students enrolled in multiple subjects 
        System.out.println("\n=== Display Info for Students enrollled in Multiple Subjects (Overachievers) ===");
        ArrayList<Student> overachiversStudents = findOverAchivers(subjectOne, subjectTwo, subjectThree);
        for (Student student : overachiversStudents) {
            student.displayInfo();
        }
    
	}
	
	// Method to find students enrolled in multiple subjects
	private static ArrayList<Student> findOverAchivers(Subject... subjects) {
		HashMap<Integer, Student> studentMap = new HashMap<>(); // Mapping student ID to Student object
        HashMap<Integer, Integer> studentCounts = new HashMap<>(); // Counting occurrences per student ID
        ArrayList<Student> overachivers = new ArrayList<>(); // List of students enrolled in multiple subjects

     // Populating maps with student enrollments and counts
	    for (Subject subject : subjects) {
	        for (Student student : subject.getStudents()) {
	            int id = student.getId();
	            studentMap.putIfAbsent(id, student);  
	            studentCounts.put(id, studentCounts.getOrDefault(id, 0) + 1); 
	        }
	    }

	    
	 // Filtering students enrolled in more than one subject
	    for (Map.Entry<Integer, Integer> entry : studentCounts.entrySet()) {
	        if (entry.getValue() > 1) {
	            overachivers.add(studentMap.get(entry.getKey()));
	        }
	    }

	    return overachivers;
	}

	
	
}
