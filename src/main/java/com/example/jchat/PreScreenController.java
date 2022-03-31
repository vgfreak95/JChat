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
    private TextField user_login_field, user_password_field;

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
        sqld.signUpUser(sqld.conn, user_signup_field.getText().toString(), pass_signup_field.getText().toString());
    }

    @FXML
    protected void onLoginClick() throws SQLException {
        SQLDriver sqld = new SQLDriver();
        Boolean correctInfo = sqld.loginUser(sqld.conn, user_login_field.getText().toString(), user_password_field.getText().toString());
        if(correctInfo) {
            MainApplication.mainStage.setScene(MainApplication.dashboardScene);
            MainApplication.mainStage.show();
        }
    }

}