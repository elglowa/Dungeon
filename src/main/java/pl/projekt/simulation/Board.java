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
    private int size = 0;
    private int mobs = 0;

    public Board(int sizem, int mobs){
        this.size = size;
        this.mobs = mobs;
    }


    public Object [][] playBoard = new Object[size][size];


    //losowanie numeru z listy
    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Override
    public int getPositionX() {
        return getRandomNumberInRange(0, size-1);

    }
    public int getPositionY() {
        return getRandomNumberInRange(0, size-1);
    }
    public AbstractMaterials randomMaterial(){
        int randNbr = getRandomNumberInRange(0,3);
        switch (randNbr) {
            case 0 :
                return new Iron();
            case 1 :
                return new Diamond();
            case 2 :
                return new Stone();
            case 3 :
                return new Wood();
            default:
                throw new IllegalArgumentException();
        }
    }

    //return potrzebny koncowy jakis
    public AbstractMonster createRandomMob(){
        int randNbr = getRandomNumberInRange(0,3);
        switch (randNbr) {
            case 0 :
                return new Dwarf();
            case 1 :
                return new Elf();
            case 2 :
                return new Minotaur();
            case 3 :
                return new Orc();
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public void setMobPosition(){

        AbstractMonster monster [] = new AbstractMonster[mobs];
        for(int i = 0; i < mobs ; i++){
            monster[i] = createRandomMob();
        }

        for(int i=0; i < mobs ; i++){
            int positionX;
            int positionY;
            do{
                positionX = getPositionX();
                positionY = getPositionY();

            }while (playBoard[positionX][positionY] != null);
            playBoard[positionX][positionY] = monster[i];
        }
    }

    @Override
    public void setMaterialPosition() {
        int howMuchMaterial = (size - mobs)/2;
        AbstractMaterials material [] = new AbstractMaterials[howMuchMaterial];
        for(int i = 0; i < howMuchMaterial ; i++){
            material[i] = randomMaterial();
        }

        for(int i=0; i < howMuchMaterial ; i++){
            int positionX;
            int positionY;
            do{
                positionX = getPositionX();
                positionY = getPositionY();

            }while (playBoard[positionX][positionY] != null);
            playBoard[positionX][positionY] = material[i];
        }
    }

    @Override
    public void move() {
        int iloscZywychMobow = 0;
        //Sprawdzam ilosc zywych mobow
        for(int i = 0 ; i < size ; i++){
            for (int j = 0 ; j < size ; j++){
                if(playBoard[i][j] instanceof AbstractMonster)
                    iloscZywychMobow++;
            }
        }



    }
}

