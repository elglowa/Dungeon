package pl.projekt.simulation;

public interface Random {
    int getMobPosition();
    void setMobPosition(int mobPosition);
    int getMaterialPosition();
    void setMaterialPosition(int matPosition);
    void move();
}
