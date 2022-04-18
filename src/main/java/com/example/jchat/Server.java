package com.example.jchat;

import javafx.scene.control.ListView;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server extends SocketAddress {

    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public Server(ServerSocket serverSocket) {
        try {
            this.serverSocket = serverSocket;
            this.socket = serverSocket.accept();
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch(IOException e){
            System.out.println("Error making server");
            e.printStackTrace();
            closeAll(socket, bufferedReader, bufferedWriter);
        }
    }

    public void sendMsgToClient(String msgToClient){
        try {
            bufferedWriter.write(msgToClient);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error sending message to client");
            closeAll(socket, bufferedReader, bufferedWriter);
        }
    }

    public void receiveMsgFromClient(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(socket.isConnected()){
                    try {
                        String msgFromClient = bufferedReader.readLine();
                    }catch (IOException e){
                        e.printStackTrace();
                        System.out.println("Error receiving msg from client");
                        closeAll(socket, bufferedReader, bufferedWriter);
                        break;
                    }
                }
            }
        }).start();
    }

    public void closeAll(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try {
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
            if(socket != null){
                socket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    ////    public Set<InetAddress> socketSet = new HashSet<InetAddress>();
//
//    public static void main(String[] args){
//        ArrayList<ServerWork> runnableList = new ArrayList<ServerWork>();
//        int portNumber = 8000;
//        try{
//            ServerSocket serverSocket = new ServerSocket(portNumber);
//            while(true){
//                Socket clientSocket = serverSocket.accept();
//
//                OutputStream outputStream = clientSocket.getOutputStream();
//                //store in sql database
//                //send the message back to all clients in room
//
//                ServerWork svr = new ServerWork(clientSocket);
//                Runnable work = svr;
//                Thread thr = new Thread(work);
//                runnableList.add(svr);
//                thr.start();
////                System.out.println(runnableList);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
}
