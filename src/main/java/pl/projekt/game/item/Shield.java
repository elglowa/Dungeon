package pl.projekt.game.item;

import pl.projekt.game.mob.AbstractMonster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Shield extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints=0;
    private double ArmourPoints=4;

    public Shield(){}

    public  Shield(double armourPoints,double damagePoints,AbstractMonster mob1)
    {
        this.ArmourPoints=armourPoints;
        this.DamagePoints=damagePoints;
        this.Mob1=mob1;
    }

    @Override
    public void addArmour() {
        Mob1.addArmour(Mob1.getDefence()*0.04);
    }

    @Override
    public void addHP() {
        Mob1.addHP(Mob1.getHealth()*0.02);
    }

    @Override
    public void addAttack() {

    }
}
