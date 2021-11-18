package fr.damien.musicalmanagement.repository;

import fr.damien.musicalmanagement.entity.Address;
import fr.damien.musicalmanagement.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

import java.util.LinkedList;

public class AddressRepository {

    private static LinkedList<String> addressList = new LinkedList<>();

    public static LinkedList<String> getAddressList() {

        String SQL_ADDRESS = "CALL all_address();";

        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_ADDRESS);

            while (rs.next()) {
                String address = rs.getString("address_label");
                addressList.add(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Address Repository");
        }

        return addressList;
    }

    public static ObservableList<Address> getAddressObservableList() {
        ObservableList<Address> addressObservableList = FXCollections.observableArrayList();

        String SQL_ADDRESS = "CALL all_address();";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_ADDRESS);

            while (rs.next()) {
                Address address = new Address(rs.getInt("address_id"), rs.getString("address_label"));
//                System.out.println(address);
                addressObservableList.add(address);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Address Repository");
        }

        return addressObservableList;
    }

    public static ObservableList<Address> getCountryObservableList() {
        ObservableList<Address> addressObservableList = FXCollections.observableArrayList();

        String SQL_ADDRESS = "CALL all_address();";
        try {
            ResultSet rs = DatabaseConnection.getConnection().createStatement().executeQuery(SQL_ADDRESS);

            while (rs.next()) {
                Address address = new Address(rs.getInt("address_id"), rs.getString("address_country"));
//                System.out.println(address);
                addressObservableList.add(address);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in Address Repository");
        }

        return addressObservableList;
    }


}
