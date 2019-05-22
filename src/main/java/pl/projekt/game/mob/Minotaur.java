package pl.projekt.game.mob;

import pl.projekt.game.material.AbstractMaterials;
import pl.projekt.game.material.Iron;

import java.util.ArrayList;

public class Minotaur extends AbstractMonster{
    private double healthPoints = 10;
    private double defencePoints = 10;
    private double attacPoints = 5;
    private ArrayList<AbstractMaterials> Inventory;


    public Minotaur(){ }

    public Minotaur(double healthPoints, double defencePoints, double attacPoints){
        this.attacPoints = attacPoints;
        this.defencePoints = defencePoints;
        this.healthPoints = healthPoints;
    }

    @Override
    public void addAttack() {
        //TODO
    }

    @Override
    public void addHP() {
        //TODO
    }

    @Override
    public void addArmour() {
        //TODO
    }

    public void collectIron(Iron ir){
        Inventspr();
        Inventory.add(ir);
    }
    public void collectStone(){
        //TODO
    }

    public void createMaze(){
        //TODO
    }
}
