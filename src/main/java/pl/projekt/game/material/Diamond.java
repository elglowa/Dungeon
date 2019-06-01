package pl.projekt.game.material;

/**
 * Materiał dostępny dla każdego moba.Potrzebny do wytworzenia Biżuterii.
 */
public class Diamond extends AbstractMaterials {
    private int weight = 8;
    public Diamond(){ }

    public Diamond(int weight) { this.weight = weight; }

    public int getWeight(){
        return this.weight;
    }
}
