package pl.projekt.game.item;

import pl.projekt.game.mob.AbstractMonster;

/**
 * Przedmiot dostępny tylko dla Orka.Zwiększa znacznie atak,ale zmniejsza
 * nieznacznie defensywę.
 */
public class Axe extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints = 3;
    private double ArmourPoints = 0;
    private double HpPoints=0;

    public Axe(AbstractMonster mob1){ this.Mob1 = mob1; }

    public Axe(double damagePoints, double armourPoints, double hpPoints, AbstractMonster mob1) {
        this.ArmourPoints = armourPoints;
        this.DamagePoints = damagePoints;
        this.HpPoints = hpPoints;
        this.Mob1 = mob1;
    }

    /**
     * metoda dodaje 7% aktualnych punktów ataku moba,punkty Damage Itemu oraz parametr attack
     * do punktów ataku moba który posiada Item
     * @param attack przyjmuje double
     */
    @Override
    public void addAttack(double attack) { Mob1.addAttack(DamagePoints+attack+Mob1.getAttack()*0.07); }

    /**
     * metoda odejmuje 3% aktualnych punktów armour moba,punkty armour Itemu oraz parametr armour
     * do punktów armour moba który posiada Item
     * @param armour przyjmuje double
     */
    @Override
    public void addArmour(double armour) { Mob1.addArmour(ArmourPoints+armour+Mob1.getDefence()*(-0.03)); }

    @Override
    public void addHP(double hp) { Mob1.addHP(hp+HpPoints); }
}
