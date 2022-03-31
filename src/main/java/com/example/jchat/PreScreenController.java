package com.example.jchat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

// local classes
import com.example.jchat.MainApplication;
import javafx.scene.control.TextField;
import com.example.jchat.SQLDriver;

import java.sql.Connection;
import java.sql.SQLException;

public class PreScreenController {

    @FXML
    private Label welcomeText;
    private Button login;
    private Button createAccount;

    @FXML
    private TextField user_signup_field;

    @FXML
    private TextField pass_signup_field;


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
    protected void onGoBackToSignInClick() {
        MainApplication.mainStage.setScene(MainApplication.loginScene);
        MainApplication.mainStage.show();
    }

    @FXML
    protected void onSignUpClick() throws SQLException {
        SQLDriver sqld = new SQLDriver();
        Connection conn = sqld.createConnection("25.54.165.230","3306","csc340","testuser", "1234");
        sqld.signUpUser(conn, user_signup_field.getText().toString(), pass_signup_field.getText().toString());
    }

    @FXML
    protected void onLoginClick() {
        MainApplication.mainStage.setScene(MainApplication.dashboardScene);
        MainApplication.mainStage.show();
    }

}