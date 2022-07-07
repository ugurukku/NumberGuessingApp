package main;

import applicationData.Registration;

import java.util.Scanner;


public class SigninSignUp {

    int countOfTry = 0;


    public boolean panel() {
        while (true) {
            System.out.print("What do you want to do?\n" +
                    "1. Sign in\n" +
                    "2. Sign up\n" +
                    ": ");

            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();

            if (i == 1) {
                Registration r = new Registration();
                if (r.getTheUser() == true) {
                    System.out.println("You signed in :)");
                    System.out.println("");
                    return true;

                } else {

                    System.out.println("nickname or password is incorrect");
                    System.out.println("");

                    countOfTry++;
                    if (countOfTry >= 3) {

                        System.err.println("You banned");
                        System.exit(1);
                    }

                    panel();

                }

            } else if (i == 2) {
                System.out.println("------------REGISTRATION------------");

                Registration r = new Registration();
                r.registerAnUser();

                panel();
            } else {
                System.out.println("Please, choose the correct operation(1 or 2)");
                panel();
            }
        }
    }


}
