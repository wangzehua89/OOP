package Assessment2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ============================================================
 * 文件名 / File Name: StudentManagementSystem.java
 * 描述 / Description:
 *   这是系统的主类（入口类），负责：
 *   This is the main class (entry point) of the system, responsible for:
 *     1. 提供控制台菜单 / Providing a console menu
 *     2. 接收用户输入 / Receiving user input (Scanner)
 *     3. 使用控制结构处理业务 / Using control structures to handle logic
 *     4. 演示运行时多态 / Demonstrating runtime polymorphism
 *
 * 涵盖的 OOP 概念 / OOP Concepts Covered:
 *   1. 类与对象 (Classes and Objects) —— 创建 Student / Teacher / Course 对象 (Create Student, Teacher, and Course objects)
 *   2. 多态 (Polymorphism) —— 使用 Person 引用指向子类对象(Using a `Person` reference to point to an object of a subclass)
 *   3. 基本 Java 编程 (Basic Java) —— if / switch / while / for / Scanner
 *   4. 程序功能 (Program Functionality) —— 创建对象、显示信息、执行操作(Create an object, display information, and perform an operation)
 * ============================================================
 */
public class StudentManagementSystem {

    /**
     * 主方法 / Main method
     * 程序入口点 / The entry point of the program.
     *
     * @param args 命令行参数 / command-line arguments
     */
    public static void main(String[] args) {
        // 创建 Scanner 对象用于接收用户输入
        // Create a Scanner object to receive user input.
        Scanner scanner = new Scanner(System.in);

        // 使用 ArrayList 存储学生、教师、课程（动态数组，比原生数组更灵活）
        // Use ArrayList to store students, teachers, and courses
        // (dynamic array, more flexible than native arrays).
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();

        // 使用 Person 类型的 ArrayList 演示多态：可同时存放 Student 和 Teacher
        // Use a Person-typed ArrayList to demonstrate polymorphism:
        // it can hold both Student and Teacher objects.
        ArrayList<Person> people = new ArrayList<>();

        // 预置一些演示数据，方便直接测试
        // Pre-load some demo data for easy testing.
        loadDemoData(students, teachers, courses, people);

        // 主循环控制变量 / Main loop control variable
        boolean running = true;

        // ===== 主菜单循环 / Main Menu Loop =====
        // 使用 while 循环持续显示菜单，直到用户选择退出
        // Use a while loop to keep showing the menu until the user chooses to exit.
        while (running) {
            printMenu();                          // 打印菜单 / Print the menu
            System.out.print("请输入选项 / Enter your choice: ");

            // 读取用户输入的选项 / Read the user's choice
            int choice = readInt(scanner);

            // ===== switch 控制结构 / switch control structure =====
            // 根据用户输入执行不同分支
            // Execute different branches based on user input.
            switch (choice) {
                case 1:
                    // 添加学生 / Add a student
                    addStudent(scanner, students, people);
                    break;
                case 2:
                    // 添加教师 / Add a teacher
                    addTeacher(scanner, teachers, people);
                    break;
                case 3:
                    // 添加课程 / Add a course
                    addCourse(scanner, courses);
                    break;
                case 4:
                    // 学生选课 / Enroll a student in a course
                    enrollStudentInCourse(scanner, students, courses);
                    break;
                case 5:
                    // 删除学生 / Delete a student
                    deleteStudent(scanner, students, courses, people);
                    break;
                case 6:
                    // 删除教师 / Delete a teacher
                    deleteTeacher(scanner, teachers, courses, people);
                    break;
                case 7:
                    // 学生退课 / Drop a course
                    dropCourse(scanner, students, courses);
                    break;
                case 8:
                    // 显示所有人员信息（多态演示）/ Display all people (polymorphism demo)
                    displayAllPeople(people);
                    break;
                case 9:
                    // 显示所有课程 / Display all courses
                    displayAllCourses(courses);
                    break;
                case 10:
                    // 显示所有学生及选课 / Display all students and their courses
                    displayAllStudents(students);
                    break;
                case 11:
                    // 多态演示：展示每个人的职责 / Polymorphism demo: show each person's duty
                    demonstratePolymorphism(people);
                    break;
                case 0:
                    // 退出系统 / Exit the system
                    System.out.println("感谢使用学生管理系统，再见！");
                    System.out.println("Thank you for using the Student Management System. Goodbye!");
                    running = false;
                    break;
                default:
                    // 无效输入处理 / Handle invalid input
                    System.out.println("无效选项，请重新输入 / Invalid choice, please try again.");
            }
        }

        // 关闭 Scanner，释放资源 / Close the Scanner to release resources.
        scanner.close();
    }

