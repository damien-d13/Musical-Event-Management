package fr.damien.musicalmanagement.controller;

import fr.damien.musicalmanagement.MainApplication;
import fr.damien.musicalmanagement.entity.Address;
import fr.damien.musicalmanagement.entity.Group;
import fr.damien.musicalmanagement.entity.Program;
import fr.damien.musicalmanagement.repository.AddressRepository;
import fr.damien.musicalmanagement.repository.GroupRepository;
import fr.damien.musicalmanagement.repository.ProgramRepository;
import fr.damien.musicalmanagement.repository.UserRepository;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private Label UserName;

    @FXML
    private Button btnLogout;

    @FXML
    private ComboBox<?> boxTitleGroup;

    @FXML
    private ComboBox<?> boxTitle;

    @FXML
    private ComboBox<?> boxMeetGroup;

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
    private ComboBox<?> boxGroup;

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
    private TableView<?> tableViewProgram;

    @FXML
    private TableColumn<?, ?> programGroup;

    @FXML
    private TableColumn<?, ?> programSong;

    @FXML
    private TableColumn<?, ?> programMeet;

    @FXML
    private TableColumn<?, ?> programDate;

    @FXML
    private TableColumn<?, ?> programTimeStart;

    @FXML
    private TableColumn<?, ?> programTimeEnd;

    @FXML
    private TableView<?> tableViewTitleSong;

    @FXML
    private TableColumn<?, ?> TitleSong;

    @FXML
    private TableColumn<?, ?> SongDate;

    @FXML
    private TableColumn<?, ?> SongDuration;

    @FXML
    private TableView<?> tableViewGroup;

    @FXML
    private TableColumn<?, ?> programGroup11;

    @FXML
    private TableColumn<?, ?> programSong11;

    @FXML
    private TableView<?> tableViewMeet;

    @FXML
    private TableColumn<?, ?> meetName;

    @FXML
    private TableColumn<?, ?> meetDateStart;

    @FXML
    private TableColumn<?, ?> meetDateStop;

    @FXML
    private TableColumn<?, ?> meetPeriodicity;

    @FXML
    private TableColumn<?, ?> meetNbCustomer;

    @FXML
    private TableColumn<?, ?> meetAddress;

    @FXML
    private TableColumn<?, ?> meetOrganizer;

    @FXML
    private TableView<?> tableViewUserBySpecialityMeet;

    @FXML
    private TableColumn<?, ?> userFirstname;

    @FXML
    private TableColumn<?, ?> userLastname;

    @FXML
    private TableColumn<?, ?> UserBirthday;

    @FXML
    private TableColumn<?, ?> userEmail;

    @FXML
    private TableColumn<?, ?> userPhone;

    @FXML
    private TableColumn<?, ?> userFax;


    @FXML
    void searchProgramByAddressGroup(ActionEvent event) {

        int addressId;
        int groupId;



        if (!boxAddress.getSelectionModel().isEmpty() && !boxGroup.getSelectionModel().isEmpty()) {
            addressId = boxAddress.getSelectionModel().getSelectedItem().getId();
            System.out.println(boxAddress.getSelectionModel().getSelectedItem().getId());

            groupId = boxGroup.getSelectionModel().getSelectedItem().getId();
            System.out.println(boxGroup.getSelectionModel().getSelectedItem().getId());

            System.out.println(ProgramRepository.getProgramObservableList(groupId, addressId));



            ObservableList<Program> list = ProgramRepository.getProgramObservableList(groupId, addressId);


            programGroup.setCellValueFactory(new PropertyValueFactory<Program, Integer>("groupId"));
            programSong.setCellValueFactory(new PropertyValueFactory<Program, Integer>("songId"));
            programMeet.setCellValueFactory(new PropertyValueFactory<Program, Integer>("meetId"));
            programDate.setCellValueFactory(new PropertyValueFactory<Program, Date>("programDate"));
            programTimeStart.setCellValueFactory(new PropertyValueFactory<Program, Time>("programTimeStart"));
            programTimeEnd.setCellValueFactory(new PropertyValueFactory<Program, Time>("programTimeStop"));

            tableViewProgram.setItems(list);


        }







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

    public void showAllAddress() {

//        boxAddress.getItems().addAll(AddressRepository.getAddressList());

        boxAddress.setItems(AddressRepository.getAddressObservableList());
    }

    public void showAllGroup() {
//        boxGroup.getItems().addAll(GroupRepository.getGroupList());
        boxGroup.setItems(GroupRepository.getGroupObservableList());
    }

    public void showProgramByGroupAddress() {



    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        showAllAddress();
        showAllGroup();

    }

}
