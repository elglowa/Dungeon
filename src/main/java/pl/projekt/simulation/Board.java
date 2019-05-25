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
    private int iloscZywychMobow = 0;
    private int miejcaNaKtorychMobyX[];
    private int miejcaNaKtorychMobyY[];

    public Board() {
    }

    public Board(int size, int mobs) {
        this.size = size;
        this.mobs = mobs;
    }

    private Object[][] playBoard;

    /**
     * Metoda createArray tworzy nowa plansze o wymiarze podanym przez urzytkownika
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
    private static int getRandomNumberInRange(int min, int max) {
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

    public AbstractMaterials randomMaterial() {
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

    public AbstractMonster createRandomMob() {
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

        AbstractMonster monster[] = new AbstractMonster[mobs];
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
        AbstractMaterials material[] = new AbstractMaterials[howMuchMaterial];
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
    public void lookForMobs(){
        iloscZywychMobow = 0;
        miejcaNaKtorychMobyX = new int[mobs];
        miejcaNaKtorychMobyY = new int[mobs];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playBoard[i][j] instanceof AbstractMonster) {
                    miejcaNaKtorychMobyX[iloscZywychMobow] = i;
                    miejcaNaKtorychMobyY[iloscZywychMobow] = j;
                    iloscZywychMobow++;
                    System.out.println(iloscZywychMobow);
                }
            }
        }
    }
    //TODO rozdzielic move na kilka metod
    @Override
    public void move() {

        lookForMobs();

        for(int i = 0; i < iloscZywychMobow; i++) {
            for (int k = 0; k < iloscZywychMobow; k++) {
                int newPositionX = getPositionX();
                int newPositionY = getPositionY();

                if (playBoard[newPositionX][newPositionY] == null) {

                    playBoard[newPositionX][newPositionY] = playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]];

                    playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]] = null;
                } else if (playBoard[newPositionX][newPositionY] instanceof AbstractMaterials) {
                    String name = playBoard[newPositionX][newPositionY].getClass().getName().toString();
                    playBoard[newPositionX][newPositionX] = playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]];
                    playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]] = null;
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

                    if (playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]] != null
                            && playBoard[newPositionX][newPositionY] != null) {
                        //Jesli sa tej samej klasy
                        if (playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]].getClass()
                                == playBoard[newPositionX][newPositionY].getClass()) {

                            AbstractMonster a = (AbstractMonster) playBoard[newPositionX][newPositionY];
                            AbstractMonster b = (AbstractMonster) playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]];

                            playBoard[newPositionX][newPositionY] = a.merge(a, b);

                            playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]] = null;

                            iloscZywychMobow--;

                        } else {
                            AbstractMonster a = (AbstractMonster) playBoard[newPositionX][newPositionY];
                            AbstractMonster b = (AbstractMonster) playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]];

                            if (a.getAttack() > b.getAttack()) {
                                if (a.getDefence() + a.getHealth() > b.getDefence() + b.getHealth()) {
                                    playBoard[newPositionX][newPositionY]
                                            = playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]];

                                    playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]] = null;
                                } else {
                                    playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]] = null;
                                }
                            } else {
                                if (b.getHealth() + b.getDefence() > a.getHealth() + a.getDefence()) {
                                    playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]] = null;
                                } else {
                                    playBoard[newPositionX][newPositionY]
                                            = playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]];

                                }
                            }
                        }
                    }
                }
            }
        }
    }


    public void wypisz(){
        int iloscZywychMobow = 0;
        int absX[] = new int[mobs];
        int absY[] = new int[mobs];
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

