package pl.projekt.game.item;

import pl.projekt.game.IStats;
import pl.projekt.game.mob.AbstractMonster;

/**
 * Klasa abstrakcyjna po której dziedziczą wszystie przedmioty.
 */
public abstract class AbstractItem implements IStats
{

    private AbstractMonster Mob1;
    private int DamagePoints;
    private int ArmourPoints;
    private int HpPoints;

    public void setArmourPoints(int armourPoints) { ArmourPoints = armourPoints; }

    public void setDamagePoints(int damagePoints) { DamagePoints = damagePoints; }

    public void setHpPoints(int hpPoints) { HpPoints = hpPoints; }

    public void setMob1(AbstractMonster mob1) { Mob1 = mob1; }

    public int getArmourPoints() { return ArmourPoints; }

    public int getDamagePoints() { return DamagePoints; }

    public int getHpPoints() { return HpPoints; }

    public AbstractMonster getMob1() { return Mob1; }
}
