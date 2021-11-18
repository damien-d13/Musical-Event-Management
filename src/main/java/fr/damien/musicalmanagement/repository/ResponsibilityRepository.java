package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.entity.Civility;
import fr.damien.musicalmanagement.entity.Responsibility;
import fr.damien.musicalmanagement.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class ResponsibilityRepository {

    public static ObservableList<Responsibility> allResponsibilityObservableList() {
        ObservableList<Responsibility> allResponsibilityObservableList = FXCollections.observableArrayList();


        String SQL_RESPONSIBILITY = "CALL all_Responsibility();";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_RESPONSIBILITY);

            while (rs.next()) {
                Responsibility responsibility = new Responsibility(rs.getInt("responsibility_id"), rs.getString("responsibility_label") );
//                System.out.println(responsibility);
                allResponsibilityObservableList.add(responsibility);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Civility Repository");
        }

        return allResponsibilityObservableList;
    }
}
