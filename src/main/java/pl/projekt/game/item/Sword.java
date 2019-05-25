package pl.projekt.game.item;

import pl.projekt.game.mob.AbstractMonster;

public class Sword extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints=4;
    private double ArmourPoints=0;

    public Sword(AbstractMonster mob1){this.Mob1=mob1;}

    public  Sword(double armourPoints,double damagePoints,AbstractMonster mob1)
    {
        this.ArmourPoints=armourPoints;
        this.DamagePoints=damagePoints;
        this.Mob1=mob1;
    }

    @Override
    public void addAttack(double attack) {
        Mob1.addAttack(attack+Mob1.getAttack()*0.05);
    }

    @Override
    public void addHP(double hp) {

    }

    @Override
    public void addArmour(double armour) {

    }
}
