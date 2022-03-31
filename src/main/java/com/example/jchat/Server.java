package com.example.jchat;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Server extends SocketAddress implements Runnable {

    public static void main(String[] args){
        int portNumber = 8000;
        try{
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while(true){
                Socket clientSocket = serverSocket.accept();
                Server s = new Server();
                if(clientSocket.isConnected()){
                    s.run();
                }
//                ServerWork work = new ServerWork(clientSocket);
//                work.start;

                System.out.println("Connection established with: " +clientSocket);
                OutputStream outputStream = clientSocket.getOutputStream();
                outputStream.write("FUCK this did work\n".getBytes());
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {

    }
    private void serverLoop(){
//        InputStream inputStream =
    }
}
