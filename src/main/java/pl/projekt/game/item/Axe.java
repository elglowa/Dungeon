package pl.projekt.game.item;

import pl.projekt.game.mob.AbstractMonster;

public class Axe extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints = 3;
    private double ArmourPoints = 0;

    public Axe(AbstractMonster mob1){ this.Mob1 = mob1; }

    public Axe(double damagePoints, double armourPoints, AbstractMonster mob1) {
        this.ArmourPoints = armourPoints;
        this.DamagePoints = damagePoints;
        this.Mob1 = mob1;
    }

    @Override
    public void addAttack(double attack) { Mob1.addAttack(attack+Mob1.getAttack()*0.07); }

    @Override
    public void addArmour(double armour) { Mob1.addArmour(armour+Mob1.getDefence()*(-0.03)); }

    @Override
    public void addHP(double hp) {

    }
}
