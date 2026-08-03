package Assessment2;

/**
 * ============================================================
 * 文件名 / File Name: Teacher.java
 * 描述 / Description:
 *   Teacher 类同样继承自 Person，表示系统中的"教师"。
 *   The Teacher class also extends Person and represents a "teacher" in the system.
 *
 * 涵盖的 OOP 概念 / OOP Concepts Covered:
 *   1. 继承 (Inheritance) —— extends Person
 *   2. 多态 (Polymorphism) —— 重写 displayRole() 与 getDuty() (Rewrite displayRole() and getDuty())
 *   3. 封装 (Encapsulation) —— 私有属性 + getter/setter (Private Properties + Getter/Setter)
 *
 *   注意：Student 与 Teacher 都继承自 Person，但行为不同，
 *   这正是运行时多态的典型场景。
 *   Note: Both Student and Teacher extend Person but behave differently,
 *   which is a classic scenario of runtime polymorphism.
 * ============================================================
 */
import java.util.ArrayList;

public class Teacher extends Person {

    // ===== 私有属性 / Private Attributes =====
    private String employeeId;     // 教职工号 / Employee ID
    private String department;     // 所属院系 / Department
    private String[] teachingCourses;  // 教授课程列表 / List of courses taught
    private int courseCount;      // 教授课程数量 / Number of courses taught

    /**
     * 构造方法 / Constructor
     * 调用 super(...) 初始化父类属性，再初始化子类属性。
     * Calls super(...) to initialize parent attributes, then initializes subclass attributes.
     *
     * @param name        姓名 / name
     * @param age          年龄 / age
     * @param gender      性别 / gender
     * @param id          编号 / id
     * @param employeeId  教职工号 / employee ID
     * @param department  院系 / department
     */
    public Teacher(String name, int age, String gender, String id,
                   String employeeId, String department) {
        super(name, age, gender, id);   // 调用父类构造方法 / Call superclass constructor
        this.employeeId = employeeId;
        this.department = department;
        this.teachingCourses = new String[10];   // 假设每位教师最多教授 10 门课
        this.courseCount = 0;
    }

    // ===== Getter 和 Setter / Getters and Setters =====
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
     * 添加授课课程 / Add a teaching course
     *
     * @param courseName 课程名称 / course name
     */
    public void addTeachingCourse(String courseName) {
        if (courseCount < teachingCourses.length) {
            teachingCourses[courseCount] = courseName;
            courseCount++;
            System.out.println("教师 " + getName() + " 添加教授课程: " + courseName);
            System.out.println("Teacher " + getName() + " assigned course: " + courseName);
        } else {
            System.out.println("教学课程已满 / Teaching course limit reached.");
        }
    }

    /** 显示教授课程 / Display teaching courses */
    public void displayTeachingCourses() {
        System.out.println("\n--- " + getName() + " 教授的课程 / Teaching Courses ---");
        if (courseCount == 0) {
            System.out.println("暂无授课记录 / No teaching courses yet.");
        } else {
            // for-each 循环遍历数组 / for-each loop to iterate the array
            int index = 1;
            for (int i = 0; i < courseCount; i++) {
                System.out.println(index + ". " + teachingCourses[i]);
                index++;
            }
        }
    }

    /**
     * 取消授课 / Remove a teaching course
     * 从教授课程列表中移除指定课程。
     * Removes the specified course from the teaching courses list.
     * 使用数组元素前移的方式填补被删除元素的位置。
     * Uses array element shifting to fill the gap left by the removed element.
     *
     * @param courseName 课程名称 / course name
     * @return true 表示取消成功，false 表示未教授该课程
     *         true on success, false if the course was not being taught
     */
    public boolean removeTeachingCourse(String courseName) {
        // 遍历教授课程数组查找匹配项
        // Iterate the teaching courses array to find a match.
        for (int i = 0; i < courseCount; i++) {
            if (teachingCourses[i] != null && teachingCourses[i].equals(courseName)) {
                // 找到后，将后续元素前移以填补空缺
                // Once found, shift subsequent elements forward to fill the gap.
                for (int j = i; j < courseCount - 1; j++) {
                    teachingCourses[j] = teachingCourses[j + 1];
                }
                // 最后一位置空，数量减 1
                // Clear the last slot and decrement the count.
                teachingCourses[courseCount - 1] = null;
                courseCount--;
                System.out.println("教师 " + getName() + " 已取消授课: " + courseName);
                System.out.println("Teacher " + getName() + " removed course: " + courseName);
                return true;
            }
        }
        System.out.println("教师 " + getName() + " 未教授该课程: " + courseName);
        System.out.println("Teacher " + getName() + " does not teach: " + courseName);
        return false;
    }

    /**
     * 清除所有授课记录 / Remove all teaching courses
     * 用于删除教师前清理授课记录，同时把对应课程的 instructor 字段设为"待定"。
     * Used to clear teaching records before deleting the teacher,
     * and also set the instructor field of corresponding courses to "TBD".
     *
     * @param courses 系统中的所有课程列表 / all courses in the system
     */
    public void removeAllTeachingCourses(ArrayList<Course> courses) {
        // 遍历教授课程，逐个在对应 Course 对象上更新 instructor 字段
        // Iterate teaching courses and update the instructor field on each corresponding Course object.
        for (int i = 0; i < courseCount; i++) {
            String courseName = teachingCourses[i];
            // 在课程列表中找到对应 Course 对象并更新授课教师
            // Find the corresponding Course object in the list and update the instructor.
            for (Course c : courses) {
                if (c.getCourseName().equals(courseName)) {
                    c.setInstructor("待定 / TBD");
                    break;
                }
            }
        }
        // 清空教授课程数组 / Clear the teaching courses array
        for (int i = 0; i < courseCount; i++) {
            teachingCourses[i] = null;
        }
        courseCount = 0;
        System.out.println("教师 " + getName() + " 的所有授课记录已清除");
        System.out.println("All teaching records of teacher " + getName() + " have been cleared");
    }

    /**
     * 判断是否教授某门课 / Check whether a course is being taught
     *
     * @param courseName 课程名称 / course name
     * @return true 表示教授，false 表示未教授 / true if teaching, false otherwise
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
     * 重写 displayRole() / Override displayRole()
     * 与 Student 的实现不同，体现多态。
     * Different from Student's implementation, demonstrating polymorphism.
     */
    @Override
    public void displayRole() {
        System.out.println("角色 / Role: 教师 (Teacher)");
    }

    /**
     * 重写 getDuty() / Override getDuty()
     */
    @Override
    public String getDuty() {
        return "授课并指导学生学习 / Teach courses and guide students in learning";
    }

    /**
     * 重写 showBasicInfo() / Override showBasicInfo()
     */
    @Override
    public void showBasicInfo() {
        super.showBasicInfo();
        System.out.println("教职工号 / Employee ID : " + employeeId);
        System.out.println("院系 / Department     : " + department);
    }
}