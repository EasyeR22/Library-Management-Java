package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teacher extends Student{
    @Override
    public void borrowBook() {
        bkList.addBooks();
        System.out.println("Enter your name:");
        String s = scan.next();
        System.out.println("Enter the date you get this book");
        String dtt = scan.next();
        String dt = dtt.replace('/','.');
        try {
            SimpleDateFormat sdf= new SimpleDateFormat("dd.MM.yyyy");
            Date d = sdf.parse(dt);
            dt1 = d;
        } catch (ParseException ex) {
            ex.printStackTrace();
        }date1 = dt1.getDate();
        month1 = dt1.getMonth()+1;
        year1 = dt1.getYear()+1900;

        System.out.println("How many books do you want to borrow?");

        int amount = scan.nextInt();
        if(amount>3){
            System.out.println("You cannot borrow more than 3 books");
        }
        bkList.viewList();
        System.out.println("Enter the books you want:");
        for(int i = 0;i<amount;i++){
            System.out.println("What is the " + i+1 + " book?");
            int choice = scan.nextInt();
            borrowedBookList.add(bkList.bookList.get(choice));
            bkList.deleteByNumber(choice-1);
            borrowerList.add(s);
        }
        System.out.println("You got:");
        for (Book book : borrowedBookList) {
            System.out.println(book.name + " " + book.author);
        }
    }
    @Override
    public void returnBook() {
        System.out.println("Enter your name:");
        String s = scan.next();
        if(!(borrowerList.contains(s))){
            System.out.println("You can't return any book");
            return;
        }
        if(borrowedBookList.isEmpty()){
            System.out.println("You can't return any book");
            return;
        }
        //saving the date
        System.out.println("Enter the date");
        String currentDate1 = scan.next();
        String currentDate = currentDate1.replace('/','.');
        try {
            SimpleDateFormat sdf= new SimpleDateFormat("dd.MM.yyyy");
            Date d = sdf.parse(currentDate);
            dt2 = d;
        } catch (ParseException ex) {
            ex.printStackTrace();
        }date2 = dt2.getDate();
        month2 = dt2.getMonth()+1;
        year2 = dt2.getYear()+1900;
        //checking deadline
        if(month2 - month1 <= 1 || month2 - month1 == -11){
            if((30-date1)+date2 <=30){
                System.out.println("Your deadline is okay!");
            }else{
                System.out.println("You missed the deadline, hence, you can't borrow books");
            }
        }else{
            System.out.println("You missed the deadline, hence, you can't borrow books");
        }
        //borrowing
        System.out.println("Your books are borrowed");
        for(int i = 0;i<borrowedBookList.size();i++){
            bkList.addBook(borrowedBookList.get(i).name,borrowedBookList.get(i).author);
            borrowedBookList.remove(borrowedBookList.get(i));
            borrowerList.remove(s);
        }
    }
    public void showBookList(){
        bkList.viewList();
    }
    public void teacherFunctions() {
        System.out.println("What do you want?");
        int choice = 0;
        while(choice !=4) {
            System.out.println("1 - Borrow book\n2 - Return book\n3 - Show book list\n4 - Exit");
            choice = scan.nextInt();
            if (choice == 1) {
                borrowBook();
                continue;
            } else if (choice == 2) {
                returnBook();
                continue;
            } else if (choice == 3) {
                bkList.returnAddingBooks();
                bkList.viewList();
                continue;
            }
        }
    }
}
