package SocketProgramming.easyExample;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[])  {

        try{
            ServerSocket serverSocket=new ServerSocket(8080);
            System.out.println("waiting for the cleint to connect on 8080 port");

            Socket clientSocket=serverSocket.accept();
            System.out.println("Connection established with an client");


            DataInputStream dis=new DataInputStream(clientSocket.getInputStream());
            String message=dis.readUTF();
            System.out.println(message);

            //close things now
            dis.close();
            //optional :can close to listen
           // clientSocket.close();
            //skipping above optional can directly close serversocket
            serverSocket.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}
