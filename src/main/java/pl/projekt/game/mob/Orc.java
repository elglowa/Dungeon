package pl.projekt.game.mob;

import pl.projekt.game.item.AbstractItem;
import pl.projekt.game.material.AbstractMaterials;
import pl.projekt.game.material.Stone;

import java.util.ArrayList;

public class Orc extends AbstractMonster{
    private double healthPoints = 10;
    private double defencePoints = 10;
    private double attacPoints = 5;
    private ArrayList<AbstractItem> Equipment=new ArrayList<AbstractItem>();


    public Orc(){ }

    public Orc(double healthPoints, double defencePoints, double attacPoints){
        this.attacPoints = attacPoints;
        this.defencePoints = defencePoints;
        this.healthPoints = healthPoints;
    }

    @Override
    public void addArmour(double armr) {
        super.addArmour(armr);
    }

    @Override
    public void addHP(double HP) {
        super.addHP(HP);
    }

    @Override
    public void addAttack(double attack) {
        super.addAttack(attack);
    }

    public void collectStone(Stone st){

    }

    public void createAxe(){
        //TODO
    }
}
