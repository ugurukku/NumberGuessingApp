package databaseUtil;

import lombok.SneakyThrows;
import org.jetbrains.annotations.Nullable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RelationWithDatabase {
    public static void main(String[] args) {

    }


    public static boolean getUser(String nickname) {

        ArrayList<String> nicknames = getUserName();

        for (int i = 0; i < nicknames.size(); i++) {

            if (nicknames.get(i).equalsIgnoreCase(nickname)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> getUserName() {

        ArrayList<String> s = new ArrayList<>();

        try (Connection connection = connectToDatabase()) {

            Statement statement = connection.createStatement();
            statement.execute("SELECT nickname FROM registrationapp");
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                s.add(resultSet.getString("nickname"));
            }

            return s;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String getUserPassword(String nickname) {

        try (Connection connection = connectToDatabase()) {

            Statement statement = connection.createStatement();
            statement.execute("SELECT passsword FROM registrationapp WHERE nickname='" + nickname + "';");
            ResultSet resultSet = statement.getResultSet();
            if (resultSet.next()) {
                String s = resultSet.getString("passsword");
                return s;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public static void addUser(String nickname, String password) {

        try (Connection connection = connectToDatabase()) {

            String s = "insert into registrationapp(nickname,passsword) values('" + nickname + "','" + password + "');";
            Statement statement = connection.createStatement();
            statement.execute(s);

        } catch (Exception ex) {

            ex.printStackTrace();

        }
    }


    private static Connection connectToDatabase() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        com.mysql.cj.jdbc.Driver s;
        String url = "jdbc:mysql://localhost:3306/gameapplication";
        String username = "root";
        String password = "ugur2003";

        return DriverManager.getConnection(url, username, password);

    }

}



