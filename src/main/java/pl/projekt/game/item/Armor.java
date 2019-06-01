package pl.projekt.game.item;

import pl.projekt.game.mob.AbstractMonster;

/**
 * Przedmiot dostępny dla każdego moba.Zwiększa znaczaco ilość punktów
 * defensywy oraz nieznacząco zdrowie.
 */
public class Armor extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints=0;
    private double ArmourPoints = 4;
    private double HpPoints = 1;

    public Armor(AbstractMonster mob1){ this.Mob1 = mob1; }

    public Armor(double damagePoints, double armourPoints, double hpPoints, AbstractMonster mob1)
    {
        this.ArmourPoints = armourPoints;
        this.DamagePoints = damagePoints;
        this.HpPoints = hpPoints;
        this.Mob1 = mob1;
    }

    @Override
    public void addAttack(double attack) {
    }

    /**
     * metoda dodaje 5% aktualnych punktów hp moba,punkty hp Itemu oraz parametr hp
     * do punktów hp moba który posiada Item
     * @param hp przyjmuje double
     */
    @Override
    public void addHP(double hp) { Mob1.addHP(HpPoints+hp+Mob1.getHealth()*0.05); }

    /**
     * metoda dodaje 2% aktualnych punktów armour moba,punkty armour Itemu oraz parametr armour
     * do punktów armour moba który posiada Item
     * @param armour przyjmuje double
     */
    @Override
    public void addArmour(double armour) { Mob1.addArmour(ArmourPoints+armour+Mob1.getDefence()*0.02); }
}
