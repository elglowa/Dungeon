package pl.projekt.game.item;
import pl.projekt.game.mob.AbstractMonster;

/**
 * Przedmiot dostępny dla wszystkich mobów.Nieznacznie
 * zwiększa wszystkie statystyki.
 */
public class Jewelery extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints=1;
    private double ArmourPoints=1;
    private double HpPoints=1;

    public Jewelery(AbstractMonster mob1){
        this.Mob1=mob1;
    }

    public Jewelery(double damagePoints,double armourPoints,double hpPoints,AbstractMonster mob1)
    {
        this.ArmourPoints = armourPoints;
        this.DamagePoints = damagePoints;
        this.HpPoints = hpPoints;
        this.Mob1 = mob1;
    }

    /**
     * metoda dodaje 2% aktualnych punktów ataku moba,punkty ataku Itemu oraz parametr attack
     * do punktów ataku moba który posiada Item
     * @param attack przyjmuje double
     */
    @Override
    public void addAttack(double attack) {
        Mob1.addAttack(DamagePoints+attack+Mob1.getAttack()*0.02);
    }

    /**
     * metoda dodaje 2% aktualnych punktów armour moba,punkty armour Itemu oraz parametr armour
     * do punktów armour moba który posiada Item
     * @param armour przyjmuje double
     */
    @Override
    public void addArmour(double armour) {
        Mob1.addArmour(ArmourPoints+armour+Mob1.getDefence()*0.02);
    }

    /**
     * metoda dodaje 2% aktualnych punktów hp moba,punkty hp Itemu oraz parametr hp
     * do punktów hp moba który posiada Item
     * @param hp przyjmuje double
     */
    @Override
    public void addHP(double hp) {
        Mob1.addHP(HpPoints+hp+Mob1.getHealth()*0.02);
    }
}
