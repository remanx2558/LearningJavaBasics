package SocketProgramming.mediumExample;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class ChatServer {

    public static void main(String args[]){
        Logger logger=Logger.getLogger(ChatServer.class.getName());

        try{
            ServerSocket serverSocket=new ServerSocket(9090);
            logger.info("Server is ready to chat");
            Socket clientSocket=serverSocket.accept();

            //read
            DataInputStream dis=new DataInputStream(clientSocket.getInputStream());
            BufferedReader consoleBR=new BufferedReader(new InputStreamReader(System.in));
            //write
            DataOutputStream dos=new DataOutputStream(clientSocket.getOutputStream());

            //send receive message till client says exit
            String receivedMessage=null;
            String sendMessage=null;
            while (true){
                //read Message 1st
                receivedMessage=dis.readUTF();
                System.out.println("client says: "+receivedMessage);
                if(receivedMessage!=null && receivedMessage.equalsIgnoreCase("exit")){
                    break;
                }
                //send Message 2nd
                sendMessage=consoleBR.readLine();
                dos.writeUTF(sendMessage);
                dos.flush();
            }

            dis.close();
            consoleBR.close();
            dos.close();

            //optional step to close client from here
          //  clientSocket.close();
            serverSocket.close();


        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
