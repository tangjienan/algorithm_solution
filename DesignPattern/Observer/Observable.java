package DesignPattern.Observer;

import java.util.Vector;

public abstract class Observable {
    private Vector<Observer> obVector = new Vector<>();

    public void addObserver(Observer observer) {
        this.obVector.add(observer);
    }

    public void delObserver(Observer observer) {
        this.obVector.remove(observer);
    }

    public void notifyObservers(Book book) {
        for (Observer observer : obVector) {
            observer.update(book);
        }
    }
}
