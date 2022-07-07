package applicationData;

import databaseUtil.RelationWithDatabase;

import java.util.Scanner;

public class Registration {

    public void registerAnUser() {

        Scanner sc = new Scanner(System.in);

        System.out.print("username= ");
        String username = sc.nextLine();
        if (RelationWithDatabase.getUser(username) == true) {
            System.out.println("username already taken.");
            registerAnUser();
        }


        System.out.println("");

        System.out.print("password= ");
        String password = sc.nextLine();


        RelationWithDatabase.addUser(username, password);

        System.out.println("Succesfully added.");
    }

    public boolean getTheUser() {
        System.out.println("-----SIGN IN TO YOUR ACCOUNT-----");
        Scanner sc = new Scanner(System.in);
        System.out.print("nickname= ");
        String nickname = sc.nextLine();
        System.out.println("");

        System.out.print("password= ");
        String password = sc.nextLine();

        try{if (RelationWithDatabase.getUserPassword(nickname).equalsIgnoreCase(password)){
            return true;
        }else{
            return false;
        }
        }catch (Exception ex){
            return false;
        }
    }
}
