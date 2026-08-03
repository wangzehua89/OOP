package Assessment2;

/**
 * ============================================================
 * File Name: Teacher.java
 * Description:
 *   The Teacher class also extends Person and represents a "teacher" in the system.
 *
 * OOP Concepts Covered:
 *   1. Inheritance —— extends Person
 *   2. Polymorphism —— overriding displayRole() and getDuty()
 *   3. Encapsulation —— private properties + getter/setter
 *
 *   Note: Student and Teacher both extend Person but have different behaviors,
 *   which is a classic scenario of runtime polymorphism.
 * ============================================================
 */
import java.util.ArrayList;

public class Teacher extends Person {

    // ===== Private Attributes =====
    private String employeeId;     // Employee ID
    private String department;     // Department
    private String[] teachingCourses;  // List of courses taught
    private int courseCount;      // Number of courses taught

    /**
     * Constructor
     * Calls super(...) to initialize parent attributes, then initializes subclass attributes.
     *
     * @param name        
     * @param age          
     * @param gender     
     * @param id          
     * @param employeeId  
     * @param department 
     */
    public Teacher(String name, int age, String gender, String id,
                   String employeeId, String department) {
        super(name, age, gender, id);   // Call superclass constructor
        this.employeeId = employeeId;
        this.department = department;
        this.teachingCourses = new String[10];   // Assume each teacher can teach up to 10 courses
        this.courseCount = 0;
    }

    // ===== Getters and Setters =====
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Add a teaching course
     *
     * @param courseName 
     */
    public void addTeachingCourse(String courseName) {
        if (courseCount < teachingCourses.length) {
            teachingCourses[courseCount] = courseName;
            courseCount++;
            System.out.println("Teacher " + getName() + " assigned course: " + courseName);
        } else {
            System.out.println("Teaching course limit reached.");
        }
    }

    /** Display teaching courses */
    public void displayTeachingCourses() {
        System.out.println("\n--- " + getName() + " Teaching Courses ---");
        if (courseCount == 0) {
            System.out.println("No teaching courses yet.");
        } else {
            // for-each loop to iterate the array
            int index = 1;
            for (int i = 0; i < courseCount; i++) {
                System.out.println(index + ". " + teachingCourses[i]);
                index++;
            }
        }
    }

    /**
     *  Remove a teaching course
     * Removes the specified course from the teaching courses list.
     * Uses array element shifting to fill the gap left by the removed element.
     *
     * @param courseName 
     * @return true on success, false if the course was not being taught
     */
    public boolean removeTeachingCourse(String courseName) {
        // Iterate the teaching courses array to find a match.
        for (int i = 0; i < courseCount; i++) {
            if (teachingCourses[i] != null && teachingCourses[i].equals(courseName)) {
                // Once found, shift subsequent elements forward to fill the gap.
                for (int j = i; j < courseCount - 1; j++) {
                    teachingCourses[j] = teachingCourses[j + 1];
                }
                // Clear the last slot and decrement the count.
                teachingCourses[courseCount - 1] = null;
                courseCount--;
                System.out.println("Teacher " + getName() + " removed course: " + courseName);
                return true;
            }
        }
        System.out.println("Teacher " + getName() + " does not teach: " + courseName);
        return false;
    }

    /**
     * Remove all teaching courses
     * Used to clear teaching records before deleting the teacher,
     * and also set the instructor field of corresponding courses to "TBD".
     *
     * @param courses all courses in the system
     */
    public void removeAllTeachingCourses(ArrayList<Course> courses) {
        // Iterate teaching courses and update the instructor field on each corresponding Course object.
        for (int i = 0; i < courseCount; i++) {
            String courseName = teachingCourses[i];
            // Find the corresponding Course object in the list and update the instructor.
            for (Course c : courses) {
                if (c.getCourseName().equals(courseName)) {
                    c.setInstructor("TBD");
                    break;
                }
            }
        }
        // Clear the teaching courses array
        for (int i = 0; i < courseCount; i++) {
            teachingCourses[i] = null;
        }
        courseCount = 0;
        System.out.println("All teaching records of teacher " + getName() + " have been cleared");
    }

    /**
     * Check whether a course is being taught
     *
     * @param courseName 
     * @return true if teaching, false otherwise
     */
    public boolean hasTeachingCourse(String courseName) {
        for (int i = 0; i < courseCount; i++) {
            if (teachingCourses[i] != null && teachingCourses[i].equals(courseName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Override displayRole()
     * Different from Student's implementation, demonstrating polymorphism.
     */
    @Override
    public void displayRole() {
        System.out.println("Role: Teacher");
    }

    /**
     * Override getDuty()
     */
    @Override
    public String getDuty() {
        return "Teach courses and guide students in learning";
    }

    /**
     * Override showBasicInfo()
     */
    @Override
    public void showBasicInfo() {
        super.showBasicInfo();
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Department  : " + department);
    }
}