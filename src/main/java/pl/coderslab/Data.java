package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Data {
    static String [][] tasks;

    public static String[][] readFromFile(String fileName){

        File file = new File(fileName);
        try {
            Scanner scan = new Scanner(file);
            int numberOfLines = 0;
            while (scan.hasNextLine()) {
                scan.nextLine();
                numberOfLines += 1;

            }
            tasks = new String[numberOfLines][];
            scan.close();
            Scanner scan2 = new Scanner(file);

            int index = 0;
            while (scan2.hasNextLine()) {
                String line = scan2.nextLine();
                tasks[index] =line.split(",");
                index += 1;

            }
            scan2.close();
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku.");
        }

        return tasks;


    }
}
