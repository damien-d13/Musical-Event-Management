package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.utils.DatabaseConnection;

import java.sql.ResultSet;

public class UserRepository {


    public static ResultSet findUser() {

        String FIND_USER_SQL = "SELECT user_email, user_password FROM t_user ";

        try {

            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(FIND_USER_SQL);
//            while (rs.next()) {
//                rs.getString("user_email");
//                rs.getString("user_password");
//            }
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Repository");
        }

        return null;
    }

}
