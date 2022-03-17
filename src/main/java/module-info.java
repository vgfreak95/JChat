module com.example.jchat {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jchat to javafx.fxml;
    exports com.example.jchat;
}