public class employee {
    protected String id;
    protected String name;
    protected String department;

    public employee(String id, String name, String department){
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public void displayInfo(){
        System.out.println("Employee ID : " + id);
        System.out.println("Name        : " + name);
    }
}