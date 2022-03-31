package com.example.jchat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

// local classes
import com.example.jchat.MainApplication;

public class DashboardController {

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