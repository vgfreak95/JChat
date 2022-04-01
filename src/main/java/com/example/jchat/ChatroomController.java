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

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ChatroomController extends DashboardController {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private ListView listView;

    @FXML
    private TextField message_field;


    @FXML
    public void sendMessage() throws IOException {
        Socket socket = new Socket("25.50.70.173", 8000);
        Socket cSocket = new Socket(InetAddress.getLocalHost(), 8000);
        OutputStream out = socket.getOutputStream();
        String message = User.username + ": " + message_field.getText() + " " + cSocket.getLocalAddress() + " roomID";
        PrintWriter writer = new PrintWriter(out, true);
        writer.println(message);
        /**
         * user joins room
         * chatrooms database updates with members in room by userid "online"
         * add columns for active roomid online
         */

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader buffer = new BufferedReader(inputStreamReader);
        String msgFromClient = buffer.readLine();

        listView.getItems().add(msgFromClient);
        message_field.clear();
        message_field.requestFocus();
        listView.scrollTo(listView.getItems().size()-1);
    }
}
