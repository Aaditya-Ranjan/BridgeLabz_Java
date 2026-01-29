package level2;

/*
 * This class stores student information.
 * It uses a parameterized constructor to initialize data,
 * calculate grade, and display a complete student report.
 */

class StudentReport {

    String name;
    int rollNumber;
    int marks;

    // Initializes student details using constructor
    StudentReport(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Calculates and returns grade based on marks
    String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else return "Fail";
    }

    // Displays full student report
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    // Main method to create student object and display report
    public static void main(String[] args) {
        StudentReport s = new StudentReport("Aman", 12, 82);
        s.display();
    }
}
