package pl.projekt.game.mob;

public class Minotaur extends AbstractMonster{
    private double healthPoints = 10;
    private double defencePoints = 10;
    private double attacPoints = 5;


    Minotaur(){ }

    Minotaur(double healthPoints, double defencePoints, double attacPoints){
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
    public void collectStone(){
        //TODO
    }

    public void createMaze(){
        //TODO
    }
}
