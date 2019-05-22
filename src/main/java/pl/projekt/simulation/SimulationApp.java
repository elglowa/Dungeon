package pl.projekt.simulation;

import java.util.Scanner;

public class SimulationApp {
    private int numberOfMobs;
    private int mapSize;


    private void getMapSize(){
        Scanner scan = new Scanner(System.in);
        try{
            System.out.println("Podaj wielkosc mapy");
            do{
                System.out.println("Podaj wielkosc mapy");
                mapSize = scan.nextInt();
                if(mapSize <= 0){
                    System.out.println("Wielkosc mapy nie moze byc ujemna");
                }else break;
            }while (true);


        }catch (IllegalArgumentException e){
            System.out.println(e.getCause().getMessage());
        }finally {
            scan.close();
        }
    }

    private void getNumberOfMobs(){
        Scanner scan = new Scanner(System.in);
        try {
            do {
                System.out.println("Podaj ilosc mobow (musi byc wieksza niz wielkosc mapy)");
                numberOfMobs = scan.nextInt();
                if (numberOfMobs > (mapSize*mapSize)){
                    System.out.println("ilosc Mobow > Mapa");
                }else break;

            }while (true);

        }catch (IllegalArgumentException e){
            System.out.println(e.getCause().getMessage());
        }finally {
            scan.close();
        }
    }

    private void saveToFIle(){


    }

    public static void main(String[] args) {

        //TODO
    }


}

