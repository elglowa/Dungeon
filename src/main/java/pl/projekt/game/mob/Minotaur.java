package pl.projekt.game.mob;

import pl.projekt.game.item.AbstractItem;
import pl.projekt.game.item.Maze;
import java.util.ArrayList;

/**
 * Minotaur jest jednym z 4 ras pojawiających się w symulacji.
 * Charakteryzuje się wysokim atakiem oraz niskim życiem oraz
 * obroną.Potrafi wytorzyć Buzdygan.
 */
public class Minotaur extends AbstractMonster{
    private double healthPoints = 6;
    private double defencePoints = 5;
    private double attacPoints = 12;
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
    public void addAttack(double attack) { this.attacPoints +=attack; }

    @Override
    public void addArmour(double armr) { this.defencePoints += armr;}

    @Override
    public void addHP(double HP) { this.healthPoints += HP; }

    @Override
    public double getAttack() { return attacPoints; }

    @Override
    public double getHealth() { return healthPoints; }

    @Override
    public double getDefence() { return defencePoints; }

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
     * Buzdyganu(odpowiednio 1,1 i 2)
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
