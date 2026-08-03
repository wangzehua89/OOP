package Assessment2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ============================================================
 * File Name: StudentManagementSystem.java
 * Description:
 *   This is the main class (entry point) of the system, responsible for:
 *     1. Providing a console menu
 *     2. Receiving user input (Scanner)
 *     3. Using control structures to handle logic
 *     4. Demonstrating runtime polymorphism
 *
 * OOP Concepts Covered:
 *   1. Classes and Objects —— Creating Student, Teacher, and Course objects
 *   2. Polymorphism —— Using a `Person` reference to point to an object of a subclass
 *   3. Basic Java Programming —— if / switch / while / for / Scanner
 *   4. Program Functionality —— Creating objects, displaying information, and performing operations
 * ============================================================
 */
public class StudentManagementSystem {

    /**
     * Main method
     * The entry point of the program.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // Create a Scanner object to receive user input.
        Scanner scanner = new Scanner(System.in);

        // Use ArrayList to store students, teachers, and courses
        // (dynamic array, more flexible than native arrays).
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();

        // Use a Person-typed ArrayList to demonstrate polymorphism:
        // it can hold both Student and Teacher objects.
        ArrayList<Person> people = new ArrayList<>();

        // Pre-load some demo data for easy testing.
        loadDemoData(students, teachers, courses, people);

        // Main loop control variable
        boolean running = true;

        // ===== Main Menu Loop =====
        // Use a while loop to keep showing the menu until the user chooses to exit.
        while (running) {
            printMenu();                          //  Print the menu
            System.out.print("Enter your choice: ");

            // Read the user's choice
            int choice = readInt(scanner);

            // ===== switch control structure =====
            // Execute different branches based on user input.
            switch (choice) {
                case 1:
                    // Add a student
                    addStudent(scanner, students, people);
                    break;
                case 2:
                    // Add a teacher
                    addTeacher(scanner, teachers, people);
                    break;
                case 3:
                    // Add a course
                    addCourse(scanner, courses);
                    break;
                case 4:
                    // Enroll a student in a course
                    enrollStudentInCourse(scanner, students, courses);
                    break;
                case 5:
                    // Delete a student
                    deleteStudent(scanner, students, courses, people);
                    break;
                case 6:
                    // Delete a teacher
                    deleteTeacher(scanner, teachers, courses, people);
                    break;
                case 7:
                    // Drop a course
                    dropCourse(scanner, students, courses);
                    break;
                case 8:
                    // Display all people (polymorphism demo)
                    displayAllPeople(people);
                    break;
                case 9:
                    // Display all courses
                    displayAllCourses(courses);
                    break;
                case 10:
                    // Display all students and their courses
                    displayAllStudents(students);
                    break;
                case 11:
                    // Polymorphism demo: show each person's duty
                    demonstratePolymorphism(people);
                    break;
                case 0:
                    // Exit the system
                    System.out.println("Thank you for using the Student Management System. Goodbye!");
                    running = false;
                    break;
                default:
                    // Handle invalid input
                    System.out.println("Invalid choice, please try again.");
            }
        }

        // Close the Scanner to release resources.
        scanner.close();
    }

    // ============================================================
    //  Menu Printing Method
    // ============================================================
    /**
     * Print the main menu
     * Reflects "proper output formatting".
     */
    private static void printMenu() {
        System.out.println("\n========== Student Management System ==========");
        System.out.println("1. Add Student");
        System.out.println("2. Add Teacher");
        System.out.println("3. Add Course");
        System.out.println("4. Enroll Student in Course");
        System.out.println("5. Delete Student");
        System.out.println("6. Delete Teacher");
        System.out.println("7. Drop Course");
        System.out.println("8. Display All People");
        System.out.println("9. Display All Courses");
        System.out.println("10. Display All Students");
        System.out.println("11. Polymorphism Demo");
        System.out.println("0. Exit");
        System.out.println("==============================================================");
    }

    // ============================================================
    // Utility Methods
    // ============================================================

