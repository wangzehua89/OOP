package week1.tutorial_1;

import java.util.Scanner;
public class studentGrade{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
         System.out.println("Enter Name:");
         String studentName = scanner.nextLine();
         System.out.println("Enter Student ID:");
         String studentID = scanner.nextLine();
         System.out.println("Coding Marks:");
         double CodingMarks = scanner.nextDouble();
         String grade;
         if(CodingMarks > 80){
            grade = "PASS";
         }else{
            grade = "NO PASS";
         }
         System.out.println("Hello "+studentName+" & "+studentID);
         System.out.println("CodingMarks is "+grade);
         scanner.close();
    }
}