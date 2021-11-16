package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.entity.Instrument;
import fr.damien.musicalmanagement.entity.Meet;
import fr.damien.musicalmanagement.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class InstrumentRepository {

    public static ObservableList<Instrument> allInstrumentObservableList() {
        ObservableList<Instrument> instrumentObservableList = FXCollections.observableArrayList();


        String SQL_INSTRUMENT = "CALL all_instrument();";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_INSTRUMENT);

            while (rs.next()) {
                Instrument instrument = new Instrument(rs.getInt("instrument_id"), rs.getString("instrument_label"));
                System.out.println(instrument);
                instrumentObservableList.add(instrument);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Meet Repository");
        }

        return instrumentObservableList;
    }
}
