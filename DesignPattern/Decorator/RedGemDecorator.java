package DesignPattern.Decorator;

public class RedGemDecorator implements IEquipDecorator{
    private Equip equip;

    public RedGemDecorator(Equip equip)
    {
        this.equip = equip;
    }

    @Override
    public int calAttack()
    {
        return 10 + equip.calAttack();
    }

    @Override
    public String desc()
    {
        return equip.desc() + "+ redGem";
    }

}
