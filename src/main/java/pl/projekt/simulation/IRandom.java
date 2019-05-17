package pl.projekt.simulation;

public interface IRandom {
    int getPositionX();
    int getPositionY();
    void setMobPosition();
    void setMaterialPosition();
    void move();
}
