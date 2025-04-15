package CoreJava.MultiThread;

import java.util.Scanner;

public class MergeBranch extends Thread{
    static int n;
    static int sum;

    public static void main(String args[]){

        MergeBranch mb=new MergeBranch();
        Scanner sc=new Scanner(System.in);
        System.out.println("We are gonna sum till N \n enter an value for N");
        n=sc.nextInt();


        long startTime=System.currentTimeMillis();
        Thread currentThread=Thread.currentThread();
        System.out.println("Thread Name is:"+ currentThread.getName());
        //start an new Thread
        mb.start();

        //end the new thread
        try {mb.join();}
        catch (InterruptedException ie){ie.printStackTrace();}

        long endTime=System.currentTimeMillis();
        System.out.println("Sum is :"+MergeBranch.sum);
        System.out.println("Total thread execution time "+((endTime-startTime)/1000)+" seconds");

    }


    public void run(){
        sumUp();
        Thread currentThread=Thread.currentThread();
        currentThread.setName("SumThread");
        System.out.println("Thread Name is:"+ currentThread.getName());
    }
    void sumUp(){
        for(int i=0;i<n;i++){
            MergeBranch.sum+=i;
            try
            {
                System.out.println("Transient sum: "+MergeBranch.sum);
                Thread.sleep(1000);
            }
            catch (InterruptedException ie){ ie.printStackTrace();}
        }
    }

}


