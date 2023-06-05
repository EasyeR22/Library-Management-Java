package org.example;

import java.util.Scanner;

public class LibSubMain {
    Scanner scan = new Scanner(System.in);
    public void functions(){
        System.out.println("Who are you?\n1 - Borrower\n2 - Library worker");
        int choice = scan.nextInt();
        if(choice==1){
            Borrower borrower = new Borrower();
            borrower.functions();
        }
        else if(choice == 2){
            Librarian lbworker = new Librarian();
            lbworker.functions();
        }
    }
}
