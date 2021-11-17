package fr.damien.musicalmanagement.controller;

import fr.damien.musicalmanagement.entity.Civility;
import fr.damien.musicalmanagement.entity.Responsibility;
import fr.damien.musicalmanagement.entity.Role;
import fr.damien.musicalmanagement.entity.User;
import fr.damien.musicalmanagement.repository.CivilityRepository;
import fr.damien.musicalmanagement.repository.ResponsibilityRepository;
import fr.damien.musicalmanagement.repository.RoleRepository;
import fr.damien.musicalmanagement.repository.UserRepository;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class CrudController implements Initializable {

    @FXML
    private Label userName;

    @FXML
    private TableView<User> tableViewUser;
    @FXML
    private TableColumn<User, String> tabFirstname;

    @FXML
    private TableColumn<User, String> tabLastname;

    @FXML
    private TableColumn<User, Date> tabBirthday;

    @FXML
    private TableColumn<User, String> tabEmail;

    @FXML
    private TableColumn<User, String> tabPhone;

    @FXML
    private TableColumn<User, String> tabFax;

    @FXML
    private TableColumn<User, Integer> tabRole;

    @FXML
    private TableColumn<User, Integer> tabCivility;

    @FXML
    private TableColumn<User, Integer> tabResponsibility;

    @FXML
    private TextField textFirstname;

    @FXML
    private TextField textLastname;

    @FXML
    private TextField textBirthday;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textPhone;

    @FXML
    private TextField textFax;

    @FXML
    private ComboBox<Role> boxRole;

    @FXML
    private ComboBox<Civility> boxCivility;

    @FXML
    private ComboBox<Responsibility> boxResponsibility;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;


    @FXML
    void addUser(ActionEvent event) {

    }

    @FXML
    void deleteUser(ActionEvent event) {

    }

    @FXML
    void updateUser(ActionEvent event) {

    }

    public void showUser(String userNameHome) {
     userName.setText(userNameHome);

    }

    public void showRole() {
        boxRole.setItems(RoleRepository.allRoleObservableList());
    }

    public void showCivility() {

        boxCivility.setItems(CivilityRepository.allCivilityObservableList());

    }

    public void showResponsibility() {

        boxResponsibility.setItems(ResponsibilityRepository.allResponsibilityObservableList());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<User> list = UserRepository.getAllUserObservableList();


        tabFirstname.setCellValueFactory(new PropertyValueFactory<User, String>("firstname"));
        tabLastname.setCellValueFactory(new PropertyValueFactory<User, String>("lastname"));
        tabBirthday.setCellValueFactory(new PropertyValueFactory<User, Date>("birthDay"));
        tabEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
        tabPhone.setCellValueFactory(new PropertyValueFactory<User, String>("phone"));
        tabFax.setCellValueFactory(new PropertyValueFactory<User, String>("fax"));
        tabRole.setCellValueFactory(new PropertyValueFactory<User, Integer>("role_id"));
        tabCivility.setCellValueFactory(new PropertyValueFactory<User, Integer>("civility_id"));
        tabResponsibility.setCellValueFactory(new PropertyValueFactory<User, Integer>("responsibility_id"));

        tableViewUser.setItems(list);

        showRole();
        showCivility();
        showResponsibility();
    }

}

