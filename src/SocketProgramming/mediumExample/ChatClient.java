package SocketProgramming.mediumExample;

import java.io.*;
import java.net.Socket;

public class ChatClient {

    public static void main(String args[]){

        try{
            Socket serverSocket=new Socket("localhost",9090);

            //read
            DataInputStream dis=new DataInputStream(serverSocket.getInputStream());
            BufferedReader consoleBR=new BufferedReader(new InputStreamReader(System.in));
            //write
            DataOutputStream dos=new DataOutputStream(serverSocket.getOutputStream());

            //send receive message till client says exit
            String receivedMessage=null;
            String sendMessage=null;
            while (true){
                //read Message 1st
                receivedMessage=dis.readUTF();
                System.out.println("server says: "+receivedMessage);
                //send Message 2nd
                sendMessage=consoleBR.readLine();
                dos.writeUTF(sendMessage);
                dos.flush();
                if(sendMessage!=null && sendMessage.equalsIgnoreCase("exit")){
                    break;
                }
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
