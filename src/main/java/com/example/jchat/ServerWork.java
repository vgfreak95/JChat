package com.example.jchat;

import javafx.scene.control.TextField;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class ServerWork extends Server implements Runnable{
    public final Socket clientSocket;
    public ServerWork(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            handleClientSockets();
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    private void handleClientSockets() throws IOException, InterruptedException{
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader buffer = new BufferedReader(inputStreamReader);
        String msgFromClient = buffer.readLine();

        String[] msg = msgFromClient.split(" ");
        String msgTwo = new String("");

            for(int i = 0; i < msg.length-2; i++){
            msgTwo = msgTwo + " " + msg[i];
        }

        PrintWriter writer = new PrintWriter(outputStream, true);
        writer.println(" " + msgTwo);


        /**
         * query for all connected userid in roomID
         * send to socket for userid
         */

//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        String textLine;
//        while((textLine = reader.readLine()) != null){
//            if ("exit".equalsIgnoreCase(textLine)){
//               break;
//           }
//           String message = "You said: " + textLine + "\r\n";
//           outputStream.write(message.getBytes());
//        }

        clientSocket.close();

    }
}