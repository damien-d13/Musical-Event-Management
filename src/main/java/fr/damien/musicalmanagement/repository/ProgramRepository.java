package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.entity.Address;
import fr.damien.musicalmanagement.entity.Program;
import fr.damien.musicalmanagement.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class ProgramRepository {

    public static ObservableList<Program> getProgramObservableList(int group, int address) {
        ObservableList<Program> programObservableList = FXCollections.observableArrayList();

        String SQL_PROGRAM_ADDRESS_ = "CALL find_program_by_group_address(" + group + "," + address + ");";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_PROGRAM_ADDRESS_);

            while (rs.next()) {
                Program program = new Program(rs.getInt("group_id"), rs.getInt("song_id"), rs.getInt("meet_id"), rs.getDate("program_date"), rs.getTime("program_time_start"), rs.getTime("program_time_stop"));
//                System.out.println(program);
                programObservableList.add(program);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Address Repository");
        }

        return programObservableList;
    }
}
