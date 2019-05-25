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

    public Board() {
    }

    public Board(int size, int mobs) {
        this.size = size;
        this.mobs = mobs;
    }

    private Object[][] playBoard;

    public void createArray() {
        if (size != 0) {
            playBoard = new Object[size][size];
        }
    }


    //losowanie numeru z listy
    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max musi byc wiekszy niz min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Override
    public int getPositionX() {
        return getRandomNumberInRange(0, size - 1);

    }

    public int getPositionY() {
        return getRandomNumberInRange(0, size - 1);
    }

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

    //return potrzebny koncowy jakis
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
                positionX = getRandomNumberInRange(0, size - 1);
                positionY = getRandomNumberInRange(0, size - 1);

            } while (playBoard[positionX][positionY] != null);
            playBoard[positionX][positionY] = monster[i];
        }
    }

    @Override
    public void setMaterialPosition() {
        int howMuchMaterial = (size - mobs) / 2;
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
    //TODO rozdzielic move na kilka metod
    @Override
    public void move() {
        int iloscZywychMobow = 0;
        int miejcaNaKtorychMobyX[] = new int[mobs];
        int miejcaNaKtorychMobyY[] = new int[mobs];
        //Sprawdzam ilosc zywych mobow
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
        for (int i = 0; i < iloscZywychMobow; i++) {
            for (int k = 0; k < iloscZywychMobow; k++) {
                int newPositionX = getPositionX();
                int newPositionY = getPositionY();

                if (playBoard[newPositionX][newPositionY] == null) {

                    playBoard[newPositionX][newPositionY] = playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]];

                    playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]] = null;
                }
                else if (playBoard[newPositionX][newPositionY] instanceof AbstractMaterials) {
                    playBoard[newPositionX][newPositionX] = playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]];
                    //TODO dodac cos co bedzie dodawalo materialy
                }
                else if (playBoard[newPositionX][newPositionY] instanceof AbstractMonster) {

                    if (playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]] != null
                            && playBoard[newPositionX][newPositionY] != null) {
                        //Jesli sa tej samej klasy
                        if (playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]].getClass()
                                == playBoard[newPositionX][newPositionY].getClass()) {

                            AbstractMonster a = (AbstractMonster) playBoard[newPositionX][newPositionY];
                            AbstractMonster b = (AbstractMonster) playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]];


                            playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]] = null;
                            playBoard[newPositionX][newPositionY] = a.merge(a, b);

                        } else {
                            AbstractMonster a = (AbstractMonster) playBoard[newPositionX][newPositionY];
                            AbstractMonster b = (AbstractMonster) playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]];

                            if (a.getAttack() > b.getAttack()) {
                                if (a.getDefence() + a.getHealth() > b.getDefence() + b.getHealth()) {
                                    playBoard[newPositionX][newPositionY]
                                            = playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]];

                                    playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]] = null;
                                }
                                else {
                                    playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]] = null;
                                }
                            }
                            else {
                                if (b.getHealth() + b.getDefence() > a.getHealth() + a.getDefence()) {
                                    playBoard[miejcaNaKtorychMobyX[i]][miejcaNaKtorychMobyY[i]] = null;
                                }
                                else {
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
        int miejcaNaKtorychMobyX[] = new int[mobs];
        int miejcaNaKtorychMobyY[] = new int[mobs];
        //Sprawdzam ilosc zywych mobow
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playBoard[i][j] instanceof AbstractMonster) {
                    miejcaNaKtorychMobyX[iloscZywychMobow] = i;
                    System.out.println(miejcaNaKtorychMobyX[i]);
                    miejcaNaKtorychMobyY[iloscZywychMobow] = j;
                    System.out.println(miejcaNaKtorychMobyY[i]);
                    System.out.println();
                    iloscZywychMobow++;
                    System.out.println("MOBY");
                    System.out.println(iloscZywychMobow);
                    System.out.println("_____");
                }
            }
        }

    }
}

