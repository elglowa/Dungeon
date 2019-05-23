package pl.projekt.game.mob;

import pl.projekt.game.IStats;
import pl.projekt.game.item.AbstractItem;
import pl.projekt.game.item.Armor;
import pl.projekt.game.item.Jewelery;
import pl.projekt.game.item.Shield;
import pl.projekt.game.material.AbstractMaterials;

import java.util.ArrayList;

public abstract class AbstractMonster implements IStats {
    private double Health;
    private double DefencePoints;
    private double AttacPoints;
    private int Woodnmb=0;
    private int Diamondnmb;
    private int inmb=0;
    private ArrayList<AbstractItem> Equipment=new ArrayList<AbstractItem>();

    public void addAttack(double Attack) { this.AttacPoints +=Attack; }

    public void addHP(double HP) { this.Health += HP; }

    public void addArmour(double Armr) { this.DefencePoints += Armr; }

    public double getAttack(){ return AttacPoints; }

    public double getDefence() { return DefencePoints; }

    public double getHealth() { return Health; }

    public void collectDiamonds(AbstractMaterials dd){
        Diamondnmb++;
    }

    public void collectWood(AbstractMaterials wd){
        Woodnmb++;
    }

    public void createJewelery(){
        if(Diamondnmb==1 || Woodnmb==1) {
            for (int i = 0; i < Equipment.size(); i++) {
                if (Equipment.get(i) instanceof Jewelery) {
                    inmb++;
                }
            }
            if (inmb == 0) {
                AbstractItem J1 = new Jewelery(this);
                Equipment.add(J1);
                J1.addAttack(0);
                J1.addArmour(0);
                J1.addHP(0);
            }
            Diamondnmb=0;
            Woodnmb=0;
        }
    }

    public void createArmor(){
        AbstractItem A1=new Armor(this);
        Equipment.add(A1);
        A1.addAttack(0);
        A1.addArmour(0);
        A1.addHP(0);
    }

    public void createShield(){
        AbstractItem S1=new Shield(this);
        Equipment.add(S1);
        S1.addHP(0);
        S1.addAttack(0);
        S1.addArmour(0);
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

}