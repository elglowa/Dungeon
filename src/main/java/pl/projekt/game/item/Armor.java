package pl.projekt.game.item;

import pl.projekt.game.mob.AbstractMonster;

public class Armor extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints=0;
    private double ArmourPoints=4;
    private double HpPoints=1;

    public Armor(AbstractMonster mob1){this.Mob1=mob1;}

    public Armor(double damagePoints,double armourPoints,AbstractMonster mob1)
    {
        this.ArmourPoints=armourPoints;
        this.DamagePoints=damagePoints;
        this.Mob1=mob1;
    }

    @Override
    public void addAttack(double attack) {
    }

    @Override
    public void addHP(double hp) {
        Mob1.addHP(HpPoints+hp+Mob1.getHealth()/40);
    }

    @Override
    public void addArmour(double armour) {
        Mob1.addArmour(ArmourPoints+armour+Mob1.getDefence()/30);
    }
}
