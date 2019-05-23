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
    private ArrayList<AbstractMaterials> Inventory=new ArrayList<AbstractMaterials>();

    public void addAttack(double attack) { this.attacPoints +=attack; }

    public void addHP(double HP) { this.healthPoints += HP; }

    public void addArmour(double armr) { this.defencePoints += armr; }

    public double getAttack(){ return attacPoints; }

    public double getDefence() { return defencePoints; }

    public double getHealth() { return healthPoints; }

    public void collectDiamonds(AbstractMaterials dd){
      //  Inventspr();
        Inventory.add(dd);
    }

    public void collectWood(AbstractMaterials wd){
      //  Inventspr();
        Inventory.add(wd);
    }

    public void createJewelery(){
        Jewelery J1=new Jewelery(this);
        J1.addAttack();
        J1.addArmour();
        J1.addHP();

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

    /*protected void Inventspr()
    {
        if (this.Inventory.isEmpty())
        {
            ArrayList<AbstractMaterials> Inventory=new ArrayList<AbstractMaterials>();
        }
    }

    protected void seeInventory()
    {
        for(int i=0;i<this.Inventory.size();i++)
        {
            System.out.println(this.Inventory.get(i));
        }
    }*/
}