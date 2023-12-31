package edu.nyu.cs.dla9511;

public class Employee {
    // data members
    private String name;             
    private double payRate = 1.0;    
    private final int EMPLOYEE_ID;    // final because ALL CAPS
    private static int nextID;    


    public static final double STARTING_PAY_RATE = 30000.0;  // + STARTING_PAY_RATE : double = 30000.0
    
    // constructors
    public Employee() {
        EMPLOYEE_ID = nextID++;
    }

    public Employee(String name) {
        this();  // to initialize EMPLOYEE_ID and nextID
        this.name = name;
    }

    public Employee(String name, double payRate) {
        this(name);
        this.payRate = payRate;
    }

    // methods

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return EMPLOYEE_ID;
    }

    public double getPayRate() {
        return payRate;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changePayRate(double payRate) {
        this.payRate = payRate;
    }

    public static int getNextID() {
        return nextID;
    }

    public String toString() {
        return "Employee’s name: " + name;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Employee employee = new Employee("daniel", 50000.0);

        // display employee information using toString()
        System.out.println(employee.toString());
    }
}
