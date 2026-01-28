package level1;

/*
 * This class stores employee information such as
 * name, id, and salary, and displays it using a method.
 */

class DisplayEmployeeDetails {

    String name;
    int id;
    double salary;

    /*
     * This method prints employee details
     * in a structured format.
     */
    void display() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: " + salary);
    }

    /*
     * Main method creates an employee object,
     * assigns values, and displays the details.
     */
    public static void main(String[] args) {
        DisplayEmployeeDetails emp = new DisplayEmployeeDetails();

        emp.name = "Rahul";
        emp.id = 101;
        emp.salary = 45000;

        emp.display();
    }
}
