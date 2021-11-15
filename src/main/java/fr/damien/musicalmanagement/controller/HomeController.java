package fr.damien.musicalmanagement.controller;

import fr.damien.musicalmanagement.MainApplication;
import fr.damien.musicalmanagement.entity.*;
import fr.damien.musicalmanagement.repository.*;
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
    private ComboBox<Song> boxTitleGroup;

    @FXML
    private ComboBox<Song> boxTitle;

    @FXML
    private ComboBox<Group> boxMeetGroup;

    @FXML
    private ComboBox<Speciality> boxSpeciality;

    @FXML
    private ComboBox<Meet> boxMeet;

    @FXML
    private ComboBox<?> boxCountry;

    @FXML
    private ComboBox<?> boxInstrument;

    @FXML
    private ComboBox<Address> boxAddress;

    @FXML
    private ComboBox<Group> boxGroup;

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
    private TableView<Program> tableViewProgram;

    @FXML
    private TableColumn<Program, Integer> programGroup;

    @FXML
    private TableColumn<Program, Integer> programSong;

    @FXML
    private TableColumn<Program, Integer> programMeet;

    @FXML
    private TableColumn<Program, Date> programDate;

    @FXML
    private TableColumn<Program, Time> programTimeStart;

    @FXML
    private TableColumn<Program, Time> programTimeEnd;

    @FXML
    private TableView<?> tableViewTitleSong;

    @FXML
    private TableColumn<?, ?> TitleSong;

    @FXML
    private TableColumn<?, ?> SongDate;

    @FXML
    private TableColumn<?, ?> SongDuration;

    @FXML
    private TableView<Group> tableViewGroup;

    @FXML
    private TableColumn<Group, String> songGroup;

    @FXML
    private TableColumn<Group, String> songCharacteristic;

    @FXML
    private TableView<Meet> tableViewMeet;

    @FXML
    private TableColumn<Meet, String> meetName;

    @FXML
    private TableColumn<Meet, Date> meetDateStart;

    @FXML
    private TableColumn<Meet, Date> meetDateStop;

    @FXML
    private TableColumn<Meet, String> meetPeriodicity;

    @FXML
    private TableColumn<Meet, Integer> meetNbCustomer;

    @FXML
    private TableColumn<Meet, Integer> meetAddress;

    @FXML
    private TableColumn<Meet, Integer> meetOrganizer;

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

    private int nbVisible;
    private int songId;
    private int addressId;
    private int groupId;



    @FXML
    public void searchGroup(ActionEvent actionEvent) {

        if (!boxTitleGroup.getSelectionModel().isEmpty()) {



            nbVisible = 1;
            hideTableView(nbVisible);


            songId = boxTitleGroup.getSelectionModel().getSelectedItem().getId();
            System.out.println(boxTitleGroup.getSelectionModel().getSelectedItem().getId());


            System.out.println(GroupRepository.getGroupBySongObservableList(songId));



            ObservableList<Group> list = GroupRepository.getGroupBySongObservableList(songId);


            songGroup.setCellValueFactory(new PropertyValueFactory<Group, String>("label"));
            songCharacteristic.setCellValueFactory(new PropertyValueFactory<Group, String>("characteristic"));


            tableViewGroup.setItems(list);


        }

    }

    @FXML
    void searchProgramByAddressGroup(ActionEvent event) {

        nbVisible = 2;
        hideTableView(nbVisible);



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
    public void searchMeetByTitleGroup(ActionEvent actionEvent) {

        if (!boxTitle.getSelectionModel().isEmpty() && !boxMeetGroup.getSelectionModel().isEmpty()) {



            nbVisible = 4;
            hideTableView(nbVisible);


            songId = boxTitle.getSelectionModel().getSelectedItem().getId();
            System.out.println(songId);
            System.out.println("TEST 1");

            groupId = boxMeetGroup.getSelectionModel().getSelectedItem().getId();

            System.out.println(MeetRepository.getMeetBySongGroupObservableList(groupId,songId));



            ObservableList<Meet> list = MeetRepository.getMeetBySongGroupObservableList(groupId, songId);


            meetName.setCellValueFactory(new PropertyValueFactory<Meet, String>("Label"));
            meetDateStart.setCellValueFactory(new PropertyValueFactory<Meet, Date>("dateStart"));
            meetDateStop.setCellValueFactory(new PropertyValueFactory<Meet, Date>("dateStop"));
            meetPeriodicity.setCellValueFactory(new PropertyValueFactory<Meet, String>("periodicity"));
            meetNbCustomer.setCellValueFactory(new PropertyValueFactory<Meet, Integer>("nbCustomerExpected"));
            meetAddress.setCellValueFactory(new PropertyValueFactory<Meet, Integer>("addressId"));
            meetOrganizer.setCellValueFactory(new PropertyValueFactory<Meet, Integer>("userId"));

            tableViewMeet.setItems(list);

        }

    }
    @FXML
    void searchUserBySpecMeet(ActionEvent event) {

    }

    @FXML
    void searchTitleByDurationCountry(ActionEvent event) {

    }






    public void searchMeetByNbGroup(ActionEvent actionEvent) {
    }

    public void searchMeetByInstrument(ActionEvent actionEvent) {
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
        boxMeetGroup.setItems(GroupRepository.getGroupObservableList());
    }

    public void showAllTitle() {
        boxTitleGroup.setItems(SongRepository.getSongObservableList());
        boxTitle.setItems(SongRepository.getSongObservableList());
    }

    public void showAllSpeciality() {
        boxSpeciality.setItems(SpecialityRepository.getAllSpecialityObservableList());
    }

    public void showProgramByGroupAddress() {



    }

    public void showAllMeet() {
        boxMeet.setItems(MeetRepository.getAllMeetObservableList());
    }


    public void hideTableView(int nbVisible) {

        tableViewGroup.setVisible(false);
        tableViewProgram.setVisible(false);
        tableViewTitleSong.setVisible(false);
        tableViewMeet.setVisible(false);
        tableViewUserBySpecialityMeet.setVisible(false);


        switch (nbVisible) {
            case 1:
                tableViewGroup.setVisible(true);
            break;
            case 2:
                tableViewProgram.setVisible(true);
            break;
            case 3:
                tableViewTitleSong.setVisible(true);
            break;
            case 4:
                tableViewMeet.setVisible(true);
                break;
            case 5:
                tableViewUserBySpecialityMeet.setVisible(true);
            break;


        }


    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        showAllAddress();
        showAllGroup();
        showAllTitle();
        showAllSpeciality();
        showAllMeet();

    }
}
