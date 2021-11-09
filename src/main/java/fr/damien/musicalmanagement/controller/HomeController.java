package fr.damien.musicalmanagement.controller;

import fr.damien.musicalmanagement.MainApplication;
import fr.damien.musicalmanagement.repository.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Label UserName;

    @FXML
    private Button btnLogout;

    @FXML
    private ComboBox<?> boxTitle;

    @FXML
    private ComboBox<?> boxGroup;

    @FXML
    private ComboBox<?> boxSpeciality;

    @FXML
    private ComboBox<?> boxMeet;

    @FXML
    private ComboBox<?> boxCountry;

    @FXML
    private ComboBox<?> boxInstrument;

    @FXML
    private ComboBox<?> boxAddress;

    @FXML
    private TextField boxTime;

    @FXML
    private Button searchGroup;

    @FXML
    private Button searchMeet;

    @FXML
    private Button searchUser;

    @FXML
    private Button SearchTitle;

    @FXML
    private TextField boxNbGroup;

    @FXML
    private Button searchMeetNbGroup;

    @FXML
    private Button searchMeetInstru;

    @FXML
    private Button searchProgamAddressGroup;


    @FXML
    void searchGroup(ActionEvent event) {

    }

    @FXML
    void searchMeetByInstrument(ActionEvent event) {

    }

    @FXML
    void searchMeetByNbGroup(ActionEvent event) {

    }

    @FXML
    void searchMeetByTitleGroup(ActionEvent event) {

    }

    @FXML
    void searchProgramByAddressGroup(ActionEvent event) {

    }

    @FXML
    void searchTitleByDurationCountry(ActionEvent event) {

    }

    @FXML
    void searchUserBySpecMeet(ActionEvent event) {

    }


    @FXML
    void logoutConnection(ActionEvent event) throws IOException {

        btnLogout.getScene().getWindow().hide();

        //Show login interface
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login.fxml"));
        Parent root = fxmlLoader.load();


        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Home");
        stage.show();

    }


    public void showUser(String userEmail) throws SQLException {
        System.out.println(userEmail);
        ResultSet rs = UserRepository.findUserInfo(userEmail);

        if (rs.next()) {
            UserName.setText(rs.getString("user_firstname"));
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
