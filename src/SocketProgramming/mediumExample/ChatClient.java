package SocketProgramming.mediumExample;

import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

public class ChatClient {

    public static void main(String args[]){
        Logger logger=Logger.getLogger(ChatClient.class.getName());


        try{
            Socket serverSocket=new Socket("localhost",9090);
            logger.info("Client is ready to chat");

            //read
            DataInputStream dis=new DataInputStream(serverSocket.getInputStream());
            BufferedReader consoleBR=new BufferedReader(new InputStreamReader(System.in));
            //write
            DataOutputStream dos=new DataOutputStream(serverSocket.getOutputStream());

            //send receive message till client says exit
            String receivedMessage=null;
            String sendMessage=null;
            while (true){

                //send Message 1st
                sendMessage=consoleBR.readLine();
                dos.writeUTF(sendMessage);
                dos.flush();
                if(sendMessage!=null && sendMessage.equalsIgnoreCase("exit")){
                    break;
                }

                //read Message 2nd
                receivedMessage=dis.readUTF();
                System.out.println("server says: "+receivedMessage);
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
