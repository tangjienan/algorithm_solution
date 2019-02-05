package DesignPattern.Decorator;

public class BlueGemDecorator implements IEquipDecorator{
    private Equip equip;

    public BlueGemDecorator(Equip equip)
    {
        this.equip = equip;
    }

    @Override
    public int calAttack()
    {
        return 5 + equip.calAttack();
    }

    @Override
    public String desc()
    {
        return equip.desc() + "+ blueGem";
    }

}
