package pl.projekt.game.item;

import pl.projekt.game.IStats;
import pl.projekt.game.mob.AbstractMonster;

public abstract class AbstractItem implements IStats
{
    //Dodano:getery w abstractonster,przykład itemu:Axe i odpobine w AbstractItem

    private AbstractMonster Mob1;
    private int DamagePoints;
    private int ArmourPoints;
    private int HpPoints;

    public void setArmourPoints(int armourPoints) {
        ArmourPoints = armourPoints;
    }

    public void setDamagePoints(int damagePoints) {
        DamagePoints = damagePoints;
    }

    public void setHpPoints(int hpPoints) {
        HpPoints = hpPoints;
    }

    public int getArmourPoints() {
        return ArmourPoints;
    }

    public int getDamagePoints() {
        return DamagePoints;
    }

    public int getHpPoints() {
        return HpPoints;
    }
}
