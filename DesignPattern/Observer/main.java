package DesignPattern.Observer;

public class main {
    public static void main(String[] args) {
        System.out.println("Hey");
        Library library = new Library();
        Observer readerAObserver = new ReaderA();
        Observer readerBObserver = new ReaderB();

        library.addObserver(readerAObserver);
        library.addObserver(readerBObserver);
        Book book = new Book("tmpBook", "tmpAuthor");

        library.addBook(book);
    }
}
