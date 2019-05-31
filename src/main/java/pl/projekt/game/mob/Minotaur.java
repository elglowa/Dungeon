package pl.projekt.game.mob;

import pl.projekt.game.item.AbstractItem;
import pl.projekt.game.item.Maze;
import pl.projekt.game.material.AbstractMaterials;
import pl.projekt.game.material.Iron;

import java.util.ArrayList;

public class Minotaur extends AbstractMonster{
    private double healthPoints = 10;
    private double defencePoints = 10;
    private double attacPoints = 5;
    private int Eqweight=90;
    private int Ironnmb=0;
    private int Stonenmb=0;
    private int Woodnmb=0;
    private int Diamondnmb=0;
    private ArrayList<AbstractItem> Equipment = new ArrayList<AbstractItem>();


    public Minotaur(){ }

    public Minotaur(double healthPoints, double defencePoints, double attacPoints){
        this.attacPoints = attacPoints;
        this.defencePoints = defencePoints;
        this.healthPoints = healthPoints;
    }

    @Override
    public void addAttack(double attack) { super.addAttack(attack); }

    @Override
    public void addArmour(double armr) { super.addArmour(armr); }

    @Override
    public void addHP(double HP) { super.addHP(HP); }

    /**
     * Zwiększa ilość posiadanego przez moba żelaza o 1
     */
    public void collectIron(){ Ironnmb++; }

    /**
     * metoda zwiększa ilość posiadanego przez moba kamienia o 1
     */
    public void collectStone(){ Stonenmb++; }

    /**
     * metoda tworzy oraz dodaje do Ekwipunku moba jedną sztukę Buzdyganu oraz
     * odejmuje od ilości żelaza,kawałków drewna oraz kamienia cenę za stworzenie
     * Młota(odpowiednio 1,1 i 2)
     */
    public void createMaze(){
        if(Ironnmb == 1 && Stonenmb == 1 && Woodnmb == 2)
        {
            for (int i = 0; i < Equipment.size(); i++) {
                if (Equipment.get(i) instanceof Maze) {
                    inmb++;
                }
            }
            if (inmb==0) {
                AbstractItem M1 = new Maze(this);
                Equipment.add(M1);
                M1.addAttack(0);
                M1.addArmour(0);
                M1.addHP(0);
            }
            inmb = 0;
            Ironnmb -= 1;
            Woodnmb -=2 ;
            Stonenmb -=1 ;
        }
    }
}
