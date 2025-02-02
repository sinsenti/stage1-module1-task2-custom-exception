package com.epam.mjc;

// Task 1: Custom Exception Class
class StudentNotFoundException extends IllegalArgumentException {
    public StudentNotFoundException(long id) {
        // Task 2: Custom message with student ID
        super("Could not find student with ID " + id);
    }
}

// Task 3: StudentManager Class
public class StudentManager {
    private static final long[] IDs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    // Method to find a student by ID
    public Student find(long studentID) throws StudentNotFoundException {
        Student student = Student.getValueOf(studentID);
        if (student == null) {
            // Throw custom exception if student is not found
            throw new StudentNotFoundException(studentID);
        }
        return student;
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        // Test the find method for each ID
        for (long id : IDs) {
            try {
                Student student = manager.find(id);
                System.out.println("Student name: " + student.getName());
            } catch (StudentNotFoundException e) {
                // Handle the exception and print the error message
                System.err.println(e.getMessage());
            }
        }

        // Test with an invalid ID
        try {
            Student student = manager.find(99); // Invalid ID
            System.out.println("Student name: " + student.getName());
        } catch (StudentNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
