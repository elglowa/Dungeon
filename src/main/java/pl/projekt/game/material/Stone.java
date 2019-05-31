package pl.projekt.game.material;

public class Stone extends AbstractMaterials {
    private int weight = 12;

    public Stone() { }

    public Stone(int weight) { this.weight = weight; }

    public int getWeight(){
        return this.weight;
    }

}
