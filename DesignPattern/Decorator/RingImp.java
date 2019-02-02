package DesignPattern.Decorator;

public class RingImp implements Equip{
    @Override
    public int calAttack() {
        return 30;
    }

    @Override
    public String desc() {
        return "Ring";
    }
}
