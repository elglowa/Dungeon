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

public class Board implements IRandom {
    private int size;
    private int mobs;
    private int aliveMobs = 0;
    private int[] aliveMobsXCord;
    private int[] aliveMobsYCord;


    public Board(int size, int mobs) {
        this.size = size;
        this.mobs = mobs;
    }

    private Object[][] playBoard;

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
    private int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max musi byc wiekszy niz min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Metoda za pomoca
     * @see Board#getRandomNumberInRange(int, int)  losuje nowa kordynate X
     * @return zwraca kordynate X
     */

    @Override
    public int getPositionX() {
        return getRandomNumberInRange(0, size - 1);

    }

    /**
     * Metoda za pomoca
     * @see Board#getRandomNumberInRange(int, int)  losuje nowa kordynate Y
     * @return zwraca kordynate Y
     */

    public int getPositionY() {
        return getRandomNumberInRange(0, size - 1);
    }

    /**
     * Metoda uzywajac metody
     * @see Board#getRandomNumberInRange(int, int) losuje randomowa liczbe w przedziale od 0 do 3
     * a nastepie uzywa instrukcji switch zeby wybrac material
     * @return zwraca wylosowany ranodomowo material
     */

    private AbstractMaterials randomMaterial() {
        int randNbr = getRandomNumberInRange(0, 3);
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
     * Metoda uzywajac metody
     * @see Board#getRandomNumberInRange(int, int) losuje randomowa liczbe w przedziale od 0 do 3
     * a nastepie uzywa instrukcji switch zeby wybrac Moba
     * @return zwraca wylosowanego randomowo Moba
     */

    private AbstractMonster createRandomMob() {
        int randNbr = getRandomNumberInRange(0, 3);
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
     * Metoda tworzy ilosc mobow podanych przez uzytkownika przy pomocy metody
     * @see Board#createRandomMob()
     * a nastepnie przy pomocy metod
     * @see Board#getPositionX() i
     * @see Board#getPositionY()
     * ustawia w randomowych miejscach na planszy
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
     * Metoda tworzy nowe materialy a nastepnie przy pomocy metod
     * @see Board#getPositionX() i
     * @see Board#getPositionY()
     * ustawia w randomowych miejscach na planszy
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
                    System.out.println(aliveMobs);
                }
            }
        }
    }


    @Override
    public void move() {

        lookForMobs();

        for(int i = 0; i < aliveMobs; i++) {
            for (int k = 0; k < aliveMobs; k++) {
                int newPositionX = getPositionX();
                int newPositionY = getPositionY();

                if (playBoard[newPositionX][newPositionY] == null) {

                    playBoard[newPositionX][newPositionY] = playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]];

                    playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] = null;
                } else if (playBoard[newPositionX][newPositionY] instanceof AbstractMaterials) {
                    String name = playBoard[newPositionX][newPositionY].getClass().getName().toString();
                    playBoard[newPositionX][newPositionX] = playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]];
                    playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] = null;
                    switch (name) {
                        case "pl.projekt.game.material.Wood":
                            //TODO spr czy mob moze brac material + dodac ten material do inventory
                            break;
                        case "pl.projekt.game.material.Stone":
                            //TODO spr czy mob moze brac material + dodac ten material do inventory
                            break;
                        case "pl.projekt.game.material.Iron":
                            //TODO spr czy mob moze brac material + dodac ten material do inventory
                            break;
                        case "pl.projekt.game.material.Diamond":
                            //TODO spr czy mob moze brac material + dodac ten material do inventory
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }


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

                        } else {
                            AbstractMonster a = (AbstractMonster) playBoard[newPositionX][newPositionY];
                            AbstractMonster b = (AbstractMonster) playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]];


                            //nowa wersja
                            playBoard[newPositionX][newPositionY] = a.fight(a , b);
                            playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] = null;
                            aliveMobs--;


                            //Stara wersja nowa powinna juz dzialac

                            /*if (a.getAttack() > b.getAttack()) {
                                if (a.getDefence() + a.getHealth() > b.getDefence() + b.getHealth()) {
                                    playBoard[newPositionX][newPositionY]
                                            = playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]];

                                    playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] = null;

                                    aliveMobs--;
                                } else {
                                    playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] = null;

                                    aliveMobs--;
                                }
                            } else {
                                if (b.getHealth() + b.getDefence() > a.getHealth() + a.getDefence()) {
                                    playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] = null;

                                    aliveMobs--;
                                } else {
                                    playBoard[newPositionX][newPositionY]
                                            = playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]];
                                    playBoard[aliveMobsXCord[i]][aliveMobsYCord[i]] = null;

                                    aliveMobs--;
                               }

                             */


                        }
                    }
                }
            }
        }
    }

    //TODO dodac metode ktora zlicza ilosc poszczegolnych mobow
    //TODO metoda boolean ktora sprawdza czy zostal tylko 1 gatunek na planszy
    //TODO metoda ktora laczy wszystkie metody przy tworzeniu planszy

    public void wypisz(){
        int iloscZywychMobow = 0;
        int[] absX = new int[mobs];
        int[] absY = new int[mobs];
        //Sprawdzam ilosc zywych mobow
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playBoard[i][j] instanceof AbstractMonster) {
                    absX[iloscZywychMobow] = i;
                    System.out.println("Pozycja X: "+ i);
                    absY[iloscZywychMobow] = j;
                    System.out.println("Pozycja Y: "+ j);
                    System.out.println();
                    iloscZywychMobow++;
                    System.out.println("MOB nr " + iloscZywychMobow);
                    System.out.println("_____");
                }
            }
        }

    }
}

