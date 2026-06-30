public class lecturer extends employee{
    private String subject;

    public lecturer(String id, String name, String department, String subject){
        super(id, name, department);
        this.subject = subject;
    }

    public void displaySubject(){
        System.out.println("Subject     : " + subject);
        System.out.println("Department  : " + department);
    }
}