package com.example.jchat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

// local classes

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
                newRoom.getCapacity()
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
        Socket socket = new Socket("25.50.70.173", 8000);
        OutputStream out = socket.getOutputStream();
        String message = User.username + ": " + message_field.getText() + "\r\n";
        out.write(message.getBytes());
        PrintWriter writer = new PrintWriter(out, true);
        writer.println("IDK");

        listView.getItems().add(User.username + ": " + message_field.getText());
        message_field.clear();
        message_field.requestFocus();
        listView.scrollTo(listView.getItems().size()-1);
    }


//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        System.out.println("This was called");
//        this.roomNameLabel = new Label();
//
//    }
}
