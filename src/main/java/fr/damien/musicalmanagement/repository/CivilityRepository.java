package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.entity.Civility;
import fr.damien.musicalmanagement.entity.Role;
import fr.damien.musicalmanagement.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class CivilityRepository {

    public static ObservableList<Civility> allCivilityObservableList() {
        ObservableList<Civility> allcivilityObservableList = FXCollections.observableArrayList();


        String SQL_CIVILITY = "CALL all_civility();";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_CIVILITY);

            while (rs.next()) {
                Civility civility = new Civility(rs.getInt("civility_id"), rs.getString("civility_label") );
                System.out.println(civility);
                allcivilityObservableList.add(civility);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Civility Repository");
        }

        return allcivilityObservableList;
    }
}
