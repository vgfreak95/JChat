package com.example.jchat;

import javafx.fxml.FXML;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server extends SocketAddress implements Runnable {

    private Socket socket;
    private boolean exitThread;

    public Server(Socket socket) {
        this.socket = socket;
        this.exitThread = false;
    }

    public static void main(String[] args){
        int portNumber = 8000;
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while(true){
                Socket clientSocket = serverSocket.accept();

                // Creates a new thread that passes in the params

                // If a client is connected, create a new thread
                if(clientSocket.isConnected()){
                    Runnable server = new Server(clientSocket);
                    new Thread(server).start();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        while (!this.exitThread) {
            System.out.println("Connection established with: " +this.socket);
            OutputStream outputStream = null;
            try {
                outputStream = this.socket.getOutputStream();
                outputStream.write("FUCK this did work\n".getBytes());
                this.socket.close();
                this.exitThread = true;
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    private void serverLoop(){
//        InputStream inputStream =
    }
}
