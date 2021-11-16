package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.entity.Meet;
import fr.damien.musicalmanagement.entity.User;
import fr.damien.musicalmanagement.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    public static ObservableList<User> getUserBySpecMeetObservableList(int specialityId, int meetId) {
        ObservableList<User> userBySpecMeetObservableList = FXCollections.observableArrayList();


        String SQL_USER_SPEC_MEET = "CALL find_user_with_meet_spe(" + meetId  + "," + specialityId + ");";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_USER_SPEC_MEET);

            while (rs.next()) {
                User user = new User(rs.getString("user_firstname"), rs.getString("user_lastname"), rs.getDate("user_birth_day"), rs.getString("user_email"), rs.getString("user_phone"), rs.getString("user_fax"));
                System.out.println(user);
                userBySpecMeetObservableList.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in User Repository");
        }

        return userBySpecMeetObservableList;
    }

}
