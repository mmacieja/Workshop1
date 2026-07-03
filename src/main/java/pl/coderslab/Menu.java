package pl.coderslab;

import java.util.Scanner;

public class Menu {

    public static void start(){
        String[] options = {"add", "remove", "list", "exit"};

        Scanner scan = new Scanner(System.in);
        boolean running = true;
        while(running) {
            System.out.println(ConsoleColors.BLUE  + "Please select an option:");

            for (String option : options) {
                System.out.println(ConsoleColors.RESET + option);
            }

            String input = scan.nextLine();
            switch (input) {
                case "add":
                    Tasks.add();
                    break;
                case "remove":
                    Tasks.remove();
                    break;
                case "list":
                    Tasks.list();
                    break;
                case "exit":
                    Tasks.exit();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid input. Please select a correct option.");
            }

        }
        scan.close();
    }
}
