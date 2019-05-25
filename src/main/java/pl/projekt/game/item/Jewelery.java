package pl.projekt.game.item;
import pl.projekt.game.mob.AbstractMonster;

public class Jewelery extends AbstractItem
{
    private AbstractMonster Mob1;
    private double DamagePoints=1;
    private double ArmourPoints=1;
    private double HpPoints=1;

    public Jewelery(AbstractMonster mob1){
        this.Mob1=mob1;
    }

    public Jewelery(double damagePoints,double armourPoints,AbstractMonster mob1)
    {
        this.ArmourPoints=armourPoints;
        this.DamagePoints=damagePoints;
        this.Mob1=mob1;
    }


    @Override
    public void addAttack(double attack) {
        Mob1.addAttack(DamagePoints+attack+Mob1.getAttack()/50);
    }

    @Override
    public void addArmour(double armour) {
        Mob1.addArmour(ArmourPoints+armour+Mob1.getDefence()/50);
    }

    @Override
    public void addHP(double hp) {
        Mob1.addHP(HpPoints+hp+Mob1.getHealth()/50);
    }
}
