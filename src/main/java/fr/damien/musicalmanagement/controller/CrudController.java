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
import javafx.util.converter.DateTimeStringConverter;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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
    private TableColumn<User, String> tabPassword;

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
    private TextField textPassword;

    @FXML
    private DatePicker textBirthday;

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

    private int id;
    private String firstname;
    private String lastname;
    private String password;
    private LocalDate localDateBirthday;
    private Date birthDay;
    private String email;
    private String phone;
    private String fax;
    private int civility;
    private int role;
    private int responsibility;


    public  void getInput() {


        this.firstname = textFirstname.getText();
        this.lastname = textLastname.getText();
        this.birthDay = java.sql.Date.valueOf(textBirthday.getValue());
//        Instant instant = Instant.from(localDateBirthday.atStartOfDay(ZoneId.systemDefault()));
//        this.birthday = Date.from(instant);

//        System.out.println(this.birthDay);
        this.email= textEmail.getText();
        this.phone = textPhone.getText();
        this.fax = textFax.getText();
        this.password = textPassword.getText();
        this.civility = boxCivility.getSelectionModel().getSelectedItem().getId();
        this.role = boxRole.getSelectionModel().getSelectedItem().getId();
        this.responsibility = boxResponsibility.getSelectionModel().getSelectedItem().getId();
    }


    @FXML
    void addUser(ActionEvent event) {

        getInput();

        User newUser = new User(firstname, lastname, password, birthDay, email, phone, fax, role, civility, responsibility);

        UserRepository userRepository = new UserRepository();
        userRepository.insertRecord(newUser);
        showUser();

    }

    @FXML
    void deleteUser(ActionEvent event) {

        User user = tableViewUser.getSelectionModel().getSelectedItem();
//        System.out.println("test");
//        System.out.println(user + "test1");
        UserRepository userRepository = new UserRepository();
        userRepository.deleteRecord(user.getId());
//        System.out.println(user.getId() + "test2");
        showUser();

    }

    @FXML
    void updateUser(ActionEvent event) {

        getInput();
        this.id = tableViewUser.getSelectionModel().getSelectedItem().getId();
//        User selectId = tableViewUser.getSelectionModel().getSelectedItem();

//        System.out.println(password);

        User editUser = new User(id, firstname, lastname, password, birthDay, email, phone, fax, role, civility, responsibility);

        UserRepository userRepository = new UserRepository();

//        System.out.println(editUser);
        userRepository.updateRecord(editUser);
        showUser();

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
//
//    public void formatTextDate() throws ParseException {
//        SimpleDateFormat format = new SimpleDateFormat("AAAA/MM/JJ");
//        textBirthday.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("0000/00/00")));
//    }

    public void showUser() {
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
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        showUser();
        showRole();
        showCivility();
        showResponsibility();
//        try {
//            formatTextDate();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
    }

}

