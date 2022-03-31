package com.example.jchat;

import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

import java.nio.charset.StandardCharsets;

public class ServerWork extends Thread implements Runnable{
    private final Socket clientSocket;

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

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String textLine;
        while((textLine = reader.readLine()) != null){
            if ("exit".equalsIgnoreCase(textLine)){
               break;
           }
           String message = "You said: " + textLine + "\r\n";
           outputStream.write(message.getBytes());
        }

        clientSocket.close();

    }
}
