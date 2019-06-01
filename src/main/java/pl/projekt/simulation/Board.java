package pl.projekt.simulation;

import pl.projekt.game.material.AbstractMaterials;
import pl.projekt.game.material.Diamond;
import pl.projekt.game.material.Iron;
import pl.projekt.game.material.Stone;
import pl.projekt.game.material.Wood;
import pl.projekt.game.mob.AbstractMonster;
import pl.projekt.game.mob.Dwarf;
import pl.projekt.game.mob.Elf;
import pl.projekt.game.mob.Minotaur;
import pl.projekt.game.mob.Orc;


import java.util.Random;

/**
 *  Klasa, na której obiekcie pojawiają się materiały oraz moby walczą/łączą się
 */

public class Board implements IRandom {

    private int size;
    private int mobs;
    private int aliveMobs = 0;
    private int[] aliveMobsXCord;
    private int[] aliveMobsYCord;
    private int nrOfDwarfs;
    private int nrOfElfs;
    private int nrOfMinotaurs;
    private int nrOfOrcs;
    private Object[][] playBoard;

    public Board(int size, int mobs) {
        this.size = size;
        this.mobs = mobs;
    }


    /**
     * Metoda tworzy nowa plansze o wymiarze podanym przez urzytkownika
     */

    public void createArray() {
        if (size != 0) {
            playBoard = new Object[size][size];
        }
    }


    /**
     * Metoda losuje randomowa liczbe w przedziale podanym przez urzytkownika
     * @param min minimalna liczba z przedzialu
     * @param max maksymalna liczna z przedzialu
     * @return zwraca wylosowana liczbe
     */
    private int createRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max musi byc wiekszy niz min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Metoda losuje nowa kordynate X
     * @see Board#createRandomNumberInRange(int, int)
     * @return zwraca kordynate X
     */

    @Override
    public int getPositionX() { return createRandomNumberInRange(0, size - 1); }

    /**
     * Metoda losuje nowa kordynate Y
     * @see Board#createRandomNumberInRange(int, int)
     * @return zwraca kordynate Y
     */

    public int getPositionY() { return createRandomNumberInRange(0, size - 1); }

    /**
     * Metoda uzywajac metody createRandomNumberInRange losuje randomowa liczbe w przedziale od 0 do 3
     * a nastepie uzywa instrukcji switch zeby wybrac material
     * @see Board#createRandomNumberInRange(int, int)
     * @return zwraca wylosowany ranodomowo material
     */

