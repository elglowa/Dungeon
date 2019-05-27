package pl.projekt.game.material;

public abstract class AbstractMaterials {
    private int weight;
    private int quantity;

    /**
     * Metoda sprawdza czy w ekwipunku mob nie ma za duzo przedmiotow 1 rodzaju
     * @param weight waga przedmiutu
     * @param quantity ilosc przedmiotu w eq moba
     * @param maxWeight maksymalna waga ktora mob moze przeniesc
     * @return zwraca prawde lub falsz w zaleznosi czy mob moze podniesc wiecej czy nie
     */

    public boolean isNotToHeavy(int weight, int quantity, int maxWeight){
        if (weight*quantity >= maxWeight) return true;
        return false;

    }
}
