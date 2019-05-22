package pl.projekt.game.mob;

import pl.projekt.game.IStats;
import pl.projekt.game.material.AbstractMaterials;
import pl.projekt.game.material.Iron;

import java.util.ArrayList;
import java.util.function.ToDoubleBiFunction;

public class Elf extends AbstractMonster{
    private double healthPoints = 10;
    private double defencePoints = 10;
    private double attacPoints = 5;
    private ArrayList<AbstractMaterials> Inventory;


    public Elf(){ }

    public Elf(double healthPoints, double defencePoints, double attacPoints){
        this.attacPoints = attacPoints;
        this.defencePoints = defencePoints;
        this.healthPoints = healthPoints;
    }

    @Override
    public void addAttack() {
    }

    @Override
    public void addHP() {
        //TODO
    }

    @Override
    public void addArmour() {
        //TODO
    }

    public double getAttacPoints() {
        return this.attacPoints;
    }


    public void collectIron(Iron ir){
        Inventspr();
        Inventory.add(ir);
    }

    public void createSword(){
        //TODO
    }
}
