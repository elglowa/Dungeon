package pl.projekt.game.material;

/**
 * Materiał który może zostać zebrany przez Elfa oraz Minotaura.
 * Służy do stworzenia Buzdyganu oraz Miecza.
 */
public class Iron extends AbstractMaterials {
    private int weight = 10;

    public Iron(){}

    public Iron(int weight) { this.weight = weight; }

    public int getWeight(){
        return this.weight;
    }
}
