package game;

import java.util.Random;
import java.util.Scanner;

public class Game {
    static int gameNumber = 0;

    public static void game() {
        while (true) {
            int input = gameMenu();

            switch (input) {
                case 1:
                    inputDetail();
                    break;
                case 2:
                    startGame();
                    break;
                case 3:
                    return;
                case 4:
                    System.exit(1);
            }
        }
    }

    public static int gameMenu() {

        System.out.println("1. Add detail\n" +
                "2. Start competition\n" +
                "3. Log out\n" +
                "4. Exit");

        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void startGame() {
        if (gameNumber < 1) {
            System.out.println("You should add detail");
            System.out.println("");
            return;
        }
        System.out.println("-----GAME-----");


        int number = new Random().nextInt(gameNumber);
        System.out.print("Guess the number:");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        if (number == i) {
            System.out.println("Congratulations you won.");
            System.out.println("");
        } else {
            System.out.println("You failed.");
        }

    }

    public static void inputDetail() {
        System.out.println("Choose number between 1 and 5");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        if (i < 1 || i > 5) {
            System.out.println("Set correct number");
            inputDetail();
        }
        System.out.println("Successfully set.");
        gameNumber = i;
    }


}
