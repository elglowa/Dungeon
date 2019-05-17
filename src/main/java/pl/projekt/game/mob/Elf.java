package pl.projekt.game.mob;

import pl.projekt.game.IStats;

import java.util.function.ToDoubleBiFunction;

public class Elf extends AbstractMonster{
    private double healthPoints = 10;
    private double defencePoints = 10;
    private double attacPoints = 5;


    public Elf(){ }

    public Elf(double healthPoints, double defencePoints, double attacPoints){
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

    public void collectIron(){
        //TODO
    }

    public void createSword(){
        //TODO
    }
}
