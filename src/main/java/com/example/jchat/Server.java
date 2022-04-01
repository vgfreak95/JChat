package com.example.jchat;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Server extends SocketAddress {
//    public Set<InetAddress> socketSet = new HashSet<InetAddress>();

    public static void main(String[] args){
        ArrayList<ServerWork> runnableList = new ArrayList<ServerWork>();
        int portNumber = 8000;
        try{
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while(true){
                Socket clientSocket = serverSocket.accept();

                OutputStream outputStream = clientSocket.getOutputStream();
                //store in sql database
                //send the message back to all clients in room

                ServerWork svr = new ServerWork(clientSocket);
                Runnable work = svr;
                Thread thr = new Thread(work);
                runnableList.add(svr);
                thr.start();
//                System.out.println(runnableList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
