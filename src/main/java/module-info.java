module fr.damien.musicalmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens fr.damien.musicalmanagement to javafx.fxml;
    opens fr.damien.musicalmanagement.entity to javafx.base;
    exports fr.damien.musicalmanagement;
    exports fr.damien.musicalmanagement.controller;
    opens fr.damien.musicalmanagement.controller to javafx.fxml;
}