    // ============================================================
    // 菜单打印方法 / Menu Printing Method
    // ============================================================
    /**
     * 打印主菜单 / Print the main menu
     * 体现"proper output formatting"。
     * Reflects "proper output formatting".
     */
    private static void printMenu() {
        System.out.println("\n========== 学生管理系统 / Student Management System ==========");
        System.out.println("1. 添加学生 / Add Student");
        System.out.println("2. 添加教师 / Add Teacher");
        System.out.println("3. 添加课程 / Add Course");
        System.out.println("4. 学生选课 / Enroll Student in Course");
        System.out.println("5. 删除学生 / Delete Student");
        System.out.println("6. 删除教师 / Delete Teacher");
        System.out.println("7. 学生退课 / Drop Course");
        System.out.println("8. 显示所有人员 / Display All People");
        System.out.println("9. 显示所有课程 / Display All Courses");
        System.out.println("10. 显示所有学生选课 / Display All Students");
        System.out.println("11. 多态演示 / Polymorphism Demo");
        System.out.println("0. 退出 / Exit");
        System.out.println("==============================================================");
    }

    // ============================================================
    // 工具方法 / Utility Methods
    // ============================================================

    /**
     * 安全读取整数 / Safely read an integer
     * 处理用户输入非数字时的异常情况。
     * Handles the case when the user inputs a non-numeric value.
     *
     * @param scanner Scanner 对象 / Scanner object
     * @return 用户输入的整数 / the integer entered by the user
     */
    private static int readInt(Scanner scanner) {
        // 使用 while 循环确保读到有效整数
        // Use a while loop to ensure a valid integer is read.
        while (!scanner.hasNextInt()) {
            System.out.print("请输入有效数字 / Please enter a valid number: ");
            scanner.next();   // 丢弃无效输入 / Discard invalid input
        }
        int value = scanner.nextInt();
        scanner.nextLine();   // 消耗换行符 / Consume the newline character
        return value;
    }

    /**
     * 安全读取 double / Safely read a double
     */
    private static double readDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("请输入有效数字 / Please enter a valid number: ");
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    // ============================================================
    // 业务方法 / Business Methods
    // ============================================================

