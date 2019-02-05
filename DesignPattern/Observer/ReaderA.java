package DesignPattern.Observer;

public class ReaderA implements Observer {
    @Override
    public void update(Object obj) {
        System.out.println("Read A receive " + obj.toString());
    }
}
