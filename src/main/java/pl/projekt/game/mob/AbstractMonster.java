package pl.projekt.game.mob;
import pl.projekt.game.IStats;
import pl.projekt.game.item.*;
import pl.projekt.game.material.AbstractMaterials;

import java.util.ArrayList;
import java.util.Random;

/**
 * Klasa abstrakcyjna po której dziedziczy każdy mob.Dzięki niej potrafią tworzyć
 * sztylet,zbroje czy tarczę oraz zbierać diamenty i drewno.Znajdują się
 * w niej metody na zbieranie materiałów,tworzenie przedmiotów oraz walkę
 * i łączenie się mobów.
 */
public abstract class AbstractMonster implements IStats {
    private double Health;
    private double DefencePoints;
    private double AttacPoints;
    private int Eqweight;
    private int Woodnmb = 0;
    private int Diamondnmb = 0;
    protected int inmb = 0;
    private ArrayList<AbstractItem> Equipment = new ArrayList<>();

    public void addAttack(double Attack) { this.AttacPoints +=Attack; }

    public void addHP(double HP) { this.Health += HP; }

    public void addArmour(double Armr) { this.DefencePoints += Armr; }

    public double getAttack(){ return AttacPoints; }

    public double getDefence() { return DefencePoints; }

    public double getHealth() { return Health; }

    private int getEqweight() { return Eqweight; }

    private void setEqweight(int Eqweight) { this.Eqweight = Eqweight; }

    //do testu
    public int getWoodnmb(){ return this.Woodnmb; }
    //do testu
    public ArrayList<AbstractItem> getEquipment() { return Equipment; }

    /**
     * metoda zwiększa ilość posiadanych przez moba diamentów o 1
     */
    private void collectDiamonds(){ Diamondnmb++; }

    /**
     * metoda zwiększa ilość posiadanych przez moba kawałków drewna o 1
     */
    private void collectWood(){ Woodnmb++; }

    /**
     * metoda ktora losuje randomowa liczbe w zakresie
     * @param min minimalna liczba z zakresu
     * @param max maksymalna liczba z zakresu
     * @return zwraca ta liczbe
     */

    private int createRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max musi byc wiekszy niz min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * metoda tworzy oraz dodaje do Ekwipunku moba jedną sztukę Biżuterii
     * oraz odejmuje od ilości kawałków drewna i diamentów cenę za stworzenie
     * biżuterii(odpowiednio po 1)
     */
    private void createJewelery(){
        if(Diamondnmb==1 || Woodnmb==1) {
            for (AbstractItem equipment : Equipment) {
                if (equipment instanceof Jewelery) {
                    inmb++;
                }
            }
            if (inmb==0) {
                AbstractItem J1 = new Jewelery(this);
                Equipment.add(J1);
                J1.addAttack(0);
                J1.addArmour(0);
                J1.addHP(0);
            }
            inmb=0;
            Diamondnmb-=1;
            Woodnmb-=1;
        }
    }



    /**
     * metoda tworzy oraz dodaje do Ekwipunku moba jedną sztukę Zbroji oraz
     * odejmuje od ilości kawałków drewna cenę za stworzenie Zbroji(3 sztuki)
     */
    private void createArmor(){
        if(Woodnmb==3)
        {
            for (AbstractItem equipment : Equipment) {
                if (equipment instanceof Armor)
                    inmb++;
            }
            if(inmb==0)
            {
                AbstractItem A1=new Armor(this);
                Equipment.add(A1);
                A1.addAttack(0);
                A1.addArmour(0);
                A1.addHP(0);
            }
            inmb=0;
            Woodnmb-=3;
        }
    }

    /**
     * metoda tworzy oraz dodaje do Ekwipunku moba jedną sztukę Sztyletu oraz
     * odejmuje od ilości kawałków drewna cenę za stworzenie Sztyletu(2 sztuki)
     */
    private void createDagger() {
        if (Woodnmb == 2) {
            for (AbstractItem equipment : Equipment) {
                if (equipment instanceof Dagger)
                    inmb++;
            }
            if (inmb == 0) {
                AbstractItem D1 = new Dagger(this);
                Equipment.add(D1);
                D1.addAttack(0);
                D1.addArmour(0);
                D1.addHP(0);
            }
            inmb = 0;
            Woodnmb -=2;
        }
    }

    /**
     * metoda tworzy oraz dodaje do Ekwipunku moba jedną sztukę Tarczy oraz
     * odejmuje od ilości kawałków drewna cenę za stworzenie Tarczy(2 sztuki)
     */
    private void createShield(){
        if(Woodnmb==2)
        {
            for (AbstractItem equipment : Equipment) {
                if (equipment instanceof Shield)
                    inmb++;
            }
            if(inmb==0)
            {
                AbstractItem S1=new Shield(this);
                Equipment.add(S1);
                S1.addHP(0);
                S1.addAttack(0);
                S1.addArmour(0);
            }
            inmb=0;
            Woodnmb-=2;
        }
    }

