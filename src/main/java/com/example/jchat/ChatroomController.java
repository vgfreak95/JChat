package com.example.jchat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

// local classes

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ChatroomController extends DashboardController {

    private FXMLLoader chatRoomLoader;

    @FXML private ScrollPane scrollPane;
    @FXML private Label roomNameLabel;
    @FXML
    private ListView listView;

    @FXML
    private TextField message_field;


    private Room chatRoom;
    private String name;

    public void setLabelName(String name) {
        this.roomNameLabel.setText(name);
    }

    public void setChatRoom(Room newRoom) {
        this.chatRoom = new Room(
                newRoom.getRoomName(),
                newRoom.getCreateTime(),
                newRoom.getCapacity(),""
        );
        System.out.println(newRoom.toString());
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void onOpenRoomClick(Room room) throws IOException {
        System.out.println("Setting Chatroom");

        chatRoomLoader = new FXMLLoader(getClass().getResource("chatroom.fxml"));
        Parent chatRoomRoot = chatRoomLoader.load();
        Scene chatRoomScene = new Scene(chatRoomRoot, 1280, 960);
        ChatroomController chatroomController = chatRoomLoader.getController();
        chatroomController.setLabelName(room.getRoomName());
        MainApplication.mainStage.setScene(chatRoomScene);
        MainApplication.mainStage.show();
    }


    @FXML
    public void sendMessage() throws IOException {
        Socket socket = new Socket("127.0.0.1", 8000);
//        Socket socket = new Socket("25.95.108.108", 8000);
//            Socket socket = new Socket("127.0.0.1", 8000);

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
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                listView.getItems().add(message_field.getText());
//                message_field.clear();
//                message_field.requestFocus();
//                listView.scrollTo(listView.getItems().size() - 1);
//            }
//        });
//            listView.getItems().add(message_field.getText());
        message_field.clear();
        message_field.requestFocus();
        listView.scrollTo(listView.getItems().size() - 1);



//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        System.out.println("This was called");
//        this.roomNameLabel = new Label();
//
//    }
}