package pl.projekt.simulation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Projekt Programowanie Obiektowe
 * @version beta v0.9.1
 * @author Jakub Gliwa, Kacper Ziejlo
 */

public class SimulationApp {
    private int numberOfMobs;
    private int mapSize;
    private Board gameBoard;
    private String fileName;
    private List<String> infoToDisplay = new ArrayList<>();


    /**
     * Metoda getMapSize pyta uzytkownika o podanie wielkosci mapy i sprawdza czy wilkosc mapy jest > 0
     */
    private void getMapSize() {
        Scanner scan = new Scanner(System.in);
        try {
            do {
                System.out.println("Podaj wielkosc mapy");
                mapSize = scan.nextInt();
                if (mapSize <= 0) {
                    System.out.println("Wielkosc mapy nie moze byc ujemna/rowna zero");
                } else break;
            } while (true);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getCause().getMessage());
        }
    }

    /**
     * Metoda getNumberOfMobs pyta uzytkownika o wprowadzenie ilosci mobow
     * oraz sprawdza czy taka ilosc mobow moze zostac umieszczona na mapie
     */

    private void getNumberOfMobs(){
        try (Scanner scan = new Scanner(System.in)) {
            do {
                System.out.println("Podaj ilosc mobow (musi byc mniejsza niz wielkosc mapy)");
                numberOfMobs = scan.nextInt();
                if (numberOfMobs > (mapSize * mapSize)) {
                    System.out.println("ilosc Mobow > Mapa");
                } else break;
            } while (true);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getCause().getMessage());
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
        String date = new SimpleDateFormat("dd-MM-yyyy-HH:mm:ss").format(new Date());
        fileName = ("symulacja_" + date + ".txt");
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
            System.out.println("Plik " + fileName + " został utworzony");
    }

    /**
     * Metoda zapisuje liste String do pliku
     * @param data przyjmuje liste<String>
     */

    private void writeData(List<String> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for(String d:data) {
                bw.write(d);
                bw.newLine();
            }
        }catch (IOException e){
            System.out.println(e.getCause().getMessage());
        }
    }

    /**
     * Metoda laczy inne metody potrzebne do uruchomienia aplikacji oraz zapisu do pliku
     */

    private void runApp() {
        int i = 0;
        getMapSize();
        getNumberOfMobs();
        creatGameBoard();
        gameBoard.placeOnTheBoard();
        createNewFile();
        infoToDisplay.add(gameBoard.getInfo());
        do{
            if(gameBoard.onlyOneSpeciesLeft()) break;
            gameBoard.move();
            infoToDisplay.add(gameBoard.getInfo());

            i++;
        }while(i < 10);
        writeData(infoToDisplay);
    }


    public static void main(String[] args) {
        SimulationApp app = new SimulationApp();
        app.runApp();
    }
}

