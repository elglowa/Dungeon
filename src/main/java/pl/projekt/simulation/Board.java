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

    Board(int sizem, int mobs){
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
            break;
            case 1 :
                return new Diamond();
            break;
            case 2 :
                return new Stone();
            break;
            case 3 :
                return new Wood();
            break;
            default:
                System.out.println("nie dziala");
        }
    }



    @Override
    public void move() {

    }
    //return potrzebny koncowy jakis
    public AbstractMonster createRandomMob(){
        int randNbr = getRandomNumberInRange(0,3);
        switch (randNbr) {
            case 0 :
                return new Dwarf();
                break;
            case 1 :
                return new Elf();
                break;
            case 2 :
                return new Minotaur();
                break;
            case 3 :
                return new Orc();
                break;
            default:
                System.out.println("nie dziala");
        }
    }

    public int findEmptyPlace(){
        do{

        }while (playBoard[getPositionX()][getPositionY()] != null);

        return 0;
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
}

