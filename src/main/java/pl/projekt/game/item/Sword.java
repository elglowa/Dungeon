package pl.projekt.game.item;

import pl.projekt.game.mob.AbstractMonster;

/**
 * Przedmiot dostępny wyłącznie dla Elfa.
 * Zwiększa znacznie atak moba.
 */
public class Sword extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints = 4;
    private double ArmourPoints = 0;
    private double HpPoints = 0;

    public Sword(AbstractMonster mob1){this.Mob1=mob1;}

    public  Sword(double armourPoints,double damagePoints,double hpPoints,AbstractMonster mob1)
    {
        this.ArmourPoints = armourPoints;
        this.DamagePoints = damagePoints;
        this.HpPoints = hpPoints;
        this.Mob1=mob1;
    }

    /**
     * metoda dodaje 5% aktualnych punktów ataku moba,punkty ataku Itemu oraz parametr attack
     * do punktów ataku moba który posiada Item
     * @param attack przyjmuje double
     */
    @Override
    public void addAttack(double attack) { Mob1.addAttack(DamagePoints+attack+Mob1.getAttack()*0.05); }

    @Override
    public void addHP(double hp) { }

    @Override
    public void addArmour(double armour) { }
}
