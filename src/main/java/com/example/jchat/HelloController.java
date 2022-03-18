package com.example.jchat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    private Button button;

    @FXML
    protected void onHelloButtonClick() {

        System.out.println("You pressed me!");
    }
}