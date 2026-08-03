package Assessment2;

/**
 * ============================================================
 * 文件名 / File Name: Person.java
 * 描述 / Description:
 *   这是一个抽象类，作为系统中所有"人"的基类。
 *   This is an abstract class that serves as the base class for
 *   all "persons" in the system.
 *
 * 涵盖的 OOP 概念 / OOP Concepts Covered:
 *   1. 类与对象 (Classes and Objects) —— 定义了 Person 类 (The Person class is defined)
 *   2. 封装 (Encapsulation) —— 属性全部使用 private 修饰 (All properties are marked as `private`)
 *   3. 抽象 (Abstraction) —— 使用 abstract 关键字声明抽象类与抽象方法 (Use the `abstract` keyword to declare abstract classes and abstract methods)
 *   4. 继承 (Inheritance) —— 作为父类被 Student / Teacher 继承(Inherited by Student and Teacher as a superclass)
 * ============================================================
 */
public abstract class Person {
    // ===== 私有属性 / Private Attributes =====
    // 封装原则：所有属性都设为 private，外部只能通过 getter/setter 访问
    // Encapsulation principle: all attributes are private; external
    // access is only allowed through getter and setter methods.

    private String name;        // 姓名 / Name of the person
    private int age;            // 年龄 / Age of the person
    private String gender;     // 性别 / Gender of the person
    private String id;          // 唯一编号 / Unique identifier of the person

    /**
     * 构造方法 / Constructor
     * 用于在创建对象时初始化属性。
     * Used to initialize attributes when an object is created.
     *
     * @param name   姓名 / name
     * @param age     年龄 / age
     * @param gender 性别 / gender
     * @param id     编号 / id
     */
    public Person(String name, int age, String gender, String id) {
        // 使用 this 关键字区分成员变量与参数
        // Use the 'this' keyword to distinguish member variables from parameters.
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
    }

    // ===== Getter 和 Setter 方法 / Getter and Setter Methods =====
    // 通过这些方法受控地访问私有属性，体现封装
    // Through these methods, private attributes are accessed in a controlled way,
    // reflecting encapsulation.

    /** 获取姓名 / Get the name */
    public String getName() {
        return name;
    }

    /** 设置姓名 / Set the name */
    public void setName(String name) {
        this.name = name;
    }

    /** 获取年龄 / Get the age */
    public int getAge() {
        return age;
    }

    /**
     * 设置年龄 / Set the age
     * 包含简单校验：年龄必须大于 0
     * Includes simple validation: age must be greater than 0.
     */
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("无效年龄 / Invalid age: " + age);
        }
    }

    /** 获取性别 / Get the gender */
    public String getGender() {
        return gender;
    }

    /** 设置性别 / Set the gender */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /** 获取编号 / Get the id */
    public String getId() {
        return id;
    }

    /** 设置编号 / Set the id */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 抽象方法 / Abstract Method
     * 抽象方法只有声明，没有实现，强制子类必须重写。
     * An abstract method has only a declaration without implementation,
     * forcing subclasses to provide their own implementation.
     *
     * 该方法用于展示该"人"的角色信息。
     * This method is used to display the role information of the person.
     */
    public abstract void displayRole();

    /**
     * 抽象方法 / Abstract Method
     * 返回该"人"的职责描述。
     * Returns the duty description of the person.
     *
     * @return 职责描述字符串 / duty description string
     */
    public abstract String getDuty();

    /**
     * 普通方法 / Concrete Method
     * 打印该"人"的基本信息。
     * Prints the basic information of the person.
     * 子类可以直接继承使用，也可以重写。
     * Subclasses can inherit it directly or override it.
     */
    public void showBasicInfo() {
        System.out.println("编号 / ID      : " + id);
        System.out.println("姓名 / Name    : " + name);
        System.out.println("年龄 / Age     : " + age);
        System.out.println("性别 / Gender  : " + gender);
    }
}