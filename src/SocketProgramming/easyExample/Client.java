package SocketProgramming.easyExample;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String args[]){
        try{
            Socket socket=new Socket("localhost",8080);//this line connects to Server
            DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
            String sendMessage="Java Sockets are cool";
            dos.writeUTF(sendMessage);
            dos.close();
            socket.close();
        }
        catch(UnknownHostException uhe){
            uhe.printStackTrace();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }

    }
}
