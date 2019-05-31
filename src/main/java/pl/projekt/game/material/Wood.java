package pl.projekt.game.material;

public class Wood extends AbstractMaterials {
    private int weight = 5;

    public Wood() { }

    public Wood(int weight) { this.weight = weight; }

    public int getWeight(){
        return this.weight;
    }
}
