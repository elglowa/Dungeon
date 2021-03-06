package pl.projekt.game.mob;

import pl.projekt.game.item.AbstractItem;
import pl.projekt.game.item.Sword;
import java.util.ArrayList;

/**
 * Elf jest jednym z 4 ras pojawiających się w symulacji.
 * Charakteryzuje się standardowymi statystykami oraz możliwością
 * stworzenia Miecza.
 */
public class Elf extends AbstractMonster {
    private double healthPoints = 9;
    private double defencePoints = 9;
    private double attacPoints = 6;
    private int Eqweight=70;
    private int Woodnmb = 0;
    private int Diamondnmb = 0;
    private int Ironnmb = 0;
    private ArrayList<AbstractItem> Equipment = new ArrayList<AbstractItem>();


    public Elf(){ }

    public Elf(double healthPoints, double defencePoints, double attacPoints){
        this.attacPoints = attacPoints;
        this.defencePoints = defencePoints;
        this.healthPoints = healthPoints;
    }

    @Override
    public void addAttack(double attack) { this.attacPoints +=attack; }

    @Override
    public void addArmour(double armr) { this.defencePoints += armr; }

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
     * metoda tworzy oraz dodaje do Ekwipunku moba jedną sztukę Miecza oraz
     * odejmuje od ilości żelaza oraz kawałków drewna cenę za stworzenie Miecza
     * (Odpowiednio 2 i 1)
     */
    public void createSword(){
        if(Ironnmb == 2 && Woodnmb == 1)
        {
            for(int i = 0; i < Equipment.size(); i++)
            {
                if(Equipment.get(i) instanceof Sword)
                    inmb++;
            }
            if(inmb == 0)
            {
                AbstractItem S1=new Sword(this);
                Equipment.add(S1);
                S1.addAttack(0);
                S1.addArmour(0);
                S1.addHP(0);
            }
            inmb = 0;
            Woodnmb -= 1;
            Ironnmb -=2;
        }
        }
    }


