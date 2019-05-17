package pl.projekt.game.mob;

import pl.projekt.game.IStats;

public abstract class AbstractMonster implements IStats {
    private double healthPoints;
    private double defencePoints;
    private double attacPoints;


    public void addAttack(double attc){ this.attacPoints += attc; }

    public void addHP(double HP){this.healthPoints += HP;}

    public void addArmour(double armr){this.defencePoints += armr;}

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