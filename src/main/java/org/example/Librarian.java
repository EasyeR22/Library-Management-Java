package org.example;

import java.util.Scanner;

public class Librarian {
    Scanner scan = new Scanner(System.in);
    BookList bklist = new BookList();


    public void viewBookList(){
        bklist.addBooks();
        System.out.println("There are our books:");
        bklist.viewList();
    }
    public void addBook(){
        bklist.addBooks();
        String name;
        String author;
        System.out.println("Enter the name of book:");
        name=scan.next();
        System.out.println("Enter the author of book:");
        author=scan.next();
        bklist.addBook(name,author);
        viewBookList();
    }
    public void deleteBookByNumber(){
        int number;
        System.out.println("Enter the number of book");
        number=scan.nextInt();
        bklist.deleteByNumber(number);
    }
    public void viewBorrowerList(){
        Borrower borr = new Borrower();
        for(int i = 0;i<borr.borrowerList.size();i++){
            System.out.println(borr.borrowerList.get(i));
        }
    }
    public void functions(){
        int choice = 0;
        while(choice != 4) {
            System.out.println("Enter the number\n1 - View book list\n2 - Add book to list\n3 - delete book by number\n4 - View borrower list\n5 - Exit");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    viewBookList();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    deleteBookByNumber();
                    break;
                case 4:
                    viewBorrowerList();
                    break;
                default:
                    return;
            }
        }
    }
}
