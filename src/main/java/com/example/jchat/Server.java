package com.example.jchat;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server extends SocketAddress {

    public static void main(String[] args){
        int portNumber = 8000;
        try{
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while(true){
                Socket clientSocket = serverSocket.accept();

                System.out.println("Connection established with: " +clientSocket);
                OutputStream outputStream = clientSocket.getOutputStream();
                outputStream.write("FUCK this did work\r\n".getBytes());
                ServerWork work = new ServerWork(clientSocket);
                work.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
