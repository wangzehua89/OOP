public class main {
    public static void main(String[] args) {
 
        Student stu = new Student();
        stu.setStudentID("CU12345");
        stu.setName("Ali");
        stu.setCGPA(3.75);
        stu.setProgramme("BIT");

        System.out.println("Student ID : " + stu.getStudentID());
        System.out.println("Name       : " + stu.getName());
        System.out.println("CGPA       : " + stu.getCGPA());
        System.out.println("Programme  : " + stu.getProgramme());
    }
}