package DesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

public class Library extends Observable{
    private List<Book> bookList;

    public Library() {
        // TODO Auto-generated constructor stub
        this.bookList = new ArrayList<>();

        Book android = new Book("Android","Google");
        Book ios = new Book("iOS", "Apple");
        this.bookList.add(android);
        this.bookList.add(ios);
    }

    public void addBook(Book book) {
        this.bookList.add(book);
        super.notifyObservers(book);
    }

    public void delBook(Book book) {
        this.bookList.remove(book);
    }
}
