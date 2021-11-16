package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.entity.Group;
import fr.damien.musicalmanagement.entity.Song;
import fr.damien.musicalmanagement.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;

public class SongRepository {

    public static ObservableList<Song> getSongObservableList() {
        ObservableList<Song> songObservableList = FXCollections.observableArrayList();

        String SQL_SONG = "CALL all_song();";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_SONG);

            while (rs.next()) {
                Song song = new Song(rs.getInt("song_id"), rs.getString("song_title"), rs.getDate("song_date"), rs.getTime("song_duration"));
//                System.out.println(song);
                songObservableList.add(song);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Song Repository");
        }

        return songObservableList;
    }

    public static ObservableList<Song> getSongByAddressTimeObservableList(int addressid, LocalTime timeValue) {
        System.out.println(addressid + " test");
        ObservableList<Song> songObservableList = FXCollections.observableArrayList();

        String SQL_SONG_TIME_LOC = "CALL find_song_with_time_location("+ addressid + ",'" + timeValue +"');";
        System.out.println(SQL_SONG_TIME_LOC);
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_SONG_TIME_LOC);

            while (rs.next()) {
                Song song = new Song(rs.getString("song_title"), rs.getDate("song_date"), rs.getTime("song_duration"));
                System.out.println(song);
                songObservableList.add(song);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Song Repository");
        }

        return songObservableList;
    }

}
