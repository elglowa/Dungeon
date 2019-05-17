package pl.projekt.game.item;

import pl.projekt.game.mob.AbstractMonster;

public class Armor extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints=4;
    private double ArmourPoints=0;

    public Armor(){}

    public Armor(double damagePoints,double armourPoints,AbstractMonster mob1)
    {
        this.ArmourPoints=armourPoints;
        this.DamagePoints=damagePoints;
        this.Mob1=mob1;
    }

    @Override
    public void addAttack() {

    }

    @Override
    public void addHP() {
        Mob1.addHP(Mob1.getHealth()*0.04);
    }

    @Override
    public void addArmour() {
        Mob1.addArmour(Mob1.getDefence()*0.03);
    }
}
