package pl.projekt.simulation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SimulationApp {
    private int numberOfMobs;
    private int mapSize;
    private Board gameBoard;
    private String date;

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

    private void creatGameBoard(){ gameBoard = new Board(mapSize, numberOfMobs); }

    private void createNewFile(){
        date = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss").format(new Date());
        String fileName = ("symulacja:" + date + ".txt");
        File file = new File(fileName);
        boolean fileExists = file.exists();
        if (!fileExists) {
            try {
                fileExists = file.createNewFile();
            } catch (IOException e) {
                System.out.println("Nie udało się utworzyć pliku");
            }
        }

        if (fileExists)
            System.out.println("Plik " + fileName + " istnieje lub został utworzony");
    }

    private void saveToFIle(){



    }

    public static void main(String[] args) {
        SimulationApp app = new SimulationApp();

    }


}

