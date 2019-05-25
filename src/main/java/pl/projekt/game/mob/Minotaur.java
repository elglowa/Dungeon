package pl.projekt.game.mob;

import pl.projekt.game.item.AbstractItem;
import pl.projekt.game.material.AbstractMaterials;
import pl.projekt.game.material.Iron;

import java.util.ArrayList;

public class Minotaur extends AbstractMonster{
    private double healthPoints = 10;
    private double defencePoints = 10;
    private double attacPoints = 5;
    private ArrayList<AbstractItem> Equipment=new ArrayList<AbstractItem>();


    public Minotaur(){ }

    public Minotaur(double healthPoints, double defencePoints, double attacPoints){
        this.attacPoints = attacPoints;
        this.defencePoints = defencePoints;
        this.healthPoints = healthPoints;
    }

    @Override
    public void addAttack(double attack) {
        super.addAttack(attack);
    }

    @Override
    public void addArmour(double armr) {
        super.addArmour(armr);
    }

    @Override
    public void addHP(double HP) {
        super.addHP(HP);
    }

    public void collectIron(Iron ir){

    }
    public void collectStone(){
        //TODO
    }

    public void createMaze(){
        //TODO
    }
}
