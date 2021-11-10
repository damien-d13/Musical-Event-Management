package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.entity.Address;
import fr.damien.musicalmanagement.entity.Group;
import fr.damien.musicalmanagement.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.LinkedList;

public class GroupRepository {


    private static LinkedList<String> groupList = new LinkedList<>();

    public static LinkedList<String> getGroupList() {

        String SQL_GROUP = "CALL all_group();";
        System.out.println("yooo");
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_GROUP);


            while (rs.next()) {
                String group = rs.getString("group_label");
                System.out.println(group);
                groupList.add(group);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Address Repository");
        }

        return groupList;
    }

    public static ObservableList<Group> getGroupObservableList() {
        ObservableList<Group> groupObservableList = FXCollections.observableArrayList();

        String SQL_GROUP = "CALL all_group();";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_GROUP);

            while (rs.next()) {
                Group group = new Group(rs.getInt("group_id"), rs.getString("group_label"));
                System.out.println(group);
                groupObservableList.add(group);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Address Repository");
        }

        return groupObservableList;
    }


}
