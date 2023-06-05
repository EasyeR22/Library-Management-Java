package org.example;

import java.util.Scanner;

public class Borrower extends Teacher{
    Scanner scan = new Scanner(System.in);
    public void functions(){
        System.out.println("Who are you?\n1 - Student\n2 - Teacher");
        int choice = scan.nextInt();
        if(choice==1){
            Student student = new Student();
            student.studentFunctions();
        }
        else if(choice == 2){
            Teacher teacher = new Teacher();
            teacher.teacherFunctions();
        }
    }
}
