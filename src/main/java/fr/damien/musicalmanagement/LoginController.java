package fr.damien.musicalmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {

    @FXML
    private TextField emailText;

    @FXML
    private TextField passwordText;

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
    void loginConnection(ActionEvent event) {
        String emailUser = emailText.getText();
        String password = passwordText.getText();

        Alert message = new Alert(Alert.AlertType.INFORMATION);
        if (emailUser.equals("devoti.damien@gmail.com") && password.equals("12345")) {

        }
    }

    @FXML
    void resetPassword(ActionEvent event) {

    }

}