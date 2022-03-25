package com.example.jchat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

// local classes
import com.example.jchat.MainApplication;

public class PreScreenController {

    @FXML
    private Label welcomeText;
    private Button submit;
    private Button createAccount;


    @FXML
    protected void onSubmitClick() {
        System.out.println("You pressed me!");

    }


    @FXML
    protected void onCreateAccountClick() {
        MainApplication.mainStage.setScene(MainApplication.signUpScene);
        MainApplication.mainStage.show();
    }

    @FXML
    protected void onSignUpClick() {
        System.out.println("User tried to sign up");
    }


}