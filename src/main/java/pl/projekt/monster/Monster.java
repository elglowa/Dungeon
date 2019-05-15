package pl.projekt.monster;

public abstract class Monster {
    private double healthPoints;
    private double defencePoints;
    private double attacPoints;

    public void setAttacPoints(double attacPoints) {
        this.attacPoints = attacPoints;
    }
    public double getAttacPoints() {
        return attacPoints;
    }
    public void setDefencePoints(double defencePoints) {
        this.defencePoints = defencePoints;
    }
    public double getDefencePoints() {
        return defencePoints;
    }
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }
    public double getHealthPoints() {
        return healthPoints;
    }
}