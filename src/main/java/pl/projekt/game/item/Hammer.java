package pl.projekt.game.item;

import pl.projekt.game.mob.AbstractMonster;

public class Hammer extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints=1;
    private double ArmourPoints=1;

    public Hammer(AbstractMonster mob1){this.Mob1=mob1;}

    public Hammer(double damagePoints,double armourPoints,AbstractMonster mob1)
    {
        this.ArmourPoints=armourPoints;
        this.DamagePoints=damagePoints;
        this.Mob1=mob1;
    }

    @Override
    public void addArmour(double armour) {

    }

    @Override
    public void addHP(double hp) {
        Mob1.addHP(hp+Mob1.getHealth()*0.02);
    }

    @Override
    public void addAttack(double attack) {
        Mob1.addAttack(attack+Mob1.getAttack()*0.04);
    }
}
