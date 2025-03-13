import java.util.ArrayList;

class Employee {
    // Class attributes
    private String employeeName;

    // Parameterized Constructor
    public Employee(String employeeName) {
        this.employeeName = employeeName;
    }

    // Method to get employee name
    public String getEmployeeName() {
        return employeeName;
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("  Employee: " + employeeName);
    }
}

class Department {
    // Class attributes
    private String departmentName;
    private ArrayList<Employee> employees;

    // Parameterized Constructor
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    // Method to add employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Method to display department details
    public void displayDepartmentDetails() {
        System.out.println("Department: " + departmentName);
        for (Employee employee : employees) {
            employee.displayEmployeeDetails();
        }
    }
}

class Company {
    // Class attributes
    private String companyName;
    private ArrayList<Department> departments;

    // Parameterized Constructor
    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    // Method to add department
    public void addDepartment(Department department) {
        departments.add(department);
    }

    // Method to display company details
    public void displayCompanyDetails() {
        System.out.println("Company: " + companyName);
        for (Department department : departments) {
            department.displayDepartmentDetails();
        }
    }

    // Method to delete company
    public void deleteCompany() {
        System.out.println("Deleting Company: " + companyName);
        departments.clear();
        System.out.println("Company deleted. Departments and employees are also deleted.");
    }
}

public class CompanySystem {
    public static void main(String[] args) {
        Company company = new Company("Tech Innovations Inc.");

        Department sales = new Department("Sales");
        sales.addEmployee(new Employee("Alice"));
        sales.addEmployee(new Employee("Bob"));

        Department development = new Department("Development");
        development.addEmployee(new Employee("Charlie"));
        development.addEmployee(new Employee("David"));

        company.addDepartment(sales);
        company.addDepartment(development);

        company.displayCompanyDetails();

        company.deleteCompany();
    }
}

/*
Output:
    Company: Tech Innovations Inc.
    Department: Sales
      Employee: Alice
      Employee: Bob
    Department: Development
      Employee: Charlie
      Employee: David
    Deleting Company: Tech Innovations Inc.
    Company deleted. Departments and employees are also deleted.
 */