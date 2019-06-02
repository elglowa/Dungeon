package pl.projekt.game.item;

import pl.projekt.game.mob.AbstractMonster;

/**
 * Przedmiot dostęny dla wszystkich.Zwiększa nieznacznie
 * zarówno hp,jak i defensywę.
 */
public class Shield extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints = 0;
    private double ArmourPoints = 3;
    private double HpPoints = 2;

    public Shield(AbstractMonster mob1){this.Mob1=mob1;}

    public  Shield(double armourPoints,double damagePoints,double hpPoints,AbstractMonster mob1)
    {
        this.ArmourPoints = armourPoints;
        this.DamagePoints = damagePoints;
        this.HpPoints = hpPoints;
        this.Mob1 = mob1;
    }

    /**
     * metoda dodaje 4% aktualnych punktów armour moba,punkty armour Itemu oraz parametr armour
     * do punktów armour moba który posiada Item
     * @param armour przyjmuje double
     */
    @Override
    public void addArmour(double armour) { Mob1.addArmour(ArmourPoints+armour+Mob1.getDefence()*0.04); }

    /**
     * metoda dodaje 2% aktualnych punktów hp moba,punkty hp Itemu oraz parametr hp
     * do punktów hp moba który posiada Item
     * @param hp przyjmuje double
     */
    @Override
    public void addHP(double hp) {
        Mob1.addHP(HpPoints+hp+Mob1.getHealth()*0.02);
    }

    @Override
    public void addAttack(double attack) { Mob1.addAttack(attack+DamagePoints); }
}