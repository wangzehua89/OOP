package Assessment2;

/**
 * ============================================================
 * 文件名 / File Name: Student.java
 * 描述 / Description:
 *   Student 类继承自 Person，表示系统中的"学生"。
 *   The Student class extends Person and represents a "student" in the system.
 *
 * 涵盖的 OOP 概念 / OOP Concepts Covered:
 *   1. 继承 (Inheritance) —— 使用 extends 关键字继承 Person (Use the `extends` keyword to inherit from `Person`)
 *   2. 多态 (Polymorphism) —— 重写 displayRole() 与 getDuty() 方法 (Override the displayRole() and getDuty() methods)
 *   3. 封装 (Encapsulation) —— 新增属性同样使用 private (New properties should also be declared as `private`.)
 *   4. 类与对象 (Classes and Objects) —— Student 是一个具体的类 (Student is a concrete class)
 * ============================================================
 */
import java.util.ArrayList;

public class Student extends Person {

    // ===== 私有属性 / Private Attributes =====
    private String studentId;     // 学号 / Student number (academic ID)
    private String major;         // 专业 / Major
    private double gpa;           // 平均绩点 / Grade Point Average
    private String[] enrolledCourses;  // 已选课程列表 / List of enrolled courses
    private int courseCount;      // 已选课程数量 / Number of enrolled courses

    /**
     * 构造方法 / Constructor
     * 先调用父类构造方法 super(...) 初始化继承来的属性，
     * 再初始化子类自身的新增属性。
     * First call the superclass constructor super(...) to initialize
     * inherited attributes, then initialize the subclass's own attributes.
     *
     * @param name       姓名 / name
     * @param age         年龄 / age
     * @param gender     性别 / gender
     * @param id         编号 / id
     * @param studentId 学号 / student number
     * @param major       专业 / major
     */
    public Student(String name, int age, String gender, String id,
                   String studentId, String major) {
        // 调用父类构造方法 / Call the superclass constructor
        super(name, age, gender, id);
        this.studentId = studentId;
        this.major = major;
        this.gpa = 0.0;   // 默认 GPA 为 0 / Default GPA is 0
        // 初始化课程数组，假设每个学生最多选 10 门课
        // Initialize the course array, assuming each student can take up to 10 courses.
        this.enrolledCourses = new String[10];
        this.courseCount = 0;
    }

