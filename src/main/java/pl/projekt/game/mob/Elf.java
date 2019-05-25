package pl.projekt.game.mob;
import pl.projekt.game.item.AbstractItem;
import pl.projekt.game.item.Dagger;
import pl.projekt.game.item.Sword;

import java.util.ArrayList;

public class Elf extends AbstractMonster {
    private double healthPoints = 10;
    private double defencePoints = 10;
    private double attacPoints = 5;
    private int Woodnmb=0;
    private int Diamondnmb=0;
    private int Ironnmb=0;
    private ArrayList<AbstractItem> Equipment=new ArrayList<AbstractItem>();


    public Elf(){ }

    public Elf(double healthPoints, double defencePoints, double attacPoints){
        this.attacPoints = attacPoints;
        this.defencePoints = defencePoints;
        this.healthPoints = healthPoints;
    }

    @Override
    public void addAttack(double attack) {
        this.attacPoints +=attack;
    }

    @Override
    public void addArmour(double armr) {
        this.defencePoints += armr;
    }

    @Override
    public void addHP(double HP) {
        this.healthPoints += HP;
    }

    @Override
    public double getAttack() {
        return this.attacPoints;
    }

    @Override
    public double getDefence() {
        return this.defencePoints;
    }

    @Override
    public double getHealth() {return this.healthPoints; }

    public void collectIron(){
        Ironnmb++;
    }

    public void createSword(){
        if(Ironnmb==2 && Woodnmb==1)
        {
            for(int i=0;i<Equipment.size();i++)
            {
                if(Equipment.get(i) instanceof Sword)
                    inmb++;
            }
            if(inmb==0)
            {
                AbstractItem D1=new Sword(this);
                Equipment.add(D1);
                D1.addAttack(0);
                D1.addArmour(0);
                D1.addHP(0);
            }
            inmb=0;
            Woodnmb-=1;
            Ironnmb-=2;
        }
        }
    }


