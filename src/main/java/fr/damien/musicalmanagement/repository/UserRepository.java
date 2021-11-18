package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.entity.Meet;
import fr.damien.musicalmanagement.entity.User;
import fr.damien.musicalmanagement.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
//                System.out.println(user);
                userBySpecMeetObservableList.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in User Repository");
        }

        return userBySpecMeetObservableList;
    }


    public static ObservableList<User> getAllUserObservableList() {
        ObservableList<User> allUserObservableList = FXCollections.observableArrayList();


        String SQL_USER = "CALL all_user();";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_USER);

            while (rs.next()) {
                User user = new User(rs.getInt("user_id"),rs.getString("user_firstname"), rs.getString("user_lastname"), rs.getDate("user_birth_day"), rs.getString("user_email"), rs.getString("user_phone"), rs.getString("user_fax"), rs.getInt("role_id"), rs.getInt("civility_id"), rs.getInt("responsibility_id"));
//                System.out.println(user);
                allUserObservableList.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in User Repository");
        }

        return allUserObservableList;
    }

    public void insertRecord(User newUser) {

        String userFirstname = newUser.getFirstname();
        String userLastname = newUser.getLastname();
        Date userBirthday = (Date) newUser.getBirthDay();
        String userEmail = newUser.getEmail();
        String userPhone = newUser.getPhone();
        String userFax = newUser.getFax();
        String userPassword = newUser.getPassword();
        int userCivility = newUser.getCivility_id();
        int userRole = newUser.getRole_id();
        int userResponsibility = newUser.getResponsibility_id();

        try {
            String INSERT_QUERY = "INSERT INTO t_user(user_firstname, user_lastname, user_password, user_birth_day, user_email, user_phone, user_fax, role_id, civility_id, responsibility_id) VALUES " +
                    "('"+ userFirstname + "', '" + userLastname + "', '"+ userPassword +"', '" + userBirthday + "', '" + userEmail + "', '" + userPhone + "', '" + userFax + "','" + userRole + "', '" + userCivility +"', '" + userResponsibility +"') ";
            Statement statement = DatabaseConnection.getConnection().createStatement();
            statement.executeUpdate(INSERT_QUERY);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in User Insert Repository");
        }

    }

    public void updateRecord(User newUser) {
        int userId = newUser.getId();
        String userFirstname = newUser.getFirstname();
        String userLastname = newUser.getLastname();
        Date userBirthday = (Date) newUser.getBirthDay();
        String userEmail = newUser.getEmail();
        String userPhone = newUser.getPhone();
        String userFax = newUser.getFax();
        String userPassword = newUser.getPassword();
        int userCivility = newUser.getCivility_id();
        int userRole = newUser.getRole_id();
        int userResponsibility = newUser.getResponsibility_id();

        try {
            String UPDATE_QUERY = "UPDATE t_user SET user_firstname = '" + userFirstname + "', user_lastname =  '" + userLastname + "', user_password = '" + userPassword + "', user_email = '" + userEmail + "', user_birth_day = '" +  userBirthday + "', user_phone = '" + userPhone + "', user_fax = '"  + userFax + "', role_id = '" + userRole + "', civility_id = '" + userCivility + "', responsibility_id = '" + userResponsibility + "' WHERE user_id = " + userId + ";";
            Statement statement = DatabaseConnection.getConnection().createStatement();
            statement.executeUpdate(UPDATE_QUERY);
//            System.out.println(UPDATE_QUERY);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in User Update Repository");
        }

    }

    public void deleteRecord(int userId) {
        try {
            String DELETE_QUERY = "DELETE FROM t_user WHERE user_id = " + userId + ";";
            Statement statement = DatabaseConnection.getConnection().createStatement();
            statement.executeUpdate(DELETE_QUERY);
//            System.out.println(DELETE_QUERY);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in User Delete Repository");
        }
    }

}
