package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.entity.Address;
import fr.damien.musicalmanagement.entity.Meet;
import fr.damien.musicalmanagement.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class MeetRepository {

    public static ObservableList<Meet> getMeetBySongGroupObservableList(int groupId, int songId) {
        ObservableList<Meet> meetSGObservableList = FXCollections.observableArrayList();

        String SQL_MEET_BY_SONG_GROUP = "CALL find_meet_by_song_group(" + groupId + "," + songId + ");";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_MEET_BY_SONG_GROUP);

            while (rs.next()) {
                Meet meet = new Meet(rs.getInt("meet_id"), rs.getString("meet_label"), rs.getDate("meet_date_start"), rs.getDate("meet_date_stop"), rs.getString("meet_periodicity"), rs.getInt("meet_nb_customers_expected"), rs.getInt("address_id"), rs.getInt("user_id") );
                System.out.println(meet);
                meetSGObservableList.add(meet);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Meet Repository");
        }

        return meetSGObservableList;
    }

    public static ObservableList<Meet> getMeetByNbGroupObservableList(int nbGroup) {
        ObservableList<Meet> meetNbGObservableList = FXCollections.observableArrayList();


        String SQL_MEET_BY_NB_GROUP = "CALL find_meet_by_nb_group(" +  nbGroup + ");";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_MEET_BY_NB_GROUP);

            while (rs.next()) {
                Meet meet = new Meet(rs.getInt("meet_id"), rs.getString("meet_label"), rs.getDate("meet_date_start"), rs.getDate("meet_date_stop"), rs.getString("meet_periodicity"), rs.getInt("meet_nb_customer"), rs.getInt("address_id"), rs.getInt("user_id") );
                System.out.println(meet);
                meetNbGObservableList.add(meet);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Meet Repository");
        }

        return meetNbGObservableList;
    }

    public static ObservableList<Meet> getMeetByInstrumentObservableList(int instrumentId) {
        ObservableList<Meet> meetInstrumentObservableList = FXCollections.observableArrayList();


        String SQL_MEET_BY_INSTRUMENT = "CALL find_meet_by_instrument(" +  instrumentId +");";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_MEET_BY_INSTRUMENT);

            while (rs.next()) {
                Meet meet = new Meet(rs.getInt("meet_id"), rs.getString("meet_label"), rs.getDate("meet_date_start"), rs.getDate("meet_date_stop"), rs.getString("meet_periodicity"), rs.getInt("meet_nb_customer"), rs.getInt("address_id"), rs.getInt("user_id") );
                System.out.println(meet);
                meetInstrumentObservableList.add(meet);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Meet Repository");
        }

        return meetInstrumentObservableList;
    }

    public static ObservableList<Meet> getAllMeetObservableList() {
        ObservableList<Meet> meetAllObservableList = FXCollections.observableArrayList();


        String SQL_MEET = "CALL all_meet();";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_MEET);

            while (rs.next()) {
                Meet meet = new Meet(rs.getInt("meet_id"), rs.getString("meet_label"));
                System.out.println(meet);
                meetAllObservableList.add(meet);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Meet Repository");
        }

        return meetAllObservableList;
    }


}
