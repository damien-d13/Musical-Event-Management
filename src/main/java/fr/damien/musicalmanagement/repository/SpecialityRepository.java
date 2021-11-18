package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.entity.Meet;
import fr.damien.musicalmanagement.entity.Speciality;
import fr.damien.musicalmanagement.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class SpecialityRepository {

    public static ObservableList<Speciality> getAllSpecialityObservableList() {
        ObservableList<Speciality> specialitiesObservableList = FXCollections.observableArrayList();

        String SQL_SPECIALITY = "CALL all_speciality();";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_SPECIALITY);

            while (rs.next()) {
                Speciality speciality = new Speciality(rs.getInt("speciality_id"), rs.getString("speciality_label"));
//                System.out.println(speciality);
                specialitiesObservableList.add(speciality);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Speciality Repository");
        }

        return specialitiesObservableList;
    }
}