    // ===== Getter 和 Setter / Getters and Setters =====
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
     * 设置 GPA / Set the GPA
     * 校验范围 0.0 ~ 4.0 / Validate range 0.0 ~ 4.0
     */
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("无效 GPA，应在 0.0~4.0 之间 / Invalid GPA, should be between 0.0 and 4.0");
        }
    }

    /**
     * 选课方法 / Enroll in a course
     * 检查课程数组是否已满，未满则添加课程名。
     * Checks if the course array is full; if not, adds the course name.
     *
     * @param courseName 课程名称 / course name
     */
    public void enrollCourse(String courseName) {
        // if 判断数组是否已满 / Use if to check whether the array is full
        if (courseCount < enrolledCourses.length) {
            enrolledCourses[courseCount] = courseName;
            courseCount++;
            System.out.println("学生 " + getName() + " 成功选课: " + courseName);
            System.out.println("Student " + getName() + " enrolled in: " + courseName);
        } else {
            System.out.println("选课已满，无法继续选课 / Course limit reached, cannot enroll more.");
        }
    }

    /**
     * 显示已选课程 / Display enrolled courses
     * 使用 for 循环遍历数组（体现基本 Java 控制结构）。
     * Uses a for loop to iterate the array (demonstrates basic Java control structures).
     */
    public void displayEnrolledCourses() {
        System.out.println("\n--- " + getName() + " 的已选课程 / Enrolled Courses ---");
        if (courseCount == 0) {
            System.out.println("暂无选课记录 / No enrolled courses yet.");
        } else {
            // for 循环遍历数组 / for loop to iterate the array
            for (int i = 0; i < courseCount; i++) {
                System.out.println((i + 1) + ". " + enrolledCourses[i]);
            }
        }
    }

    /**
     * 退课方法 / Drop a course
     * 从已选课程列表中移除指定课程。
     * Removes the specified course from the enrolled courses list.
     * 使用数组元素前移的方式填补被删除元素的位置。
     * Uses array element shifting to fill the gap left by the removed element.
     *
     * @param courseName 课程名称 / course name
     * @return true 表示退课成功，false 表示未选该课程
     *         true on success, false if the course was not enrolled
     */
    public boolean dropCourse(String courseName) {
        // 遍历已选课程数组查找匹配项
        // Iterate the enrolled courses array to find a match.
        for (int i = 0; i < courseCount; i++) {
            if (enrolledCourses[i] != null && enrolledCourses[i].equals(courseName)) {
                // 找到后，将后续元素前移以填补空缺
                // Once found, shift subsequent elements forward to fill the gap.
                for (int j = i; j < courseCount - 1; j++) {
                    enrolledCourses[j] = enrolledCourses[j + 1];
                }
                // 最后一位置空，数量减 1
                // Clear the last slot and decrement the count.
                enrolledCourses[courseCount - 1] = null;
                courseCount--;
                System.out.println("学生 " + getName() + " 已退课: " + courseName);
                System.out.println("Student " + getName() + " dropped course: " + courseName);
                return true;
            }
        }
        System.out.println("学生 " + getName() + " 未选该课程: " + courseName);
        System.out.println("Student " + getName() + " has not enrolled in: " + courseName);
        return false;
    }

    /**
     * 退掉所有已选课程 / Drop all enrolled courses
     * 用于删除学生前清理选课记录，同时同步更新对应 Course 对象的已选人数。
     * Used to clear enrollment records before deleting the student,
     * and also synchronously update the enrolled count on the corresponding Course objects.
     *
     * @param courses 系统中的所有课程列表 / all courses in the system
     */
    public void dropAllCourses(ArrayList<Course> courses) {
        // 遍历已选课程，逐个在对应 Course 对象上取消登记
        // Iterate enrolled courses and unregister on each corresponding Course object.
        for (int i = 0; i < courseCount; i++) {
            String courseName = enrolledCourses[i];
            // 在课程列表中找到对应 Course 对象并取消登记
            // Find the corresponding Course object in the list and unregister.
            for (Course c : courses) {
                if (c.getCourseName().equals(courseName)) {
                    c.unregisterStudent();
                    break;
                }
            }
        }
        // 清空已选课程数组 / Clear the enrolled courses array
        for (int i = 0; i < courseCount; i++) {
            enrolledCourses[i] = null;
        }
        courseCount = 0;
        System.out.println("学生 " + getName() + " 的所有选课记录已清除");
        System.out.println("All enrollment records of student " + getName() + " have been cleared");
    }

    /**
     * 判断是否已选某门课 / Check whether a course is enrolled
     *
     * @param courseName 课程名称 / course name
     * @return true 表示已选，false 表示未选 / true if enrolled, false otherwise
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
     * 重写父类的抽象方法 displayRole() / Override the abstract method displayRole()
     * 这是多态的体现：父类引用调用时，实际执行的是子类版本。
     * This demonstrates polymorphism: when called via a superclass reference,
     * the subclass version is actually executed.
     */
    @Override
    public void displayRole() {
        System.out.println("角色 / Role: 学生 (Student)");
    }

    /**
     * 重写父类的抽象方法 getDuty() / Override the abstract method getDuty()
     */
    @Override
    public String getDuty() {
        return "学习课程并完成学业 / Study courses and complete academic requirements";
    }

    /**
     * 重写父类的 showBasicInfo() / Override the superclass's showBasicInfo()
     * 在父类基础上追加学生特有信息。
     * Extends the parent version with student-specific information.
     */
    @Override
    public void showBasicInfo() {
        // 先调用父类版本打印基本信息 / First call the parent version
        super.showBasicInfo();
        // 再打印学生特有信息 / Then print student-specific info
        System.out.println("学号 / Student ID : " + studentId);
        System.out.println("专业 / Major      : " + major);
        System.out.println("GPA              : " + gpa);
    }
}