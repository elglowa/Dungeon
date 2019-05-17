package pl.projekt.game.material;

public abstract class AbstractMaterials {
    private int weight;
    private int quantity;

    public boolean isNotToHeavy(int weight, int quantity, int maxWeight){
        if (weight*quantity >= maxWeight) return true;
        return false;

    }
}
