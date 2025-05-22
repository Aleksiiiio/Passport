module pl.gornik.passport {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.gornik.passport to javafx.fxml;
    exports pl.gornik.passport;
}