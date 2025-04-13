package MultiThread;

import java.util.Scanner;

public class ThreadPriority extends Thread {


    public static void main(String args[]){

        //Thread 1
        ThreadPriority tp1=new ThreadPriority();
        tp1.setName("Thread1");
        tp1.setPriority(ThreadPriority.MIN_PRIORITY);
        tp1.start();


        //Thread 2
        ThreadPriority tp2=new ThreadPriority();
        tp2.setName("Thread2");
        tp2.setPriority(ThreadPriority.MAX_PRIORITY);
        tp2.start();

    }


    public void run(){
        System.out.println("current Thread is "+Thread.currentThread().getName());
    }
}