    /**
     * 添加学生 / Add a student
     * 通过 Scanner 收集用户输入，创建 Student 对象。
     * Collects user input via Scanner and creates a Student object.
     */
    private static void addStudent(Scanner scanner,
                                  ArrayList<Student> students,
                                  ArrayList<Person> people) {
        System.out.println("\n--- 添加学生 / Add Student ---");

        System.out.print("姓名 / Name: ");
        String name = scanner.nextLine();

        System.out.print("年龄 / Age: ");
        int age = readInt(scanner);

        System.out.print("性别 / Gender: ");
        String gender = scanner.nextLine();

        System.out.print("系统编号 / System ID: ");
        String id = scanner.nextLine();

        System.out.print("学号 / Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("专业 / Major: ");
        String major = scanner.nextLine();

        // 创建 Student 对象 / Create a Student object
        Student student = new Student(name, age, gender, id, studentId, major);

        // 添加到学生列表 / Add to the student list
        students.add(student);
        // 同时添加到 Person 列表（多态：子类对象赋给父类引用）
        // Also add to the Person list (polymorphism: subclass object assigned to superclass reference)
        people.add(student);

        System.out.println("学生添加成功 / Student added successfully!");
    }

    /**
     * 添加教师 / Add a teacher
     */
    private static void addTeacher(Scanner scanner,
                                  ArrayList<Teacher> teachers,
                                  ArrayList<Person> people) {
        System.out.println("\n--- 添加教师 / Add Teacher ---");

        System.out.print("姓名 / Name: ");
        String name = scanner.nextLine();

        System.out.print("年龄 / Age: ");
        int age = readInt(scanner);

        System.out.print("性别 / Gender: ");
        String gender = scanner.nextLine();

        System.out.print("系统编号 / System ID: ");
        String id = scanner.nextLine();

        System.out.print("教职工号 / Employee ID: ");
        String employeeId = scanner.nextLine();

        System.out.print("院系 / Department: ");
        String department = scanner.nextLine();

        // 创建 Teacher 对象 / Create a Teacher object
        Teacher teacher = new Teacher(name, age, gender, id, employeeId, department);

        teachers.add(teacher);
        people.add(teacher);   // 多态：Teacher 也是 Person / Polymorphism: Teacher is also a Person

        System.out.println("教师添加成功 / Teacher added successfully!");
    }

    /**
     * 添加课程 / Add a course
     */
    private static void addCourse(Scanner scanner, ArrayList<Course> courses) {
        System.out.println("\n--- 添加课程 / Add Course ---");

        System.out.print("课程代码 / Course Code: ");
        String code = scanner.nextLine();

        System.out.print("课程名称 / Course Name: ");
        String name = scanner.nextLine();

        System.out.print("学分 / Credit Hours: ");
        int credit = readInt(scanner);

        System.out.print("授课教师 / Instructor: ");
        String instructor = scanner.nextLine();

        System.out.print("最大容量 / Max Capacity: ");
        int capacity = readInt(scanner);

        // 创建 Course 对象 / Create a Course object
        Course course = new Course(code, name, credit, instructor, capacity);
        courses.add(course);

        System.out.println("课程添加成功 / Course added successfully!");
    }

    /**
     * 学生选课 / Enroll a student in a course
     * 使用 if 判断索引合法性，使用 for 循环列出可选项。
     * Uses if to validate index, uses for to list options.
     */
    private static void enrollStudentInCourse(Scanner scanner,
                                              ArrayList<Student> students,
                                              ArrayList<Course> courses) {
        // 检查是否有学生和课程 / Check if there are students and courses
        if (students.isEmpty()) {
            System.out.println("暂无学生，请先添加学生 / No students, please add a student first.");
            return;
        }
        if (courses.isEmpty()) {
            System.out.println("暂无课程，请先添加课程 / No courses, please add a course first.");
            return;
        }

        // 列出所有学生 / List all students
        System.out.println("\n--- 学生列表 / Student List ---");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName()
                    + " (" + students.get(i).getStudentId() + ")");
        }
        System.out.print("选择学生编号 / Select student number: ");
        int studentIndex = readInt(scanner) - 1;

