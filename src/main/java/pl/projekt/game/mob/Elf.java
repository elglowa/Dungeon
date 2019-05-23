package pl.projekt.game.mob;
import pl.projekt.game.material.AbstractMaterials;
import pl.projekt.game.material.Iron;
import java.util.ArrayList;

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

    public void setAttacPoints(double attacPoints) {
        this.attacPoints = attacPoints;
    }

    public void setDefencePoints(double defencePoints) {
        this.defencePoints = defencePoints;
    }

    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public double getAttack() {
        return attacPoints;
    }

    @Override
    public double getDefence() {
        return super.getDefence();
    }

    @Override
    public double getHealth() {
        return super.getHealth();
    }

    @Override
    public void createJewelery() {
        super.createJewelery();
    }

    public void collectIron(Iron ir){
       // Inventspr();
        Inventory.add(ir);
    }

    public void createSword(){
        //TODO
    }

    protected void seeInventory()
    {
        for(int i=0;i<this.Inventory.size();i++)
        {
            System.out.println(this.Inventory.get(i));
        }
    }
}
