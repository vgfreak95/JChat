package com.example.jchat;

import javax.sound.midi.ShortMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server2 implements Runnable {

    private ArrayList<ConnectionHandler> connections;
    private ServerSocket server;
    private Boolean done;
    private ExecutorService pool;

    public Server2(){
        connections = new ArrayList<>();
        done = false;
    }

    @Override
    public void run() {
        try {
                server = new ServerSocket(8000);
                pool = Executors.newCachedThreadPool();
            while (!done) {
                Socket client = server.accept();
                ConnectionHandler handler = new ConnectionHandler(client);
                connections.add(handler);
                pool.execute(handler);
            }
            } catch(IOException e){
                shutdown();
            }

    }

    public void broadcast(String message){
        for (ConnectionHandler ch : connections){
            if (ch != null){
                ch.sendMessage(message);
            }
        }
    }

    public void shutdown(){
        try{
            done = true;
            if(!server.isClosed()){
                server.close();
            }
        }catch (IOException e){

        }
    }

    class ConnectionHandler implements Runnable{

        private Socket client;
        private BufferedReader in; //from client
        private PrintWriter out; //to client
        private String something;

        public ConnectionHandler(Socket client){
            this.client = client;
        }

        @Override
        public void run() {
            try{
                out = new PrintWriter(client.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
//                out.println("Please say something: ");
                something = in.readLine();
//                System.out.println(something + " was sent");
//                broadcast(something + " was sent by user!");
                String message;

                String[] msg = something.split(" ");
                String msgTwo = new String("");

                for(int i = 0; i < msg.length-2; i++){
                    msgTwo = msgTwo + " " + msg[i];
                }
                broadcast(" " + msgTwo);
//                PrintWriter writer = new PrintWriter(out, true);
//                writer.println(" " + msgTwo);

//                while (( message = in.readLine()) != null){
//                    broadcast(message); // MOD
//                }
            }catch(IOException e){
                shutdown();
            }
        }
        public void sendMessage(String message){
            out.println(message);
        }

        public void shutdown(){
            try {
                in.close();
                out.close();
                if (!client.isClosed()) {
                    client.close();
                }
            }catch (IOException e){

            }
        }
    }

    public static void main(String[] args){
        Server2 server = new Server2();
        server.run();
    }

}
