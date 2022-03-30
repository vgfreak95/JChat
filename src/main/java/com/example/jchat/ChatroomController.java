package com.example.jchat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

// local classes
import com.example.jchat.MainApplication;
import com.example.jchat.DashboardController;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

public class ChatroomController extends DashboardController {

    @FXML
//    private Pane pane;
    private ScrollPane scrollPane;

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