        // 索引合法性检查 / Index validity check
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("无效的学生编号 / Invalid student number.");
            return;
        }

        // 列出所有课程 / List all courses
        System.out.println("\n--- 课程列表 / Course List ---");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName()
                    + " (" + courses.get(i).getCourseCode() + ")");
        }
        System.out.print("选择课程编号 / Select course number: ");
        int courseIndex = readInt(scanner) - 1;

        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("无效的课程编号 / Invalid course number.");
            return;
        }

        // 获取学生与课程对象 / Get student and course objects
        Student student = students.get(studentIndex);
        Course course = courses.get(courseIndex);

        // 调用学生选课方法 / Call the student's enroll method
        student.enrollCourse(course.getCourseName());
        // 同时在课程对象上登记 / Also register on the course object
        course.registerStudent();
    }

    /**
     * 删除学生 / Delete a student
     * ===== 关键业务规则 / Key Business Rule =====
     * 删除学生前，如果该学生有选课记录，必须先清除所有选课，
     * 同时在对应 Course 对象上取消登记，保证数据一致性。
     * Before deleting a student, if the student has any enrolled courses,
     * all enrollments must be cleared first, and the corresponding Course
     * objects must be unregistered to keep data consistent.
     *
     * @param scanner 输入扫描器 / input scanner
     * @param students 学生列表 / student list
     * @param courses  课程列表 / course list
     * @param people   人员列表（多态）/ person list (polymorphism)
     */
    private static void deleteStudent(Scanner scanner,
                                      ArrayList<Student> students,
                                      ArrayList<Course> courses,
                                      ArrayList<Person> people) {
        // 检查是否有学生 / Check if there are students
        if (students.isEmpty()) {
            System.out.println("暂无学生记录 / No student records.");
            return;
        }

        // 列出所有学生 / List all students
        System.out.println("\n--- 学生列表 / Student List ---");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName()
                    + " (" + students.get(i).getStudentId() + ")");
        }
        System.out.print("选择要删除的学生编号 / Select student number to delete: ");
        int studentIndex = readInt(scanner) - 1;

        // 索引合法性检查 / Index validity check
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("无效的学生编号 / Invalid student number.");
            return;
        }

        // 获取要删除的学生对象 / Get the student object to delete
        Student student = students.get(studentIndex);

        // ===== 关键步骤：删除前先清除该学生的所有选课记录 =====
        // Key step: before deletion, clear all the student's enrollment records.
        // 调用 Student 类的 dropAllCourses() 方法，它会同步更新对应 Course 对象的已选人数
        // Call the Student class's dropAllCourses() method, which synchronously
        // updates the enrolled count on the corresponding Course objects.
        System.out.println("\n正在清除该学生的选课记录 / Clearing the student's enrollment records...");
        student.dropAllCourses(courses);

        // 从学生列表中移除 / Remove from the student list
        students.remove(studentIndex);

        // 从 Person 列表中移除（多态列表）/ Remove from the Person list (polymorphism list)
        people.remove(student);

        System.out.println("学生 " + student.getName() + " 已删除 / Student " + student.getName() + " has been deleted.");
    }

    /**
     * 删除教师 / Delete a teacher
     * ===== 关键业务规则 / Key Business Rule =====
     * 删除教师前，如果该教师有授课记录，必须先清除所有授课记录，
     * 同时把对应 Course 对象的 instructor 字段设为"待定"，保证数据一致性。
     * Before deleting a teacher, if the teacher has any teaching records,
     * all teaching records must be cleared first, and the instructor field
     * of the corresponding Course objects must be set to "TBD" to keep data consistent.
     *
     * @param scanner 输入扫描器 / input scanner
     * @param teachers 教师列表 / teacher list
     * @param courses  课程列表 / course list
     * @param people   人员列表（多态）/ person list (polymorphism)
     */
    private static void deleteTeacher(Scanner scanner,
                                      ArrayList<Teacher> teachers,
                                      ArrayList<Course> courses,
                                      ArrayList<Person> people) {
        // 检查是否有教师 / Check if there are teachers
        if (teachers.isEmpty()) {
            System.out.println("暂无教师记录 / No teacher records.");
            return;
        }

        // 列出所有教师 / List all teachers
        System.out.println("\n--- 教师列表 / Teacher List ---");
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i + 1) + ". " + teachers.get(i).getName()
                    + " (" + teachers.get(i).getEmployeeId() + ")");
        }
        System.out.print("选择要删除的教师编号 / Select teacher number to delete: ");
        int teacherIndex = readInt(scanner) - 1;

        // 索引合法性检查 / Index validity check
        if (teacherIndex < 0 || teacherIndex >= teachers.size()) {
            System.out.println("无效的教师编号 / Invalid teacher number.");
            return;
        }

        // 获取要删除的教师对象 / Get the teacher object to delete
        Teacher teacher = teachers.get(teacherIndex);

        // ===== 关键步骤：删除前先清除该教师的所有授课记录 =====
        // Key step: before deletion, clear all the teacher's teaching records.
        // 调用 Teacher 类的 removeAllTeachingCourses() 方法，它会同步更新对应 Course 对象的 instructor 字段
        // Call the Teacher class's removeAllTeachingCourses() method, which synchronously
        // updates the instructor field on the corresponding Course objects.
        System.out.println("\n正在清除该教师的授课记录 / Clearing the teacher's teaching records...");
        teacher.removeAllTeachingCourses(courses);

        // 从教师列表中移除 / Remove from the teacher list
        teachers.remove(teacherIndex);

        // 从 Person 列表中移除（多态列表）/ Remove from the Person list (polymorphism list)
        people.remove(teacher);

        System.out.println("教师 " + teacher.getName() + " 已删除 / Teacher " + teacher.getName() + " has been deleted.");
    }

    /**
     * 学生退课 / Drop a course
     * 从学生的已选课程中移除指定课程，同时在课程对象上取消登记。
     * Removes the specified course from the student's enrolled courses,
     * and also unregisters on the course object.
     *
     * @param scanner 输入扫描器 / input scanner
     * @param students 学生列表 / student list
     * @param courses  课程列表 / course list
     */
    private static void dropCourse(Scanner scanner,
                                   ArrayList<Student> students,
                                   ArrayList<Course> courses) {
        // 检查是否有学生和课程 / Check if there are students and courses
        if (students.isEmpty()) {
            System.out.println("暂无学生记录 / No student records.");
            return;
        }
        if (courses.isEmpty()) {
            System.out.println("暂无课程记录 / No course records.");
            return;
        }

        // 列出所有学生 / List all students
        System.out.println("\n--- 学生列表 / Student List ---");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName()
                    + " (" + students.get(i).getStudentId() + ")");
        }
        System.out.print("选择学生编号 / Select student number: ");
        int studentIndex = readInt(scanner) - 1;

        // 索引合法性检查 / Index validity check
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("无效的学生编号 / Invalid student number.");
            return;
        }

        Student student = students.get(studentIndex);

        // 先显示该学生已选课程，便于用户选择
        // First display the student's enrolled courses for easy selection.
        student.displayEnrolledCourses();

        // 列出所有课程供选择 / List all courses for selection
        System.out.println("\n--- 课程列表 / Course List ---");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseName()
                    + " (" + courses.get(i).getCourseCode() + ")");
        }
        System.out.print("选择要退的课程编号 / Select course number to drop: ");
        int courseIndex = readInt(scanner) - 1;

        if (courseIndex < 0 || courseIndex >= courses.size()) {
            System.out.println("无效的课程编号 / Invalid course number.");
            return;
        }

        Course course = courses.get(courseIndex);

        // 调用学生退课方法 / Call the student's drop method
        boolean success = student.dropCourse(course.getCourseName());
        // 如果退课成功，在课程对象上取消登记
        // If drop is successful, unregister on the course object.
        if (success) {
            course.unregisterStudent();
        }
    }

    /**
     * 显示所有人员 / Display all people
     * ===== 多态核心演示 / Core Polymorphism Demonstration =====
     * 使用 Person 父类引用遍历，调用 displayRole() 时
     * 实际执行的是子类重写后的版本，这就是运行时多态。
     * Using a Person superclass reference to iterate, when displayRole()
     * is called, the subclass's overridden version is actually executed.
     * This is runtime polymorphism.
     */
    private static void displayAllPeople(ArrayList<Person> people) {
        System.out.println("\n===== 所有人员信息 / All People Information =====");

        if (people.isEmpty()) {
            System.out.println("暂无人员记录 / No people records.");
            return;
        }

        // 使用 for-each 循环遍历 Person 列表
        // Use a for-each loop to iterate the Person list.
        for (Person p : people) {
            System.out.println("\n------------------------------");
            // 调用被子类重写的方法 —— 多态！
            // Calling methods overridden by subclasses — polymorphism!
            p.displayRole();
            p.showBasicInfo();
            System.out.println("职责 / Duty: " + p.getDuty());
        }
    }

    /**
     * 显示所有课程 / Display all courses
     */
    private static void displayAllCourses(ArrayList<Course> courses) {
        System.out.println("\n===== 所有课程信息 / All Courses Information =====");

        if (courses.isEmpty()) {
            System.out.println("暂无课程记录 / No course records.");
            return;
        }

        for (int i = 0; i < courses.size(); i++) {
            System.out.println("\n--- 课程 #" + (i + 1) + " / Course #" + (i + 1) + " ---");
            courses.get(i).displayCourseInfo();
        }
    }

    /**
     * 显示所有学生及选课 / Display all students and their courses
     */
    private static void displayAllStudents(ArrayList<Student> students) {
        System.out.println("\n===== 所有学生及选课 / All Students & Enrolled Courses =====");

        if (students.isEmpty()) {
            System.out.println("暂无学生记录 / No student records.");
            return;
        }

        for (Student s : students) {
            System.out.println("\n------------------------------");
            s.showBasicInfo();
            s.displayEnrolledCourses();
        }
    }

    /**
     * 多态演示 / Polymorphism Demonstration
     * 单独强调多态概念，便于在报告中说明。
     * Emphasizes the polymorphism concept for easy explanation in the report.
     */
    private static void demonstratePolymorphism(ArrayList<Person> people) {
        System.out.println("\n===== 多态演示 / Polymorphism Demonstration =====");
        System.out.println("说明：以下使用 Person 父类引用调用 displayRole()，");
        System.out.println("      实际执行的是各子类重写后的版本，这就是运行时多态。");
        System.out.println("Note: Below uses Person superclass reference to call displayRole(),");
        System.out.println("      the actual executed version is the one overridden in each subclass.");
        System.out.println("      This is runtime polymorphism.\n");

        if (people.isEmpty()) {
            System.out.println("暂无人员记录，请先添加 / No people records, please add first.");
            return;
        }

        // 遍历 Person 列表，统一调用 displayRole() —— 多态
        // Iterate the Person list, uniformly calling displayRole() — polymorphism.
        for (Person p : people) {
            // 父类引用 p，实际对象可能是 Student 或 Teacher
            // Superclass reference p, actual object may be Student or Teacher.
            System.out.print("[" + p.getName() + "] -> ");
            p.displayRole();   // 运行时决定调用哪个版本 / Decided at runtime which version to call
        }
    }

    // ============================================================
    // 演示数据加载 / Demo Data Loading
    // ============================================================

    /**
     * 加载演示数据 / Load demo data
     * 预置一些学生、教师、课程，方便用户直接测试系统功能。
     * Pre-loads some students, teachers, and courses for easy testing.
     */
    private static void loadDemoData(ArrayList<Student> students,
                                     ArrayList<Teacher> teachers,
                                     ArrayList<Course> courses,
                                     ArrayList<Person> people) {
        // 创建演示学生 / Create demo students
        Student s1 = new Student("伊森 / Ethan", 20, "男 / Male", "P001", "S2024001", "计算机科学 / Computer Science");
        Student s2 = new Student("菲利克斯 / Felix", 21, "女 / Female", "P002", "S2024002", "软件工程 / Software Engineering");
        s1.setGpa(3.8);
        s2.setGpa(3.5);

        // 创建演示教师 / Create demo teachers
        Teacher t1 = new Teacher("Prof. Stewart", 45, "男 / Male", "P003", "T2010", "计算机系 / CS Dept");
        Teacher t2 = new Teacher("Prof. Bennett", 38, "女 / Female", "P004", "T2011", "数学系 / Math Dept");

        // 创建演示课程 / Create demo courses
        Course c1 = new Course("CS101", "面向对象程序设计 / OOP Programming", 4, "Prof. Stewart", 30);
        Course c2 = new Course("CS102", "数据结构 / Data Structures", 3, "Prof. Stewart", 25);
        Course c3 = new Course("MA101", "高等数学 / Calculus", 4, "Prof. Bennett", 40);

        // 学生选课 / Students enroll in courses
        s1.enrollCourse(c1.getCourseName());
        c1.registerStudent();
        s1.enrollCourse(c2.getCourseName());
        c2.registerStudent();
        s2.enrollCourse(c1.getCourseName());
        c1.registerStudent();
        s2.enrollCourse(c3.getCourseName());
        c3.registerStudent();

        // 教师添加授课课程 / Teachers add teaching courses
        t1.addTeachingCourse(c1.getCourseName());
        t1.addTeachingCourse(c2.getCourseName());
        t2.addTeachingCourse(c3.getCourseName());

        // 添加到列表 / Add to lists
        students.add(s1);
        students.add(s2);
        teachers.add(t1);
        teachers.add(t2);
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);

        // 添加到 Person 列表（多态）/ Add to Person list (polymorphism)
        people.add(s1);
        people.add(s2);
        people.add(t1);
        people.add(t2);

        System.out.println("演示数据已加载 / Demo data loaded successfully.");
    }
}