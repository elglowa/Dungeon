package pl.projekt.simulation;

public class SimulationApp {
    public static void main(String[] args) {
        Board a = new Board(4 , 6);
        a.createArray();
        a.setMobPosition();
        a.move();
    }
}
