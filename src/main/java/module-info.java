module com.example.jchat {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;
    requires java.desktop;

    opens com.example.jchat to javafx.fxml;
    exports com.example.jchat;
}
