package DesignPattern.Observer;

public class Book {

    public String bookName;

    public String author;

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [bookName=" + bookName + ", author=" + author + "]";
    }
}
