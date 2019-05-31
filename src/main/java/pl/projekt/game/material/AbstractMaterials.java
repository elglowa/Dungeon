package pl.projekt.game.material;

public abstract class AbstractMaterials {
    /**
     * Metoda sprawdza czy w ekwipunku mob nie ma za duzo przedmiotow 1 rodzaju
     * @param weight waga przedmiutu
     * @param maxWeight maksymalna waga ktora mob moze przeniesc
     * @return zwraca prawde lub falsz w zaleznosi czy mob moze podniesc wiecej czy nie
     */

    public boolean isNotToHeavy(int weight, int maxWeight){
        if (weight >= maxWeight) return true;
        return false;

    }

    public abstract int getWeight();
}
