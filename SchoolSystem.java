import java.util.ArrayList;

class School {
    // Class attributes
    private String schoolName;
    private ArrayList<Student> students;

    // Parameterized Constructor
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    // Method to add students
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to display students
    public void displayStudents() {
        System.out.println("Students in " + schoolName + ":");
        for (Student student : students) {
            System.out.println("-> " + student.getStudentName());
        }
    }
}

class Student {
    // Class attributes
    private String studentName;
    private ArrayList<Course> enrolledCourses;

    // Parameterized Constructor
    public Student(String studentName) {
        this.studentName = studentName;
        this.enrolledCourses = new ArrayList<>();
    }

    // Method to add students to course
    public void enrollToCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this);
    }

    // Method to view enrolled courses
    public void viewEnrolledCourses() {
        System.out.println(studentName + " is enrolled in courses:");
        for (Course course : enrolledCourses) {
            System.out.println("-> " + course.getCourseName());
        }
    }

    // Method to get student name
    public String getStudentName() {
        return studentName;
    }
}

class Course {
    // Class attributes
    private String courseName;
    private ArrayList<Student> enrolledStudents;

    // Parameterized Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    // Method to add student
    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    // Method to view enrolled students
    public void viewEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : enrolledStudents) {
            System.out.println("-> " + student.getStudentName());
        }
    }

    // Method to get course name
    public String getCourseName() {
        return courseName;
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        School school = new School("Public School");

        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");
        Student student3 = new Student("Charlie");

        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);

        Course subject1 = new Course("Data Structures");
        Course subject2 = new Course("Web Development");
        Course subject3 = new Course("Cloud Computing");

        student1.enrollToCourse(subject1);
        student1.enrollToCourse(subject2);

        student2.enrollToCourse(subject2);
        student2.enrollToCourse(subject3);

        student3.enrollToCourse(subject1);
        student3.enrollToCourse(subject3);

        school.displayStudents();

        student1.viewEnrolledCourses();
        student2.viewEnrolledCourses();
        student3.viewEnrolledCourses();

        subject1.viewEnrolledStudents();
        subject2.viewEnrolledStudents();
        subject3.viewEnrolledStudents();
    }
}

/*
Output:
    Students in Public School:
    -> Alice
    -> Bob
    -> Charlie
    Alice is enrolled in courses:
    -> Data Structures
    -> Web Development
    Bob is enrolled in courses:
    -> Web Development
    -> Cloud Computing
    Charlie is enrolled in courses:
    -> Data Structures
    -> Cloud Computing
    Students enrolled in Data Structures:
    -> Alice
    -> Charlie
    Students enrolled in Web Development:
    -> Alice
    -> Bob
    Students enrolled in Cloud Computing:
    -> Bob
    -> Charlie
 */