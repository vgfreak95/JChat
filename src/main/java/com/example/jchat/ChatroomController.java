package com.example.jchat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

// local classes
import com.example.jchat.MainApplication;
import com.example.jchat.DashboardController;
import com.example.jchat.User;
import javafx.scene.layout.Pane;

public class ChatroomController extends DashboardController {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private ListView listView;

    @FXML
    private TextField message_field;


    @FXML
    public void sendMessage() {
        listView.getItems().add(User.username + ": " + message_field.getText());
        message_field.clear();
        message_field.requestFocus();
        listView.scrollTo(listView.getItems().size()-1);
    }

    @FXML
    public void onScrollUp() {
        System.out.println(scrollPane.getChildrenUnmodifiable());
//        double currentValue = pane.scrollPane.getVvalue();
//        System.out.println(currentValue);
//        if (currentValue > 0) {
//            scrollPane.setVvalue(currentValue - 0.1f);
//        }
    }

    @FXML
    public void onScrollDown() {
//        double currentValue = scrollPane.getVvalue();
//        System.out.println(currentValue);
//        if (currentValue < 1) {
//            scrollPane.setVvalue(currentValue + 0.1f);
//        }

    }

}
