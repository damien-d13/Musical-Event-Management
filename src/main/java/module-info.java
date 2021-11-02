module fr.damien.musicalmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.damien.musicalmanagement to javafx.fxml;
    exports fr.damien.musicalmanagement;
}