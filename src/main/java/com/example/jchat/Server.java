package com.example.jchat;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Server extends SocketAddress {

    public static void main(String[] args){
        int portNumber = 8000;
        try{
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while(true){
                Socket clientSocket = serverSocket.accept();

                System.out.println("Connection established with: " +clientSocket);
                OutputStream outputStream = clientSocket.getOutputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
                BufferedReader buffer = new BufferedReader(inputStreamReader);
                String msgFromClient = buffer.readLine();
                System.out.println(msgFromClient);
                outputStream.write("FUCK this did work\r\n".getBytes());
                ServerWork work = new ServerWork(clientSocket);
                ArrayList<Socket> socketArray = new ArrayList<Socket>();
                socketArray.add(clientSocket);

                System.out.println(socketArray);
                work.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
