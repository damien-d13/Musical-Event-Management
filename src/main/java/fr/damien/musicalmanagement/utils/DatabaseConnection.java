package fr.damien.musicalmanagement.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static Connection databaseLink;

    public static Connection getConnection() {
        String db = "musical_event_manager_db";
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/" + db;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, user, password);
            System.out.println("Connecté !!!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur de connexion");
        }

        return databaseLink;
    }
}
