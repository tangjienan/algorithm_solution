package DesignPattern.Observer;

public class ReaderB implements Observer {
    @Override
    public void update(Object obj) {
        System.out.println("Read B receive " + obj.toString());
    }
}
