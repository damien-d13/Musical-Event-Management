package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.utils.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {


    public static ResultSet findUserLogin() {

//        String FIND_USER_SQL = "SELECT user_email, user_password FROM t_user ";
        String FIND_USER_SQL = "CALL login();";

        try {

            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(FIND_USER_SQL);

            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in User Repository (findUserLogin) ");
        }

        return null;
    }

    public static ResultSet findUserInfo(String userEmail)  {

//        String FIND_USER_INFO_SQL = "SELECT user_firstname FROM t_user WHERE user_email = '" + userEmail + "';";
        String FIND_USER_INFO_SQL = "CALL find_user_info('userEmail');";
        ResultSet rs = null;

        try {


            rs = DatabaseConnection.getConnection().createStatement().executeQuery(FIND_USER_INFO_SQL);


        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in User Repository (findUserInfo)");
        }
        return rs;
    }

}
