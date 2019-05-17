package pl.projekt.game.mob;

import pl.projekt.game.IStats;

public abstract class AbstractMonster implements IStats {
    private double healthPoints;
    private double defencePoints;
    private double attacPoints;


    private void addAttack(double attc) { this.attacPoints += attc; }

    private void addHP(double HP) { this.healthPoints += HP; }

    private void addArmour(double armr) { this.defencePoints += armr; }

    public void collectDiamonds(){
        //TODO
    }

    public void collectWood(){
        //TODO
    }

    public void createJeliewery(){
        //TODO
    }

    public void createArmor(){
        //TODO
    }

    public void createShield(){
        //TODO
    }

    public AbstractMonster fight(AbstractMonster firstM, AbstractMonster secondM){
        //TODO
        return null;
    }

    public AbstractMonster merge(AbstractMonster monster1, AbstractMonster abstractMonster2){
        //TODO
        //if monster1 instance of mob a,b,c .... create a new mob a,b,c with beter stats
        return null;
    }

    public void mergeOrFight(AbstractMonster monster1, AbstractMonster monster2){
        //TODO
    }
}