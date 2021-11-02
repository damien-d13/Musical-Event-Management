package fr.damien.musicalmanagement.controller;

import fr.damien.musicalmanagement.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailText;

    @FXML
    private PasswordField passwordText;


    @FXML
    private Hyperlink createAccount;

    @FXML
    private Hyperlink forgetPassword;

    @FXML
    private Button btnConnection;

    @FXML
    void createAccount(ActionEvent event) {

    }

    @FXML
    void loginConnection(ActionEvent event) throws IOException {
        String emailUser = emailText.getText();
        String password = passwordText.getText();

        Alert message = new Alert(Alert.AlertType.ERROR);
        if (emailUser.equals("damien@gmail.com") && password.equals("12345")) {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home.fxml"));
            Parent root = fxmlLoader.load();

            HomeController homeController = fxmlLoader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Home");
            stage.show();

        }else {

            message.setContentText("Invalid Login Details");
            message.setTitle("Error");
            message.show();
        }
    }

    @FXML
    void resetPassword(ActionEvent event) {

    }

}