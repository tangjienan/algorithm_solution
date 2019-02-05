package DesignPattern.Decorator;

public class main {
    public static void main(String[] args) {
        System.out.println("hey");
        Equip equip = new RedGemDecorator(new BlueGemDecorator(new WeaponImp()));
    }
}
