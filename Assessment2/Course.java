package Assessment2;

/**
 * ============================================================
 * File Name: Course.java
 * Description:
 *   The Course class represents a "course" in the system. It is the
 *   third core class related to Person/Student/Teacher, satisfying
 *   the "at least 3 related classes" requirement.
 *
 * OOP Concepts Covered:
 *   1. Classes and Objects —— Course It is a standalone class
 *   2. Encapsulation) —— All properties are private and accessed via getters and setters.
 * ============================================================
 */
public class Course {

    // Private Attributes 
    private String courseCode;     // Course code
    private String courseName;     // Course name
    private int creditHours;       // Credit hours
    private String instructor;     // Instructor name
    private int maxCapacity;       // Maximum capacity
    private int enrolledCount;     // Number of enrolled students

    /**
     * Constructor
     *
     * @param courseCode  // course code
     * @param courseName  // course name
     * @param creditHours // credit hours
     * @param instructor  // instructor
     * @param maxCapacity // max capacity
     */
    public Course(String courseCode, String courseName, int creditHours,
                  String instructor, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.instructor = instructor;
        this.maxCapacity = maxCapacity;
        this.enrolledCount = 0;   // Initial enrolled count is 0
    }

    // Getters and Setters =====
    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        if (creditHours > 0) {
            this.creditHours = creditHours;
        } else {
            System.out.println("Invalid credit hours: " + creditHours);
        }
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getEnrolledCount() {
        return enrolledCount;
    }

    /**
     * Register a student enrollment
     * Each call increments the enrolled count and checks capacity.
     *
     * @return // true on success, false if full
     */
    public boolean registerStudent() {
        if (enrolledCount < maxCapacity) {
            enrolledCount++;
            return true;
        } else {
            System.out.println(" Course " + courseName + " is full.");
            return false;
        }
    }

    /**
     *  Unregister a student enrollment
     * Each call decrements the enrolled count and checks it is greater than 0.
     * Used when a student drops a course or is deleted to keep the course's
     * enrolled count in sync.
     *
     * @return // true on success, false if already 0
     */
    public boolean unregisterStudent() {
        if (enrolledCount > 0) {
            enrolledCount--;
            return true;
        } else {
            System.out.println(" Course " + courseName + " has 0 enrolled students.");
            return false;
        }
    }

    /**
     * Display course information
     * Uses formatted output, reflecting "proper output formatting".
     */
    public void displayCourseInfo() {
        System.out.println("Course Code  : " + courseCode);
        System.out.println("Course Name  : " + courseName);
        System.out.println("Credit Hours : " + creditHours);
        System.out.println("Instructor   : " + instructor);
        System.out.println("Capacity     : " + enrolledCount + "/" + maxCapacity);
    }
}