    /**
     * Metoda wykonuje walke 2 mobow roznych klas a nastepnie zwraca wygranego
     * @param firstM 1 mob
     * @param secondM 2 mob
     * @return zwraca wygranego moba
     */
    // pozmieniac troche zeby bylo bardziej zbalansowane
    public AbstractMonster fight(AbstractMonster firstM, AbstractMonster secondM){
        if (firstM.getAttack() > secondM.getAttack()) {
            if (firstM.getDefence() + secondM.getHealth() > firstM.getDefence() + secondM.getHealth()) {

                return secondM;
            } else {
                return firstM;

            }
        } else {
            if (secondM.getHealth() + secondM.getDefence() > firstM.getHealth() + firstM.getDefence()) {

                return secondM;

            } else {

                return firstM;
            }
        }
    }

    /**
     * Metoda ktora w parametrach przyjmuje 2 moby tej samej klasy a nastepnie
     * laczy je w 1 nowego moba o sumie parametrow
     * @param monster1 1 mob
     * @param monster2 2 mob
     * @return zwraca nowego moba
     */

    public AbstractMonster merge(AbstractMonster monster1, AbstractMonster monster2) {
        double hp = monster1.getHealth() + monster2.getHealth();
        double attc = monster1.getAttack() + monster2.getAttack();
        double dff = monster1.getDefence() + monster2.getDefence();

        String name = monster1.getClass().getName();


        switch (name) {
            case "pl.projekt.game.mob.Elf":
                return new Elf(hp, dff, attc);
            case "pl.projekt.game.mob.Dwarf":
                return new Dwarf(hp, dff, attc);
            case "pl.projekt.game.mob.Minotaur":
                return new Minotaur(hp, dff, attc);
            case "pl.projekt.game.mob.Orc":
                return new Orc(hp, dff, attc);
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Metoda sprawdzwa czy materiał może zostać zebrany przez moba oraz zmiejsza posiadane
     * przez moba wlne miejsce na materiały
     * @param monster1 mob który zbiera materiał
     * @param materials zbierany materiał
     */

    public void collectMaterial(AbstractMonster monster1, AbstractMaterials materials){

        String name = materials.getClass().getName();
        switch (name) {
            case "pl.projekt.game.material.Wood":
                if(materials.isNotToHeavy((materials).getWeight(), monster1.getEqweight())){
                    monster1.collectWood();
                    monster1.setEqweight(monster1.getEqweight() - materials.getWeight());
                }
                break;
            case "pl.projekt.game.material.Stone":
                if(monster1 instanceof Orc) {
                    if(materials.isNotToHeavy((materials).getWeight(), monster1.getEqweight())) {
                        ((Orc) monster1).collectStone();
                        monster1.setEqweight(monster1.getEqweight() - materials.getWeight());
                    }

                }
                else if(monster1 instanceof Minotaur)
                {
                    if(materials.isNotToHeavy((materials).getWeight(), monster1.getEqweight())) {
                        ((Minotaur) monster1).collectStone();
                        monster1.setEqweight(monster1.getEqweight() - materials.getWeight());
                    }
                }
                break;
            case "pl.projekt.game.material.Iron":
                if(monster1 instanceof Minotaur){
                    if(materials.isNotToHeavy((materials).getWeight(), monster1.getEqweight())) {
                        ((Minotaur) monster1).collectIron();
                        monster1.setEqweight(monster1.getEqweight() - materials.getWeight());
                    }
                }
                else if(monster1 instanceof Elf){
                    if(materials.isNotToHeavy((materials).getWeight(), monster1.getEqweight())) {
                        ((Elf) monster1).collectIron();
                        monster1.setEqweight(monster1.getEqweight() - materials.getWeight());
                    }
                }
                break;
            case "pl.projekt.game.material.Diamond":
                if(materials.isNotToHeavy((materials).getWeight(), monster1.getEqweight())){
                    monster1.collectDiamonds();
                    monster1.setEqweight(monster1.getEqweight() - materials.getWeight());
                }
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * metoda w której mob wybiera jaki item ma stworzyć
     * @param monster mob który tworzy itemter
     */
    public void craftNewItem(AbstractMonster monster){

        if(monster instanceof Minotaur){
            switch (createRandomNumberInRange(1, 5)){
                case 1:
                    monster.createJewelery();
                    break;
                case 2:
                    monster.createShield();
                    break;
                case 3:
                    monster.createArmor();
                    break;
                case 4:
                    ((Minotaur) monster).createMaze();
                    break;
                case 5:
                    monster.createDagger();
            }
        }

        else if(monster instanceof Orc){
            switch (createRandomNumberInRange(1, 4)){
                case 1:
                    monster.createJewelery();
                    break;
                case 2:
                    monster.createShield();
                    break;
                case 3:
                    monster.createArmor();
                    break;
                case 4:
                    ((Orc)monster).createAxe();
                    break;
            }
        }

        else if(monster instanceof Dwarf){
            switch (createRandomNumberInRange(1, 4)){
                case 1:
                    monster.createJewelery();
                    break;
                case 2:
                    monster.createShield();
                    break;
                case 3:
                    monster.createArmor();
                    break;
                case 4:
                    ((Dwarf)monster).createHammer();
                    break;
            }
        }

        else if(monster instanceof Elf){
            switch (createRandomNumberInRange(1, 4)){
                case 1:
                    monster.createJewelery();
                    break;
                case 2:
                    monster.createShield();
                    break;
                case 3:
                    monster.createArmor();
                    break;
                case 4:
                    ((Elf)monster).createSword();
                    break;
            }
        }
    }
}