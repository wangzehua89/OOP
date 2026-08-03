package Assessment2;

/**
 * ============================================================
 * File Name: Person.java
 * Description:
 *   This is an abstract class that serves as the base class for
 *   all "persons" in the system.
 *
 * OOP Concepts Covered:
 *   1. Classes and Objects —— The Person class is defined
 *   2. Encapsulation —— Properties are all marked as `private`
 *   3. Abstraction —— Uses the `abstract` keyword to declare abstract classes and abstract methods
 *   4. Inheritance —— Inherited by Student and Teacher as a superclass
 * ============================================================
 */
public abstract class Person {
    // ===== Private Attributes =====
    // Encapsulation principle: all attributes are private; external
    // access is only allowed through getter and setter methods.

    private String name;        // Name of the person
    private int age;            // Age of the person
    private String gender;      // Gender of the person
    private String id;          // Unique identifier of the person

    /**
     * Constructor
     * Used to initialize attributes when an object is created.
     *
     * @param name
     * @param age
     * @param gender
     * @param id
     */
    public Person(String name, int age, String gender, String id) {
        // Use the 'this' keyword to distinguish member variables from parameters.
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
    }

    // ===== Getter and Setter Methods =====
    // Through these methods, private attributes are accessed in a controlled way,
    // reflecting encapsulation.

    /** Get the name */
    public String getName() {
        return name;
    }

    /** Set the name */
    public void setName(String name) {
        this.name = name;
    }

    /** Get the age */
    public int getAge() {
        return age;
    }

    /**
     * Set the age
     * Includes simple validation: age must be greater than 0.
     */
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age: " + age);
        }
    }

    /** Get the gender */
    public String getGender() {
        return gender;
    }

    /** Set the gender */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /** Get the id */
    public String getId() {
        return id;
    }

    /** Set the id */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Abstract Method
     * An abstract method has only a declaration without implementation,
     * forcing subclasses to provide their own implementation.
     *
     * This method is used to display the role information of the person.
     */
    public abstract void displayRole();

    /**
     * Abstract Method
     * Returns the duty description of the person.
     *
     * @return  duty description string
     */
    public abstract String getDuty();

    /**
     * Concrete Method
     * Prints the basic information of the person.
     * Subclasses can inherit it directly or override it.
     */
    public void showBasicInfo() {
        System.out.println("ID      : " + id);
        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Gender  : " + gender);
    }
}