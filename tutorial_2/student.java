public class student {
    private String name;
    private int age;
    private double apa;
    
   public student(String studentName, int studentAge, double studentApa) {
        name = studentName;
        age = studentAge;
        apa = studentApa;
    }
    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("APA: " + apa);
    }
    public void study(){
        System.out.println(name + " is studying.");
    }
    public void takeExam(){
        System.out.println(name + " is taking an exam.");
    }
}