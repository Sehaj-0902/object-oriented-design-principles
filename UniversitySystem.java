import java.util.ArrayList;

class University {
    // Class attributes
    private String universityName;
    private ArrayList<Department> departments;

    // Parameterized Constructor
    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
    }

    // Method to add department
    public void addDepartment(Department department) {
        departments.add(department);
    }

    // Method to display university details
    public void displayUniversityDetails() {
        System.out.println("University: " + universityName);
        for (Department department : departments) {
            department.displayDepartmentDetails();
        }
    }

    // Method to delete university
    public void deleteUniversity() {
        System.out.println("Deleting University: " + universityName);
        departments.clear();
        System.out.println("University deleted. Departments are also deleted.");
    }
}

class Department {
    // Class attributes
    private String departmentName;
    private ArrayList<Faculty> faculties;

    // Parameterized Constructor
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.faculties = new ArrayList<>();
    }

    // Method to add faculty
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Method to display department details
    public void displayDepartmentDetails() {
        System.out.println("Faculty in " + departmentName + " department:");
        for (Faculty faculty : faculties) {
            faculty.displayFacultyDetails();
        }
    }
}

class Faculty {
    // Class attributes
    private String facultyName;

    // Parameterized Constructor
    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    // Method to get faculty name
    public String getFacultyName() {
        return facultyName;
    }

    // Method to display faculty details
    public void displayFacultyDetails() {
        System.out.println("Faculty: " + facultyName);
    }
}
public class UniversitySystem {
    public static void main(String[] args) {
        University university = new University("Central University");

        Department department1 = new Department("Computer Science");
        Department department2 = new Department("Robotics");

        Faculty faculty1 = new Faculty("Prof. Smith");
        Faculty faculty2 = new Faculty("Prof. Sharma");
        Faculty faculty3 = new Faculty("Prof. Gupta");

        department1.addFaculty(faculty1);
        department1.addFaculty(faculty2);
        department2.addFaculty(faculty2);
        department2.addFaculty(faculty3);

        university.addDepartment(department1);
        university.addDepartment(department2);

        university.displayUniversityDetails();

        university.deleteUniversity();

        System.out.println("Faculty can exist outside a department independently:");
        faculty1.displayFacultyDetails();
        faculty2.displayFacultyDetails();
        faculty3.displayFacultyDetails();
    }
}

/*
Output:
    University: Central University
    Faculty in Computer Science department:
    Faculty: Prof. Smith
    Faculty: Prof. Sharma
    Faculty in Robotics department:
    Faculty: Prof. Sharma
    Faculty: Prof. Gupta
    Deleting University: Central University
    University deleted. Departments are also deleted.
    Faculty can exist outside a department independently:
    Faculty: Prof. Smith
    Faculty: Prof. Sharma
    Faculty: Prof. Gupta
 */