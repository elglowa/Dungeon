package pl.projekt.game.item;

import pl.projekt.game.mob.AbstractMonster;

public class Shield extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints=0;
    private double ArmourPoints=3;
    private double HpPoints=2;

    public Shield(AbstractMonster mob1){this.Mob1=mob1;}

    public  Shield(double armourPoints,double damagePoints,AbstractMonster mob1)
    {
        this.ArmourPoints=armourPoints;
        this.DamagePoints=damagePoints;
        this.Mob1=mob1;
    }

    @Override
    public void addArmour(double armour) {
        Mob1.addArmour(ArmourPoints+armour+Mob1.getDefence()*0.04);
    }

    @Override
    public void addHP(double hp) {
        Mob1.addHP(HpPoints+hp+Mob1.getHealth()*0.02);
    }

    @Override
    public void addAttack(double attack) {

    }
}