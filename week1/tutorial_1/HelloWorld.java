package week1.tutorial_1;

public class HelloWorld {
        public static void main(String[] args){
        String studentName = "Wang Zehua";
        String studentID = "202605010250";
        int t = 9;
        holle that = new holle();
        that.printhello(studentName,studentID,t);
    }
    public void printhello(String studentName,String studentID,int t){
        for(int i =0;i<10;i++){
            if(i==t){
                System.out.println("No."+i+" "+"Hello World my name is "+studentName+", my student ID is "+studentID);
            }
        }
    }
}
