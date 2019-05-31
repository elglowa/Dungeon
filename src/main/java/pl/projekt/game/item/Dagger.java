package pl.projekt.game.item;

import pl.projekt.game.mob.AbstractMonster;

public class Dagger extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints = 1.5;
    private double ArmourPoints = 0;
    private double HpPoints=0;

    public Dagger(AbstractMonster mob1){ this.Mob1 = mob1; }

    public Dagger(double damagePoints, double armourPoints, double hpPoints, AbstractMonster mob1) {
        this.ArmourPoints = armourPoints;
        this.DamagePoints = damagePoints;
        this.HpPoints = hpPoints;
        this.Mob1 = mob1;
    }

    /**
     * metoda dodaje 3% aktualnych punktów ataku moba,punkty Damage Itemu oraz parametr attack
     * do punktów Ataku moba który posiada Item
     * @param attack przyjmuje double
     */
    @Override
    public void addAttack(double attack) { Mob1.addAttack(DamagePoints+attack+Mob1.getAttack()*0.03); }

    @Override
    public void addHP(double hp) {

    }

    @Override
    public void addArmour(double armour) {

    }
}
