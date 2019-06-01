package pl.projekt.game;

/**
 * Interfejs po którym dziedziczą moby oraz przedmioty.
 */
public interface IStats {
    void addAttack(double attack);
    void addHP(double hp);
    void addArmour(double armour);

}
