package com.example.jchat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

// local classes
import com.example.jchat.MainApplication;

public class PreScreenController {

    @FXML
    private Label welcomeText;
    private Button login;
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
    protected void onGoBackToSignInClick() {
        MainApplication.mainStage.setScene(MainApplication.loginScene);
        MainApplication.mainStage.show();
    }

    @FXML
    protected void onSignUpClick() {
        System.out.println("User tried to sign up");
    }

    @FXML
    protected void onLoginClick() {
        MainApplication.mainStage.setScene(MainApplication.dashboardScene);
        MainApplication.mainStage.show();
    }
    @FXML
    protected void onNewChatClick() {
        MainApplication.mainStage.setScene(MainApplication.chatroomScene);
        MainApplication.mainStage.show();
    }

    @FXML
    protected void onViewReportLogsClick() {
        MainApplication.mainStage.setScene(MainApplication.reportedLogsScene);
        MainApplication.mainStage.show();
    }

    @FXML
    protected void onViewMembersClick() {
        MainApplication.mainStage.setScene(MainApplication.viewMembersScene);
        MainApplication.mainStage.show();
    }
    @FXML
    protected void onModifyUserPermissionsClick() {
        MainApplication.mainStage.setScene(MainApplication.modifyPermissionsScene);
        MainApplication.mainStage.show();
    }
    @FXML
    protected void onViewOpenRoomsClick() {
        MainApplication.mainStage.setScene(MainApplication.openRoomsScene);
        MainApplication.mainStage.show();
    }
    @FXML
    protected void onSuspendUserAccess() {
        MainApplication.mainStage.setScene(MainApplication.suspendAccessScene );
        MainApplication.mainStage.show();
    }

    @FXML
    protected void onReturnToDashboardClick() {
        MainApplication.mainStage.setScene(MainApplication.dashboardScene );
        MainApplication.mainStage.show();
    }

}