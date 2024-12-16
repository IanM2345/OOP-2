//Ian Mwai Gachoki
//3132394

package griffith;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Subject implements Roster {

    // Private attributes for the subject's title, assigned lecturer, credit value, and enrolled students list
    private String title;
    private Lecturer lecturer;
    private int credits;
    private ArrayList<Student> Roster; // List of students enrolled in this subject
    
    // Constructor initializing subject title, lecturer, credits, and creating an empty roster
    public Subject(String title, Lecturer lecturer, int credits) {
        this.title = title;
        this.lecturer = lecturer;
        this.credits = credits;
        this.Roster = new ArrayList<>();
    }
    
    // Getter and setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and setter for lecturer
    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    // Getter and setter for credits
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    // Getter for the list of all students enrolled in the subject
    public ArrayList<Student> getStudents() {
        return Roster;
    }
    
    // Method to get all honor students (BSCH) enrolled in the subject
    public ArrayList<HonorStudent> getBSCHStudents() {
        return Roster.stream()
                     .filter(s -> s instanceof HonorStudent) // Filtering only HonorStudent instances
                     .map(s -> (HonorStudent) s) // Casting to HonorStudent
                     .collect(Collectors.toCollection(ArrayList::new));
    }
    
    // Method to get all ordinary students (BSCO) enrolled in the subject
    public ArrayList<OrdinaryStudent> getBSCOStudents() {
        return Roster.stream()
                     .filter(s -> s instanceof OrdinaryStudent) // Filtering only OrdinaryStudent instances
                     .map(s -> (OrdinaryStudent) s) // Casting to OrdinaryStudent
                     .collect(Collectors.toCollection(ArrayList::new));
    }

    // Method to find a student by their ID; returns null if the student is not found
    public Student getStudent(int id) {
        return Roster.stream()
                     .filter(s -> s.getId() == id) // Filtering by student ID
                     .findFirst()
                     .orElse(null);
    }

    // Method to retrieve students by first or last name, sorted by ID
    public ArrayList<Student> getStudents(String name) {
        return Roster.stream()
                     .filter(s -> s.getFirstName().equals(name) || s.getLastName().equals(name)) // Filtering by name
                     .sorted((s1, s2) -> Integer.compare(s1.getId(), s2.getId())) // Sorting by ID
                     .collect(Collectors.toCollection(ArrayList::new));
    }
    
    // Method to enroll a student if not already in the roster (based on ID); returns true if successful
    public boolean enroll(Student student) {
        for (Student s : Roster) {
            if (s.getId() == student.getId()) { // Checking for duplicate student ID
                return false; 
            }
        }
        Roster.add(student); // Adding student if no duplicate ID found
        return true;
    }

    // Method to enroll a student using details; determines if they are an honor or ordinary student based on years
    public boolean enroll(String firstname, String lastname, int id, int years) {
        for (Student s : Roster) {
            if (s.getId() == id) { // Checking for duplicate student ID
                return false;
            }
        }
        Student student;
        if (years == 4) {
            student = new HonorStudent(firstname, lastname, id); // Creates an HonorStudent if years == 4
        } else {
            student = new OrdinaryStudent(firstname, lastname, id); // Creates an OrdinaryStudent otherwise
        }
        Roster.add(student); // Adding the new student to the roster
        return true;
    }
}
