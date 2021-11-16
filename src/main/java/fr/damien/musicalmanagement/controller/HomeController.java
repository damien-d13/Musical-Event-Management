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
import javafx.util.converter.DateTimeStringConverter;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
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
    private ComboBox<Address> boxCountry;

    @FXML
    private ComboBox<Instrument> boxInstrument;

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
    private TableView<Song> tableViewTitleSong;

    @FXML
    private TableColumn<Song, String> titleSong;

    @FXML
    private TableColumn<Song, Date> songDate;

    @FXML
    private TableColumn<Song, Time> songDuration;

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
    private TableView<User> tableViewUserBySpecialityMeet;

    @FXML
    private TableColumn<User, String> userFirstname;

    @FXML
    private TableColumn<User, String> userLastname;

    @FXML
    private TableColumn<User, Date> userBirthday;

    @FXML
    private TableColumn<User, String> userEmail;

    @FXML
    private TableColumn<User, String> userPhone;

    @FXML
    private TableColumn<User, String> userFax;

    private int nbVisible;
    private int songId;
    private int addressId;
    private int groupId;
    private int specialityId;
    private int meetId;



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

        if (!boxSpeciality.getSelectionModel().isEmpty() && !boxMeet.getSelectionModel().isEmpty()) {



            nbVisible = 5;
            hideTableView(nbVisible);


            specialityId = boxSpeciality.getSelectionModel().getSelectedItem().getId();
            System.out.println(specialityId);


            meetId = boxMeet.getSelectionModel().getSelectedItem().getId();
            System.out.println(meetId);

            System.out.println(MeetRepository.getMeetBySongGroupObservableList(groupId,songId));



            ObservableList<User> list = UserRepository.getUserBySpecMeetObservableList(specialityId, meetId);


            userFirstname.setCellValueFactory(new PropertyValueFactory<User, String>("firstname"));
            userLastname.setCellValueFactory(new PropertyValueFactory<User, String>("lastname"));
            userBirthday.setCellValueFactory(new PropertyValueFactory<User, Date>("birthday"));
            userEmail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
            userPhone.setCellValueFactory(new PropertyValueFactory<User, String>("phone"));
            userFax.setCellValueFactory(new PropertyValueFactory<User, String>("fax"));


            tableViewUserBySpecialityMeet.setItems(list);

        }
    }

    @FXML
    void searchTitleByDurationCountry(ActionEvent event) {

        if (!boxTime.getText().trim().isEmpty() && !boxCountry.getSelectionModel().isEmpty()) {
            int countryId;
            String timeValue;
            nbVisible = 3;
            hideTableView(nbVisible);

            timeValue = boxTime.getText();
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:MM:SS");
            LocalTime timeMini = LocalTime.parse( timeValue) ;
            System.out.println(timeMini);

            countryId = boxCountry.getSelectionModel().getSelectedItem().getId();
            System.out.println(countryId);

            System.out.println(SongRepository.getSongByAddressTimeObservableList(countryId, timeMini));



            ObservableList<Song> list = SongRepository.getSongByAddressTimeObservableList(countryId, timeMini);


            titleSong.setCellValueFactory(new PropertyValueFactory<Song, String>("title"));
            songDate.setCellValueFactory(new PropertyValueFactory<Song, Date>("date"));
            songDuration.setCellValueFactory(new PropertyValueFactory<Song, Time>("duration"));



            tableViewTitleSong.setItems(list);

        }
    }






    public void searchMeetByNbGroup(ActionEvent actionEvent) {


        if (!boxNbGroup.getText().trim().isEmpty()) {



            nbVisible = 4;
            hideTableView(nbVisible);


            int nbGroup = Integer.parseInt(boxNbGroup.getText());
            System.out.println(nbGroup);
            System.out.println("TEST 2");


            System.out.println(MeetRepository.getMeetByNbGroupObservableList(nbGroup));



            ObservableList<Meet> list = MeetRepository.getMeetByNbGroupObservableList(nbGroup);


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

    public void showAllMeet() {
        boxMeet.setItems(MeetRepository.getAllMeetObservableList());
    }

    public void showAllSpeciality() {
        boxSpeciality.setItems(SpecialityRepository.getAllSpecialityObservableList());
    }

    public void showAllCountry() {
        boxCountry.setItems(AddressRepository.getCountryObservableList());
    }

    public void showAllInstrument() {
        boxInstrument.setItems(InstrumentRepository.allInstrumentObservableList());
    }

    public void showProgramByGroupAddress() {



    }


    public void formatTextTime() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        boxTime.setTextFormatter(new TextFormatter<>(new DateTimeStringConverter(format), format.parse("00:00:00")));
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
        showAllCountry();
        try {
            formatTextTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        showAllInstrument();

    }
}
