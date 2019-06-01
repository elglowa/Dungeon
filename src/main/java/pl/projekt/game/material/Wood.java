package pl.projekt.game.material;

/**
 * Materiał dostępny dla każdego moba.Można dzięki niemu stworzyć
 * miemal każdy przedmiot w symulacji.
 */
public class Wood extends AbstractMaterials {
    private int weight = 5;

    public Wood() { }

    public Wood(int weight) { this.weight = weight; }

    public int getWeight(){
        return this.weight;
    }
}
