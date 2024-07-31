class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }
}

public class EmployeeManagement {
    private Employee[] employees;
    private int count;

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count++] = employee;
        } else {
            System.out.println("Array is full, can't add more employees.");
        }
    }

    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            Employee employee = employees[i];
            System.out.println("ID: " + employee.getEmployeeId() + ", Name: " + employee.getName() +
                    ", Position: " + employee.getPosition() + ", Salary: " + employee.getSalary());
        }
    }

    public void deleteEmployee(int employeeId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[count - 1] = null; // Optional: Clear the last element
            count--;
        } else {
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement(10);
        em.addEmployee(new Employee(1, "Alice", "Developer", 75000));
        em.addEmployee(new Employee(2, "Bob", "Manager", 85000));
        em.addEmployee(new Employee(3, "Charlie", "Analyst", 65000));

        em.traverseEmployees();

        Employee emp = em.searchEmployee(2);
        if (emp != null) {
            System.out.println("Found Employee: " + emp.getName());
        }

        em.deleteEmployee(2);
        em.traverseEmployees();
    }
}

