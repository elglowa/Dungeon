package pl.projekt.game.mob;

import pl.projekt.game.item.AbstractItem;
import pl.projekt.game.item.Axe;
import pl.projekt.game.material.AbstractMaterials;
import pl.projekt.game.material.Stone;

import java.util.ArrayList;

public class Orc extends AbstractMonster{
    private double healthPoints = 10;
    private double defencePoints = 10;
    private double attacPoints = 5;
    private int Eqweight=75;
    private int Woodnmb = 0;
    private int Diamondnmb = 0;
    private int Stonenmb = 0;
    private ArrayList<AbstractItem> Equipment=new ArrayList<AbstractItem>();


    public Orc(){ }

    public Orc(double healthPoints, double defencePoints, double attacPoints){
        this.attacPoints = attacPoints;
        this.defencePoints = defencePoints;
        this.healthPoints = healthPoints;
    }

    @Override
    public void addArmour(double armr) { super.addArmour(armr); }

    @Override
    public void addHP(double HP) { super.addHP(HP); }

    @Override
    public void addAttack(double attack) { super.addAttack(attack); }

    /**
     * metoda zwiększa ilość posiadanego przez moba kamienia o 1
     */
    public void collectStone(){ Stonenmb++; }

    /**
     * metoda tworzy oraz dodaje do Ekwipunku moba jedną sztukę Toporu oraz
     * odejmuje od ilości kawałków drewna oraz kamienia cenę za stworzenie
     * Toporu(odpowiednio 2 i 2)
     */
    public void createAxe(){
        if(Woodnmb==2 && Stonenmb==2)
        {
            {
                for (int i = 0; i < Equipment.size(); i++) {
                    if (Equipment.get(i) instanceof Axe) {
                        inmb++;
                    }
                }
                if (inmb==0) {
                    AbstractItem A1 = new Axe(this);
                    Equipment.add(A1);
                    A1.addAttack(0);
                    A1.addArmour(0);
                    A1.addHP(0);
                }
                inmb=0;
                Stonenmb-=2;
                Woodnmb-=2;
            }
        }
    }
}
