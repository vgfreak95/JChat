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
//        Socket socket = new Socket("25.50.70.173", 8000);
            Socket socket = new Socket("127.0.0.1", 8000);
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
            listView.scrollTo(listView.getItems().size() - 1);

    }
//
//    private Socket client;
//    private BufferedReader in;
//    private PrintWriter out;
//    private Boolean done = false;
//
//    @Override
//    public void run() {
//        try{
//            Socket client = new Socket("127.0.0.1", 8000);
//            out = new PrintWriter((client.getOutputStream()), true);
//            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
//
//            ChatroomController.InputHandler inHandler = new ChatroomController.InputHandler();
//            Thread t = new Thread(inHandler);
//            t.start();
//
//            String inMessage;
//            while((inMessage = in.readLine()) != null){
//                System.out.println(inMessage);
//            }
//        }catch(IOException e){
//            shutdown();
//        }
//    }
//
//    public void shutdown(){
//        done = true;
//        try{
//            in.close();
//            out.close();
//            if(!client.isClosed()){
//                client.close();
//            }
//        }catch (IOException e){
//
//        }
//    }
//
//    class InputHandler implements Runnable{
//
//        @Override
//        public void run() {
//            try{
//                BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
//                while(!done){
//                    String message = inReader.readLine();
//                    if(message.equals("/quit")){
//                        inReader.close();
//                        shutdown();
//                    } else{
//                        out.println(message);
//                    }
//                }
//            }catch(IOException e){
//                shutdown();
//            }
//        }
//    }

//    public static void main(String[] args){
//        ChatroomController client = new ChatroomController();
//        client.run();
//    }
}
