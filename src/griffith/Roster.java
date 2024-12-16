//Ian Mwai Gachoki
//3132394

package griffith;

import java.util.ArrayList;

public interface Roster {

    // Retrieves a list of all students in the roster
    ArrayList<Student> getStudents();

    // Retrieves a list of all honor students (BSCH) in the roster
    ArrayList<HonorStudent> getBSCHStudents();

    // Retrieves a list of all ordinary students (BSCO) in the roster
    ArrayList<OrdinaryStudent> getBSCOStudents();

    // Finds a student by their unique ID; returns null if student not found
    Student getStudent(int id);

    // Retrieves students by their first or last name, sorted by ID
    ArrayList<Student> getStudents(String name);

    // Enrolls a student if they are not already in the roster; returns true if enrollment is successful
    boolean enroll(Student student);

    // Enrolls a student using their name, ID, and years in the program; returns true if enrollment is successful
    boolean enroll(String firstname, String lastname, int id, int years);
}