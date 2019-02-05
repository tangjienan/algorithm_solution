package DesignPattern.Decorator;

public class WeaponImp implements Equip {

    @Override
    public int calAttack() {
        return 20;
    }

    @Override
    public String desc() {
        return "Sword";
    }
}
