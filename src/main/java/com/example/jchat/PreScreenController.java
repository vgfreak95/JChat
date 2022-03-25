package com.example.jchat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PreScreenController {

    @FXML
    private Label welcomeText;
    private Button submit;
    private Button signup;

    @FXML
    protected void onSubmitClick() {
        System.out.println("You pressed me!");
    }


    @FXML
    protected void onSignUpClick() {
        System.out.println("Signup was pressed");
    }


}