package main;

import game.Game;

public class Main {

    public static void main(String[] args) {

        startOfGame();

    }

    public static void startOfGame() {

        SigninSignUp sisu = new SigninSignUp();
        boolean b = sisu.panel();

        if (b == true) {

            Game.game();
            startOfGame();

        } else {
            System.exit(1);
        }
    }
}
