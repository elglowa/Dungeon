/**
 * Projekt Programowanie Obiektowe
 * @version v1.0
 * @author Jakub Gliwa, Kacper Ziejlo
 */

package pl.projekt.simulation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SimulationApp {
    private int numberOfMobs;
    private int mapSize;
    private Board gameBoard;
    private String date;
    private String fileName;


    /**
     * Metoda getMapSize pyta uzytkownika o podanie wielkosci mapy
     *
     */
    private void getMapSize(){
        Scanner scan = new Scanner(System.in);
        try{
            System.out.println("Podaj wielkosc mapy");
            do{
                System.out.println("Podaj wielkosc mapy");
                mapSize = scan.nextInt();
                if(mapSize <= 0){
                    System.out.println("Wielkosc mapy nie moze byc ujemna/rowna zero");
                }else break;
            }while (true);

        }catch (IllegalArgumentException e){
            System.out.println(e.getCause().getMessage());
        }finally {
            scan.close();
        }
    }

    /**
     * Metoda getNumberOfMobs pyta uzytkownika o wprowadzenie ilosci mobow
     * oraz sprawdza czy taka ilosc mobow moze zostac umieszczona na mapie
     */

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

    /**
     * Metoda createGameBoard tworzy nowy obiekt klasy board o ustalonej wielkosci mapy
     * oraz ilosci mobow
     */

    private void creatGameBoard(){ gameBoard = new Board(mapSize, numberOfMobs); }

    /**
     * Metoda createNewFile tworzy nowy plik o nazwie "symulacja + dzisiajesza data"
     */

    private void createNewFile(){
        date = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss").format(new Date());
        fileName = ("symulacja:" + date + ".txt");
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

    public void writeFile2(String a) throws IOException {
        FileWriter fw = new FileWriter(fileName);

        for (int i = 0; i < 10; i++) {
            fw.append("something" + i + a);
        }

        fw.close();
    }

    public static void main(String[] args) throws IOException {
        SimulationApp app = new SimulationApp();
        app.createNewFile();
    }


}

