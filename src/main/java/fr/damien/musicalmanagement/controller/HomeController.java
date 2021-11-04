package fr.damien.musicalmanagement.controller;

import fr.damien.musicalmanagement.MainApplication;
import fr.damien.musicalmanagement.repository.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeController {

    @FXML
    private Label UserName;

    @FXML
    private Button btnLogout;

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
}
