package pl.projekt.game.item;

import pl.projekt.game.material.AbstractMaterials;
import pl.projekt.game.mob.AbstractMonster;

public class Jewelery extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints=1;
    private double ArmourPoints=1;

    public Jewelery(AbstractMonster mob1){
        this.Mob1=mob1;
    }

    public Jewelery(double damagePoints,double armourPoints,AbstractMonster mob1)
    {
        this.ArmourPoints=armourPoints;
        this.DamagePoints=damagePoints;
        this.Mob1=mob1;
    }


    @Override
    public void addArmour() {
        Mob1.addArmour(Mob1.getDefence()*0.02);
    }

    @Override
    public void addHP() {
        Mob1.addHP(Mob1.getHealth()*0.03);
    }

    @Override
    public void addAttack() {
        System.out.println(Mob1.getAttack());
        Mob1.addAttack(Mob1.getAttack()*0.02);
        System.out.println(Mob1.getAttack());
    }

}
