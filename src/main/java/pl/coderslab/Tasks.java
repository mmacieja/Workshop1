package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tasks {
    static String [][] tasks = Data.readFromFile("tasks.csv");;

    public static void add(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please add task description and press enter:");
        String [] newTask = {scan.nextLine()};

        System.out.println("Please add task due date in the format: yyyy-mm-dd:");
        String [] dueDate = {scan.nextLine()};

        System.out.println("Is your task important: true/false");
        String [] isImportant = {scan.nextLine()};
        String[][] tasks2 = Arrays.copyOf(tasks, tasks.length + 1);
        tasks2[tasks2.length -1] = new String[] {newTask[0], dueDate[0], isImportant[0]};

        tasks=tasks2;


    }
    public static void list(){

        for (int i = 0; i < tasks.length; i++) {
            System.out.print(i + ": " );
            for (int j = 0; j < tasks[i].length; j++) {
                System.out.print(tasks[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void remove() {

        System.out.println("Please select a number to remove:");
        Scanner scan = new Scanner(System.in);
        int number = -1;
        boolean keepGoing = true;
        while (keepGoing){
            try {
                number = scan.nextInt();
                if (number >= 0 && number < tasks.length) {
                    tasks = ArrayUtils.remove(tasks, number);
                    System.out.println("Task successfully removed.");
                    keepGoing = false;

                } else {
                    System.out.println("Incorrect argument passed. Please give number greater or equal 0 and within the list.");

                }

            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println("Incorrect argument passed. Please give number greater or equal 0 and within the list. " + e.getMessage());
                scan.next();

            }
        }

    }
    public static void exit() {

        try (PrintWriter printWriter = new PrintWriter("tasks.csv")) {
            for (String[] task: tasks){
                printWriter.println(String.join(",", task));
            }
            System.out.println(ConsoleColors.RED + "File successfully saved. Bye, bye!");

        } catch (FileNotFoundException e) {
            System.out.println("Error while saving the file." + e.getMessage());
        }


    }

}
