package pl.projekt.game.mob;

import pl.projekt.game.IStats;
import pl.projekt.game.item.Jewelery;
import pl.projekt.game.material.AbstractMaterials;
import pl.projekt.game.material.Diamond;
import pl.projekt.game.material.Wood;

import java.util.ArrayList;

public abstract class AbstractMonster implements IStats {
    private double healthPoints;
    private double defencePoints;
    private double attacPoints;
    private ArrayList<AbstractMaterials> Inventory;

    public void addAttack(double attack) { this.attacPoints +=attack; }

    public void addHP(double HP) { this.healthPoints += HP; }

    public void addArmour(double armr) { this.defencePoints += armr; }

    public double getAttack(){ return attacPoints; }

    public double getDefence() { return defencePoints; }

    public double getHealth() { return healthPoints; }

    public void collectDiamonds(Diamond dd){
        Inventspr();
        Inventory.add(dd);
    }

    public void collectWood(Wood wd){
        Inventspr();
        Inventory.add(wd);
    }

    public void createJewelery(){
        Jewelery J1=new Jewelery(1,1,this);
        J1.addAttack();
    }

    public void createArmor(){
        //TODO
    }

    public void createShield(){
        //TODO
    }

    public AbstractMonster fight(AbstractMonster firstM, AbstractMonster secondM){
        //TODO
        return null;
    }

    public AbstractMonster merge(AbstractMonster monster1, AbstractMonster monster2) {
        double hp = monster1.getHealth() + monster2.getHealth();
        double attc = monster1.getAttack() + monster2.getAttack();
        double dff = monster1.getDefence() + monster2.getDefence();

        String name = monster1.getClass().getName().toString();

        switch (name) {
            case "pl.projekt.game.mob.Elf":
                return new Elf(hp, dff, attc);
            case "pl.projekt.game.mob.Dwarf":
                return new Dwarf(hp, dff, attc);
            case "pl.projekt.game.mob.Minotaur":
                return new Minotaur(hp, dff, attc);
            case "pl.projekt.game.mob.Orc":
                return new Orc(hp, dff, attc);
            default:
                throw new IllegalArgumentException();
        }
    }


    protected void Inventspr()
    {
        if (this.Inventory==null)
        {
            ArrayList<AbstractMaterials> Inventory=new ArrayList<AbstractMaterials>();
        }
    }

}