package org.example;

import java.util.ArrayList;
import java.util.Locale;

public class BookList {
    ArrayList<Book> bookList = new ArrayList<>();
    Book book1 = new Book("Harry Potter","Joanne Rowling");
    Book book2 = new Book("Fahrenheit 451","Ray Bradbury");
    Book book3 = new Book("1984","George Orwell");
    Book book4 = new Book("Thinking like rocket scientist","Ozan Varol");
    Book book5 = new Book("IT","Steven King");


    public void viewList(){
        for(int i = 0;i<bookList.size();i++){
            System.out.println(bookList.get(i).name + " " + bookList.get(i).author);
        }
    }
    public void addBooks(){
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
    }
    public void returnAddingBooks(){
        bookList.remove(bookList.get(0));
        bookList.remove(bookList.get(1));
        bookList.remove(bookList.get(2));
        bookList.remove(bookList.get(3));
        bookList.remove(bookList.get(4));
    }
    public void addBook(String name,String author){
        Book book6 = new Book(name,author);
        bookList.add(book6);
    }
    public void deleteByNumber(int number){
        addBooks();
        bookList.remove(bookList.get(number));
        viewList();
    }
}