    /**
     * Safely read an integer
     * Handles the case when the user inputs a non-numeric value.
     *
     * @param scanner Scanner object
     * @return the integer entered by the user
     */
    private static int readInt(Scanner scanner) {
        // Use a while loop to ensure a valid integer is read.
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();   // Discard invalid input
        }
        int value = scanner.nextInt();
        scanner.nextLine();   // Consume the newline character
        return value;
    }

    /**
     * Safely read a double
     */
    private static double readDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    // ============================================================
    // Business Methods
    // ============================================================

    /**
     * Add a student
     * Collects user input via Scanner and creates a Student object.
     */
    private static void addStudent(Scanner scanner,
                                  ArrayList<Student> students,
                                  ArrayList<Person> people) {
        System.out.println("\n--- Add Student ---");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = readInt(scanner);

        System.out.print("Gender: ");
        String gender = scanner.nextLine();

        System.out.print("System ID: ");
        String id = scanner.nextLine();

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Major: ");
        String major = scanner.nextLine();

        //Create a Student object
        Student student = new Student(name, age, gender, id, studentId, major);

        // Add to the student list
        students.add(student);

        // Also add to the Person list (polymorphism: subclass object assigned to superclass reference)
        people.add(student);

        System.out.println("Student added successfully!");
    }

    /**
     * Add a teacher
     */
    private static void addTeacher(Scanner scanner,
                                  ArrayList<Teacher> teachers,
                                  ArrayList<Person> people) {
        System.out.println("\n--- Add Teacher ---");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = readInt(scanner);

        System.out.print("Gender: ");
        String gender = scanner.nextLine();

        System.out.print("System ID: ");
        String id = scanner.nextLine();

        System.out.print("Employee ID: ");
        String employeeId = scanner.nextLine();

        System.out.print("Department: ");
        String department = scanner.nextLine();

        // Create a Teacher object
        Teacher teacher = new Teacher(name, age, gender, id, employeeId, department);

        teachers.add(teacher);
        people.add(teacher);   //Polymorphism: Teacher is also a Person

        System.out.println("Teacher added successfully!");
    }

    /**
     * Add a course
     */
    private static void addCourse(Scanner scanner, ArrayList<Course> courses) {
        System.out.println("\n--- Add Course ---");

        System.out.print("Course Code: ");
        String code = scanner.nextLine();

        System.out.print("Course Name: ");
        String name = scanner.nextLine();

        System.out.print("Credit Hours: ");
        int credit = readInt(scanner);

        System.out.print("Instructor: ");
        String instructor = scanner.nextLine();

        System.out.print("Max Capacity: ");
        int capacity = readInt(scanner);

        // Create a Course object
        Course course = new Course(code, name, credit, instructor, capacity);
        courses.add(course);

        System.out.println("Course added successfully!");
    }

    /**
     * Enroll a student in a course
     * Uses if to validate index, uses for to list options.
     */
    private static void enrollStudentInCourse(Scanner scanner,
                                              ArrayList<Student> students,
                                              ArrayList<Course> courses) {
        // Check if there are students and courses
        if (students.isEmpty()) {
            System.out.println("No students, please add a student first.");
            return;
        }
        if (courses.isEmpty()) {
            System.out.println("No courses, please add a course first.");
            return;
        }

        // 列出所有学生 / List all students
        System.out.println("\n--- Student List ---");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName()
                    + " (" + students.get(i).getStudentId() + ")");
        }
        System.out.print("Select student number: ");
        int studentIndex = readInt(scanner) - 1;

        // 索引合法性检查 / Index validity check
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        // 列出所有课程 / List all courses
        System.out.println("\n--- Course List ---");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName()
                    + " (" + courses.get(i).getCourseCode() + ")");
        }
        System.out.print("Select course number: ");
        int courseIndex = readInt(scanner) - 1;

        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course number.");
            return;
        }

        // Get student and course objects
        Student student = students.get(studentIndex);
        Course course = courses.get(courseIndex);

        // Call the student's enroll method
        student.enrollCourse(course.getCourseName());
        // Also register on the course object
        course.registerStudent();
    }

    /**
     * Delete a student
     * ===== Key Business Rule =====
     * Before deleting a student, if the student has any enrolled courses,
     * all enrollments must be cleared first, and the corresponding Course
     * objects must be unregistered to keep data consistent.
     *
     * @param scanner input scanner
     * @param students student list
     * @param courses  course list
     * @param people   person list (polymorphism)
     */
    private static void deleteStudent(Scanner scanner,
                                      ArrayList<Student> students,
                                      ArrayList<Course> courses,
                                      ArrayList<Person> people) {
        // Check if there are students
        if (students.isEmpty()) {
            System.out.println("No student records.");
            return;
        }

        // 列出所有学生 / List all students
        System.out.println("\n--- Student List ---");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName()
                    + " (" + students.get(i).getStudentId() + ")");
        }
        System.out.print("Select student number to delete: ");
        int studentIndex = readInt(scanner) - 1;

        // 索引合法性检查 / Index validity check
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        // Get the student object to delete
        Student student = students.get(studentIndex);

        // Key step: before deletion, clear all the student's enrollment records.
        // Call the Student class's dropAllCourses() method, which synchronously
        // updates the enrolled count on the corresponding Course objects.
        System.out.println("\nClearing the student's enrollment records...");
        student.dropAllCourses(courses);

        // Remove from the student list
        students.remove(studentIndex);

        // Remove from the Person list (polymorphism list)
        people.remove(student);

        System.out.println(" Student " + student.getName() + " has been deleted.");
    }

    /**
     * Delete a teacher
     * ===== Key Business Rule =====
     * Before deleting a teacher, if the teacher has any teaching records,
     * all teaching records must be cleared first, and the instructor field
     * of the corresponding Course objects must be set to "TBD" to keep data consistent.
     *
     * @param scanner input scanner
     * @param teachers teacher list
     * @param courses  course list
     * @param people   person list (polymorphism)
     */
    private static void deleteTeacher(Scanner scanner,
                                      ArrayList<Teacher> teachers,
                                      ArrayList<Course> courses,
                                      ArrayList<Person> people) {
        // Check if there are teachers
        if (teachers.isEmpty()) {
            System.out.println("No teacher records.");
            return;
        }

        // 列出所有教师 / List all teachers
        System.out.println("\n--- Teacher List ---");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i + 1) + ". " + teachers.get(i).getName()
                    + " (" + teachers.get(i).getEmployeeId() + ")");
        }
        System.out.print("Select teacher number to delete: ");
        int teacherIndex = readInt(scanner) - 1;

        // Index validity check
        if (teacherIndex < 0 || teacherIndex >= teachers.size()) {
            System.out.println("Invalid teacher number.");
            return;
        }

        // Get the teacher object to delete
        Teacher teacher = teachers.get(teacherIndex);

        // Key step: before deletion, clear all the teacher's teaching records.
        // Call the Teacher class's removeAllTeachingCourses() method, which synchronously
        // updates the instructor field on the corresponding Course objects.
        System.out.println("\nClearing the teacher's teaching records...");
        teacher.removeAllTeachingCourses(courses);

        // Remove from the teacher list
        teachers.remove(teacherIndex);

        // Remove from the Person list (polymorphism list)
        people.remove(teacher);

        System.out.println("Teacher " + teacher.getName() + " has been deleted.");
    }

    /**
     * Drop a course
     * Removes the specified course from the student's enrolled courses,
     * and also unregisters on the course object.
     *
     * @param scanner input scanner
     * @param students student list
     * @param courses  course list
     */
    private static void dropCourse(Scanner scanner,
                                   ArrayList<Student> students,
                                   ArrayList<Course> courses) {
        // Check if there are students and courses
        if (students.isEmpty()) {
            System.out.println("No student records.");
            return;
        }
        if (courses.isEmpty()) {
            System.out.println("No course records.");
            return;
        }

        // List all students
        System.out.println("\n--- Student List ---");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName()
                    + " (" + students.get(i).getStudentId() + ")");
        }
        System.out.print("Select student number: ");
        int studentIndex = readInt(scanner) - 1;

        // Index validity check
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student number.");
            return;
        }

        Student student = students.get(studentIndex);

        // First display the student's enrolled courses for easy selection.
        student.displayEnrolledCourses();

        // List all courses for selection
        System.out.println("\n--- Course List ---");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName()
                    + " (" + courses.get(i).getCourseCode() + ")");
        }
        System.out.print("Select course number to drop: ");
        int courseIndex = readInt(scanner) - 1;

        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("Invalid course number.");
            return;
        }

        Course course = courses.get(courseIndex);

        // Call the student's drop method
        boolean success = student.dropCourse(course.getCourseName());
        // If drop is successful, unregister on the course object.
        if (success) {
            course.unregisterStudent();
        }
    }

    /**
     * Display all people
     * ===== Core Polymorphism Demonstration =====
     * Using a Person superclass reference to iterate, when displayRole()
     * is called, the subclass's overridden version is actually executed.
     * This is runtime polymorphism.
     */
    private static void displayAllPeople(ArrayList<Person> people) {
        System.out.println("\n===== All People Information =====");

        if (people.isEmpty()) {
            System.out.println("No people records.");
            return;
        }

        // Use a for-each loop to iterate the Person list.
        for (Person p : people) {
            System.out.println("\n------------------------------");
            // Calling methods overridden by subclasses — polymorphism!
            p.displayRole();
            p.showBasicInfo();
            System.out.println("Duty: " + p.getDuty());
        }
    }

    /**
     * Display all courses
     */
    private static void displayAllCourses(ArrayList<Course> courses) {
        System.out.println("\n===== All Courses Information =====");

        if (courses.isEmpty()) {
            System.out.println("No course records.");
            return;
        }

        for (int i = 0; i < courses.size(); i++) {
            System.out.println("\n--- Course #" + (i + 1) + " ---");
            courses.get(i).displayCourseInfo();
        }
    }

    /**
     * Display all students and their courses
     */
    private static void displayAllStudents(ArrayList<Student> students) {
        System.out.println("\n===== All Students & Enrolled Courses =====");

        if (students.isEmpty()) {
            System.out.println("No student records.");
            return;
        }

        for (Student s : students) {
            System.out.println("\n------------------------------");
            s.showBasicInfo();
            s.displayEnrolledCourses();
        }
    }

    /**
     * Polymorphism Demonstration
         * Emphasizes the polymorphism concept for easy explanation in the report.
     */
    private static void demonstratePolymorphism(ArrayList<Person> people) {
        System.out.println("\n===== Polymorphism Demonstration =====");
        System.out.println("Note: The following uses a Person superclass reference to call displayRole(),");
        System.out.println("      the actual executed version is the one overridden in each subclass.");
        System.out.println("      This is runtime polymorphism.");
        System.out.println("Note: Below uses Person superclass reference to call displayRole(),");
        System.out.println("      the actual executed version is the one overridden in each subclass.");
        System.out.println("      This is runtime polymorphism.\n");

        if (people.isEmpty()) {
            System.out.println("No people records, please add first.");
            return;
        }

        // Iterate the Person list, uniformly calling displayRole() — polymorphism.
        for (Person p : people) {
            // Superclass reference p, actual object may be Student or Teacher.
            System.out.print("[" + p.getName() + "] -> ");
            p.displayRole();   // Decided at runtime which version to call
        }
    }

    // ============================================================
    // Demo Data Loading
    // ============================================================

    /**
     * Load demo data
     * Pre-loads some students, teachers, and courses for easy testing.
     */
    private static void loadDemoData(ArrayList<Student> students,
                                     ArrayList<Teacher> teachers,
                                     ArrayList<Course> courses,
                                     ArrayList<Person> people) {
        // Create demo students
        Student s1 = new Student("Ethan", 20, "Male", "P001", "S2024001", "Computer Science");
        Student s2 = new Student("Felix", 21, "Female", "P002", "S2024002", " Software Engineering");
        s1.setGpa(3.8);
        s2.setGpa(3.5);

        // Create demo teachers
        Teacher t1 = new Teacher("Prof. Stewart", 45, "Male", "P003", "T2010", "Computer Science Dept");
        Teacher t2 = new Teacher("Prof. Bennett", 38, "Female", "P004", "T2011", "Mathematics Dept");

        // Create demo courses
        Course c1 = new Course("CS101", "Object-Oriented Programming", 4, "Prof. Stewart", 30);
        Course c2 = new Course("CS102", "Data Structures", 3, "Prof. Stewart", 25);
        Course c3 = new Course("MA101", "Calculus", 4, "Prof. Bennett", 40);

        // Students enroll in courses
        s1.enrollCourse(c1.getCourseName());
        c1.registerStudent();
        s1.enrollCourse(c2.getCourseName());
        c2.registerStudent();
        s2.enrollCourse(c1.getCourseName());
        c1.registerStudent();
        s2.enrollCourse(c3.getCourseName());
        c3.registerStudent();

        // Teachers add teaching courses
        t1.addTeachingCourse(c1.getCourseName());
        t1.addTeachingCourse(c2.getCourseName());
        t2.addTeachingCourse(c3.getCourseName());

        // Add to lists
        students.add(s1);
        students.add(s2);
        teachers.add(t1);
        teachers.add(t2);
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);

        // Add to Person list (polymorphism)
        people.add(s1);
        people.add(s2);
        people.add(t1);
        people.add(t2);

        System.out.println("Demo data loaded successfully.");
    }
}