    private AbstractMaterials randomMaterial() {
        int randNbr = createRandomNumberInRange(0, 3);
        switch (randNbr) {
            case 0:
                return new Iron();
            case 1:
                return new Diamond();
            case 2:
                return new Stone();
            case 3:
                return new Wood();
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Metoda uzywajac metody createRandomNumberInRange losuje randomowa liczbe w przedziale od 0 do 3
     * a nastepie uzywa instrukcji switch zeby wybrac Moba
     * @see Board#createRandomNumberInRange(int, int)
     * @return zwraca wylosowanego randomowo Moba
     */

    private AbstractMonster createRandomMob() {
        int randNbr = createRandomNumberInRange(0, 3);
        switch (randNbr) {
            case 0:
                return new Dwarf();
            case 1:
                return new Elf();
            case 2:
                return new Minotaur();
            case 3:
                return new Orc();
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Metoda tworzy ilosc mobow podanych przez uzytkownika a nastepnie przy pomocy
     * ustawia w randomowych miejscach na planszy
     * @see Board#createRandomMob()
     * @see Board#getPositionX()
     * @see Board#getPositionY()
     */

    @Override
    public void setMobPosition() {

        AbstractMonster[] monster = new AbstractMonster[mobs];
        for (int i = 0; i < mobs; i++) {
            monster[i] = createRandomMob();
        }

        for (int i = 0; i < mobs; i++) {
            int positionX;
            int positionY;
            do {
                positionX = getPositionX();
                positionY = getPositionY();

            } while (playBoard[positionX][positionY] != null);
            playBoard[positionX][positionY] = monster[i];
        }
    }

    /**
     * Metoda tworzy nowe materialy i ustawia je w randomowych miejscach na planszy
     * @see Board#getPositionX()
     * @see Board#getPositionY()
     *
     */

    @Override
    public void setMaterialPosition() {
        int howMuchMaterial = ((size * size) - mobs) / 2;
        AbstractMaterials[] material = new AbstractMaterials[howMuchMaterial];
        for (int i = 0; i < howMuchMaterial; i++) {
            material[i] = randomMaterial();
        }

        for (int i = 0; i < howMuchMaterial; i++) {
            int positionX;
            int positionY;
            do {
                positionX = getPositionX();
                positionY = getPositionY();

            } while (playBoard[positionX][positionY] != null);
            playBoard[positionX][positionY] = material[i];
        }
    }

    /**
     * Metoda tworzy nowa plansze a nastepnie ustawia na niej moby i materialy
     */
    public void placeOnTheBoard(){
        createArray();
        setMobPosition();
        setMaterialPosition();
    }

    /**
     * Metoda szuka mobow na planszy a nastepnie zapisuje ich poycje
     */
    private void lookForMobs(){
        aliveMobs = 0;
        aliveMobsXCord = new int[mobs];
        aliveMobsYCord = new int[mobs];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playBoard[i][j] instanceof AbstractMonster) {
                    aliveMobsXCord[aliveMobs] = i;
                    aliveMobsYCord[aliveMobs] = j;
                    aliveMobs++;
                }
            }
        }
    }

    /**
     * Metoda uzywajac metody <p>lookForMobs</p> szuka miejsc na ktorych wystepuja moby
     * nastepnie uzywajac w petli uzywajac metod <p>getPositionX</p> i <p>getPositionY</p>
     * losuje nowe kordynaty  dla wybranego moba nastepnie sprawdza czy nowe kordynaty sa puste
     * czy wystepuje na nich jakis mob/metrial
     * jesli na na nowych kordyjatach znajduje sie material uzywa metody <p>collectMaterial</p>
     * jesli na nowych kordynatach znajduje sie mob takiej samej klasy uzywa metody <p>merge</p>
     * jesli na nowych kordynatach znajduje sie mob innej klasy uzywa metody <p>fight</p>
     * @see Board#lookForMobs()
     * @see Board#getPositionX()
     * @see Board#getPositionY()
     * @see AbstractMonster#merge(AbstractMonster, AbstractMonster) i z 2 mobow powstaje jeden silniejszy
     * @see AbstractMonster#fight(AbstractMonster, AbstractMonster) ktora zwraca wygranego moba
     */


    @Override
    public void move() {

        lookForMobs();

        for (int i = 0; i < aliveMobs; i++) {
            int newPositionX = getPositionX();
            int newPositionY = getPositionY();

            if (playBoard[newPositionX][newPositionY] == null) {

                playBoard[newPositionX][newPositionY] = playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]];

                playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] = null;
            } else if (playBoard[newPositionX][newPositionY] instanceof AbstractMaterials) {
                AbstractMonster b = (AbstractMonster) playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]];

                b.collectMaterial(b, (AbstractMaterials)playBoard[newPositionX][newPositionY]);
                b.craftNewItem(b);

                playBoard[newPositionX][newPositionX] = playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]];
                playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] = null;


            } else if (playBoard[newPositionX][newPositionY] instanceof AbstractMonster) {

                if (playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] != null
                        && playBoard[newPositionX][newPositionY] != null) {
                    //Jesli sa tej samej klasy
                    if (playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]].getClass()
                            == playBoard[newPositionX][newPositionY].getClass()) {

                        AbstractMonster a = (AbstractMonster) playBoard[newPositionX][newPositionY];
                        AbstractMonster b = (AbstractMonster) playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]];

                        playBoard[newPositionX][newPositionY] = a.merge(a, b);

                        playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] = null;

                        aliveMobs--;
                     //jesli sa roznych klas
                    } else {
                        AbstractMonster a = (AbstractMonster) playBoard[newPositionX][newPositionY];
                        AbstractMonster b = (AbstractMonster) playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]];


                        playBoard[newPositionX][newPositionY] = a.fight(a, b);
                        playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] = null;
                        aliveMobs--;
                    }
                }
            }
        }
    }

    /**
     * Metoda zlicza ilosc poszczegolnych mobow
     */

    private void countMobs() {
        lookForMobs();
        nrOfDwarfs = 0;
        nrOfMinotaurs = 0;
        nrOfElfs = 0;
        nrOfOrcs = 0;

        for (int i = 0; i < aliveMobs; i++) {
            if (playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] instanceof Orc) {
                nrOfOrcs++;
            } else if (playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] instanceof Dwarf) {
                nrOfDwarfs++;
            } else if (playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] instanceof Elf) {
                nrOfElfs++;
            } else if (playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] instanceof Minotaur) {
                nrOfMinotaurs++;
            }
        }
    }

    /**
     * Metoda sprawdza czy na planszy znajduje sie tylko jeden gatunek moba
     * @return zwraca prawde jesli znajduje sie tylko 1 a falsz jesli kilka
     */

    public boolean onlyOneSpeciesLeft(){
        countMobs();
        if(nrOfOrcs == 0 && nrOfMinotaurs == 0 && nrOfElfs == 0 && nrOfDwarfs !=0) return true;
        else if(nrOfOrcs == 0 && nrOfMinotaurs == 0 && nrOfElfs != 0 && nrOfDwarfs ==0) return true;
        else if(nrOfOrcs == 0 && nrOfMinotaurs != 0 && nrOfElfs == 0 && nrOfDwarfs ==0) return true;
        else if(nrOfOrcs != 0 && nrOfMinotaurs == 0 && nrOfElfs == 0 && nrOfDwarfs ==0) return true;

        return false;
    }

    /**
     * Metoda tworzy nowego stringa z informacjami o ilosci mobow po rundzie
     * @return zwraca String z informacjami o mobach
     */
    public String getInfo(){
        countMobs();

        StringBuilder sB = new StringBuilder();

        sB.append("Ilosc Zywych Mobow: ");
        sB.append(aliveMobs);
        sB.append("\n Ilosc Zywych Orkow: ");
        sB.append(nrOfOrcs);
        sB.append("\n Ilosc Zywych Minotaurow: ");
        sB.append(nrOfMinotaurs);
        sB.append("\n Ilosc Zywych Elfow: ");
        sB.append(nrOfElfs);
        sB.append("\n Ilosc Zywych Karlow: ");
        sB.append(nrOfDwarfs);

        return sB.toString();
    }

}

