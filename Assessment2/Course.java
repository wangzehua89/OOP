package Assessment2;

/**
 * ============================================================
 * 文件名 / File Name: Course.java
 * 描述 / Description:
 *   Course 类表示系统中的"课程"，是与 Person/Student/Teacher
 *   相关的第三个核心类，满足"至少 3 个相关类"的要求。
 *   The Course class represents a "course" in the system. It is the
 *   third core class related to Person/Student/Teacher, satisfying
 *   the "at least 3 related classes" requirement.
 *
 * 涵盖的 OOP 概念 / OOP Concepts Covered:
 *   1. 类与对象 (Classes and Objects) —— Course 是一个独立的类 （Course It is a standalone class）
 *   2. 封装 (Encapsulation) —— 所有属性私有，通过 getter/setter 访问（All properties are private and accessed via getters and setters.）
 * ============================================================
 */
public class Course {

    // ===== 私有属性 / Private Attributes =====
    private String courseCode;     // 课程代码 / Course code
    private String courseName;     // 课程名称 / Course name
    private int creditHours;       // 学分 / Credit hours
    private String instructor;     // 授课教师姓名 / Instructor name
    private int maxCapacity;       // 最大容量 / Maximum capacity
    private int enrolledCount;     // 已选人数 / Number of enrolled students

    /**
     * 构造方法 / Constructor
     *
     * @param courseCode  课程代码 / course code
     * @param courseName  课程名称 / course name
     * @param creditHours 学分 / credit hours
     * @param instructor  授课教师 / instructor
     * @param maxCapacity  最大容量 / max capacity
     */
    public Course(String courseCode, String courseName, int creditHours,
                  String instructor, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.instructor = instructor;
        this.maxCapacity = maxCapacity;
        this.enrolledCount = 0;   // 初始已选人数为 0 / Initial enrolled count is 0
    }

    // ===== Getter 和 Setter / Getters and Setters =====
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
            System.out.println("无效学分 / Invalid credit hours: " + creditHours);
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
     * 学生选课登记 / Register a student enrollment
     * 每次调用使已选人数 +1，并检查容量。
     * Each call increments the enrolled count and checks capacity.
     *
     * @return true 表示成功，false 表示已满 / true on success, false if full
     */
    public boolean registerStudent() {
        if (enrolledCount < maxCapacity) {
            enrolledCount++;
            return true;
        } else {
            System.out.println("课程 " + courseName + " 已满员 / Course " + courseName + " is full.");
            return false;
        }
    }

    /**
     * 学生退课登记 / Unregister a student enrollment
     * 每次调用使已选人数 -1，并检查是否大于 0。
     * 用于学生退课或删除学生时同步更新课程已选人数。
     * Each call decrements the enrolled count and checks it is greater than 0.
     * Used when a student drops a course or is deleted to keep the course's
     * enrolled count in sync.
     *
     * @return true 表示成功，false 表示已为 0 / true on success, false if already 0
     */
    public boolean unregisterStudent() {
        if (enrolledCount > 0) {
            enrolledCount--;
            return true;
        } else {
            System.out.println("课程 " + courseName + " 当前已选人数为 0 / Course " + courseName + " has 0 enrolled students.");
            return false;
        }
    }

    /**
     * 显示课程信息 / Display course information
     * 使用格式化输出，体现"proper output formatting"。
     * Uses formatted output, reflecting "proper output formatting".
     */
    public void displayCourseInfo() {
        System.out.println("课程代码 / Course Code  : " + courseCode);
        System.out.println("课程名称 / Course Name  : " + courseName);
        System.out.println("学分 / Credit Hours     : " + creditHours);
        System.out.println("授课教师 / Instructor   : " + instructor);
        System.out.println("容量 / Capacity         : " + enrolledCount + "/" + maxCapacity);
    }
}