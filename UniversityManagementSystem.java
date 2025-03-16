import java.util.ArrayList;

class StudentInfo {
    // Class attributes
    private String studentName;
    private ArrayList<CourseInfo> courses;

    // Parameterized Constructor
    public StudentInfo(String studentName) {
        this.studentName = studentName;
        this.courses = new ArrayList<>();
    }

    // Method to get student name
    public String getStudentName() {
        return studentName;
    }

    // Method to add student to course
    public void enrollStudentToCourse(CourseInfo course) {
        courses.add(course);
        course.addStudentToCourse(this);
    }

    // Method to display student courses
    public void displayStudentCourses() {
        System.out.println(studentName + "'s enrolled courses:");
        for (CourseInfo course : courses) {
            System.out.println("-> " + course.getCourseName());
        }
    }
}

class Professor {
    // Class attributes
    private String professorName;
    private ArrayList<CourseInfo> courses;

    // Parameterized Constructor
    public Professor(String professorName) {
        this.professorName = professorName;
        this.courses = new ArrayList<>();
    }

    // Method to get professor name
    public String getProfessorName() {
        return professorName;
    }

    // Method to assign course to professor
    public void assignCourse(CourseInfo course) {
        courses.add(course);
        course.setProfessor(this);
    }

    // Method to display professor courses
    public void displayProfessorCourses() {
        System.out.println(professorName + "'s courses: ");
        for (CourseInfo course : courses) {
            System.out.println("-> " + course.getCourseName());
        }
    }
}

class CourseInfo {
    // Class attributes
    private String courseName;
    private Professor professor;
    private ArrayList<StudentInfo> studentsEnrolled;

    // Parameterized Constructor
    public CourseInfo(String courseName) {
        this.courseName = courseName;
        this.studentsEnrolled = new ArrayList<>();
    }

    // Method to get course name
    public String getCourseName() {
        return courseName;
    }

    // Method to set the professor
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    // Method to add student to course
    public void addStudentToCourse(StudentInfo student) {
        studentsEnrolled.add(student);
    }

    // Method to display course details
    public void displayCourseDetails() {
        System.out.println("Course: " + getCourseName());
        System.out.println("Associated Professor: " + professor.getProfessorName());
        System.out.println("Enrolled Students in " + getCourseName() + ":");
        for (StudentInfo student : studentsEnrolled) {
            System.out.println("-> " + student.getStudentName());
        }
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        StudentInfo student1 = new StudentInfo("Alice");
        StudentInfo student2 = new StudentInfo("Charlie");
        StudentInfo student3 = new StudentInfo("Olivia");

        Professor professor1 = new Professor("Dr. Smith");
        Professor professor2 = new Professor("Dr. Williams");

        CourseInfo course1 = new CourseInfo("Data Structures");
        CourseInfo course2 = new CourseInfo("Web Development");
        CourseInfo course3 = new CourseInfo("Cloud Computing");

        student1.enrollStudentToCourse(course1);
        student1.enrollStudentToCourse(course2);

        student2.enrollStudentToCourse(course1);
        student2.enrollStudentToCourse(course3);

        student3.enrollStudentToCourse(course2);
        student3.enrollStudentToCourse(course3);

        professor1.assignCourse(course1);
        professor1.assignCourse(course3);

        professor2.assignCourse(course2);

        System.out.println("Course Details:");
        course1.displayCourseDetails();
        course2.displayCourseDetails();
        course3.displayCourseDetails();

        System.out.println("\nProfessor Courses:");
        professor1.displayProfessorCourses();
        professor2.displayProfessorCourses();

        System.out.println("\nStudent Courses:");
        student1.displayStudentCourses();
        student2.displayStudentCourses();
        student3.displayStudentCourses();
    }
}

/*
Output:
    Course Details:
    Course: Data Structures
    Associated Professor: Dr. Smith
    Enrolled Students in Data Structures:
    -> Alice
    -> Charlie
    Course: Web Development
    Associated Professor: Dr. Williams
    Enrolled Students in Web Development:
    -> Alice
    -> Olivia
    Course: Cloud Computing
    Associated Professor: Dr. Smith
    Enrolled Students in Cloud Computing:
    -> Charlie
    -> Olivia

    Professor Courses:
    Dr. Smith's courses:
    -> Data Structures
    -> Cloud Computing
    Dr. Williams's courses:
    -> Web Development

    Student Courses:
    Alice's enrolled courses:
    -> Data Structures
    -> Web Development
    Charlie's enrolled courses:
    -> Data Structures
    -> Cloud Computing
    Olivia's enrolled courses:
    -> Web Development
    -> Cloud Computing
 */