package pl.projekt.game.item;

import pl.projekt.game.mob.AbstractMonster;

public class Maze extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints=3;
    private double ArmourPoints=0;
    private double HpPoints=0;

    public Maze(AbstractMonster mob1){this.Mob1=mob1;}

    public Maze(double damagePoints,double armourPoints,double hpPoints,AbstractMonster mob1){
        this.ArmourPoints = armourPoints;
        this.DamagePoints = damagePoints;
        this.HpPoints = hpPoints;
        this.Mob1  =mob1;
    }

    /**
     * metoda dodaje 10% aktualnych punktów ataku moba,punkty ataku Itemu oraz parametr attack
     * do punktów ataku moba który posiada Item
     * @param attack przyjmuje double
     */
    @Override
    public void addAttack(double attack) {
        Mob1.addAttack(DamagePoints+attack+Mob1.getAttack()*0.1);
    }

    /**
     * metoda odejmuje 3% aktualnych punktów hp moba,punkty hp Itemu oraz parametr hp
     * do punktów hp moba który posiada Item
     * @param hp przyjmuje double
     */
    @Override
    public void addHP(double hp) {
        Mob1.addHP(Mob1.getHealth()*(-0.03)-hp);
    }

    /**
     * metoda odejmuje 3% aktualnych punktów armour moba,punkty armour Itemu oraz parametr armour
     * do punktów armour moba który posiada Item
     * @param armour przyjmuje armour
     */
    @Override
    public void addArmour(double armour) {
        Mob1.addArmour(Mob1.getDefence()*(-0.03)-armour);
    }
}
