package pl.projekt.game.mob;
import pl.projekt.game.material.AbstractMaterials;
import pl.projekt.game.material.Iron;
import java.util.ArrayList;

public class Elf extends AbstractMonster {
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

    public void collectIron(Iron ir){
        Inventory.add(ir);
    }

    public void createSword(){
        //TODO
    }

}
