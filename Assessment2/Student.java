package Assessment2;

/**
 * ============================================================
 * File Name: Student.java
 * Description:
 *   The Student class extends Person and represents a "student" in the system.
 *
 * OOP Concepts Covered:
 *   1. Inheritance —— Using the `extends` keyword to inherit from `Person`
 *   2. Polymorphism —— Overriding the `displayRole()` and `getDuty()` methods
 *   3. Encapsulation —— New properties are also declared as `private`
 *   4. Classes and Objects —— Student is a concrete class
 * ============================================================
 */
import java.util.ArrayList;

public class Student extends Person {

    // ===== Private Attributes =====
    private String studentId;     // Student number (academic ID)
    private String major;         // Major
    private double gpa;           // Grade Point Average
    private String[] enrolledCourses;  // List of enrolled courses
    private int courseCount;      // Number of enrolled courses

    /**
     * Constructor
     * First call the superclass constructor super(...) to initialize
     * inherited attributes, then initialize the subclass's own attributes.
     *
     * @param name 
     * @param age  
     * @param gender 
     * @param id  
     * @param studentId // student number
     * @param major  
     */
    public Student(String name, int age, String gender, String id,
                   String studentId, String major) {
        // Call the superclass constructor
        super(name, age, gender, id);
        this.studentId = studentId;
        this.major = major;
        this.gpa = 0.0;   // Default GPA is 0
        // Initialize the course array, assuming each student can take up to 10 courses.
        this.enrolledCourses = new String[10];
        this.courseCount = 0;
    }

    // Getters and Setters =====
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getGpa() {
        return gpa;
    }

    /**
     * Set the GPA
     * Validate range 0.0 ~ 4.0
     */
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Invalid GPA, should be between 0.0 and 4.0");
        }
    }

    /**
     * Enroll in a course
     * Checks if the course array is full; if not, adds the course name.
     *
     * @param courseName course name
     */
    public void enrollCourse(String courseName) {
        //Use if to check whether the array is full
        if (courseCount < enrolledCourses.length) {
            enrolledCourses[courseCount] = courseName;
            courseCount++;
            System.out.println("Student " + getName() + " enrolled in: " + courseName);
        } else {
            System.out.println("Course limit reached, cannot enroll more.");
        }
    }

    /**
     * Display enrolled courses
     * Uses a for loop to iterate the array (demonstrates basic Java control structures).
     */
    public void displayEnrolledCourses() {
        System.out.println("\n--- " + getName() + " Enrolled Courses ---");
        if (courseCount == 0) {
            System.out.println("No enrolled courses yet.");
        } else {
            // for loop to iterate the array
            for (int i = 0; i < courseCount; i++) {
                System.out.println((i + 1) + ". " + enrolledCourses[i]);
            }
        }
    }

    /**
     * Drop a course
     * Removes the specified course from the enrolled courses list.
     * Uses array element shifting to fill the gap left by the removed element.
     *
     * @param courseName 
     * @return true on success, false if the course was not enrolled
     */
    public boolean dropCourse(String courseName) {
        // Iterate the enrolled courses array to find a match.
        for (int i = 0; i < courseCount; i++) {
            if (enrolledCourses[i] != null && enrolledCourses[i].equals(courseName)) {
                // Once found, shift subsequent elements forward to fill the gap.
                for (int j = i; j < courseCount - 1; j++) {
                    enrolledCourses[j] = enrolledCourses[j + 1];
                }
                // Clear the last slot and decrement the count.
                enrolledCourses[courseCount - 1] = null;
                courseCount--;
                System.out.println("Student " + getName() + " dropped course: " + courseName);
                return true;
            }
        }
        System.out.println("Student " + getName() + " has not enrolled in: " + courseName);
        return false;
    }

    /**
     * Drop all enrolled courses
     * Used to clear enrollment records before deleting the student,
     * and also synchronously update the enrolled count on the corresponding Course objects.
     *
     * @param courses all courses in the system
     */
    public void dropAllCourses(ArrayList<Course> courses) {
        // Iterate enrolled courses and unregister on each corresponding Course object.
        for (int i = 0; i < courseCount; i++) {
            String courseName = enrolledCourses[i];
            // Find the corresponding Course object in the list and unregister.
            for (Course c : courses) {
                if (c.getCourseName().equals(courseName)) {
                    c.unregisterStudent();
                    break;
                }
            }
        }
        //Clear the enrolled courses array
        for (int i = 0; i < courseCount; i++) {
            enrolledCourses[i] = null;
        }
        courseCount = 0;
        System.out.println("All enrollment records of student " + getName() + " have been cleared");
    }

    /**
     * Check whether a course is enrolled
     *
     * @param courseName 
     * @return true if enrolled, false otherwise
     */
    public boolean hasEnrolledCourse(String courseName) {
        for (int i = 0; i < courseCount; i++) {
            if (enrolledCourses[i] != null && enrolledCourses[i].equals(courseName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Override the abstract method displayRole()
     * This demonstrates polymorphism: when called via a superclass reference,
     * the subclass version is actually executed.
     */
    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }

    /**
     * Override the abstract method getDuty()
     */
    @Override
    public String getDuty() {
        return "Study courses and complete academic requirements";
    }

    /**
     * Override the superclass's showBasicInfo()
     * Extends the parent version with student-specific information.
     */
    @Override
    public void showBasicInfo() {
        // First call the parent version
        super.showBasicInfo();
        // Then print student-specific info
        System.out.println("Student ID : " + studentId);
        System.out.println("Major      : " + major);
        System.out.println("GPA        : " + gpa);
    }
}