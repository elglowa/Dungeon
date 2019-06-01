package pl.projekt.game.material;

/**
 * Materiał który może być zebrany przez Krasnoluda,Minotura oraz Orka.
 * Służy do stworzenia Młota,Buzdyganu oraz Topora.
 */
public class Stone extends AbstractMaterials {
    private int weight = 12;

    public Stone() { }

    public Stone(int weight) { this.weight = weight; }

    public int getWeight(){
        return this.weight;
    }

}
