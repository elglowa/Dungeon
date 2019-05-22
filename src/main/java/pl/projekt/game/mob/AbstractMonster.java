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


    public void addAttack(double attc) { this.attacPoints += attc; }

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
        new Jewelery(1,1,this);
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

    public AbstractMonster merge(AbstractMonster monster1, AbstractMonster abstractMonster2){
        //TODO
        //if monster1 instance of mob a,b,c .... create a new mob a,b,c with beter stats
        return null;
    }

    public void mergeOrFight(AbstractMonster monster1, AbstractMonster monster2){
        //TODO
    }

    protected void Inventspr()
    {
        if (this.Inventory==null)
        {
            ArrayList<AbstractMaterials> Inventory=new ArrayList<AbstractMaterials>();
        }
    }
}