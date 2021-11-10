package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.entity.Address;
import fr.damien.musicalmanagement.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRepository {

    public ObservableList<Address> getAddressList() {
    ObservableList<Address> addressObservableList = FXCollections.observableArrayList();

    String SQL_ADDRESS = "CALL all_address();";
    try {
        ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_ADDRESS);

        while (rs.next()) {
            Address address = new Address(rs.getInt("address_id"), rs.getString("address_label"));
            addressObservableList.add(address);
        }

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error in Address Repository");
    }

        return addressObservableList;
    }
}
