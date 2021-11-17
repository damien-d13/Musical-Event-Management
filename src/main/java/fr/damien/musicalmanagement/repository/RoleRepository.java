package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.entity.Role;
import fr.damien.musicalmanagement.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class RoleRepository {

    public static ObservableList<Role> allRoleObservableList() {
        ObservableList<Role> allRoleObservableList = FXCollections.observableArrayList();


        String SQL_ROLE = "CALL all_role();";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_ROLE);

            while (rs.next()) {
                Role role = new Role(rs.getInt("role_id"), rs.getString("role_label") );
                System.out.println(role);
                allRoleObservableList.add(role);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Role Repository");
        }

        return allRoleObservableList;
    }
}
