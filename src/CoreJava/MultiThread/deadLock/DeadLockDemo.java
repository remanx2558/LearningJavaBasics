package CoreJava.MultiThread.deadLock;

public class DeadLockDemo implements Runnable{

    public FirstResource fr=new FirstResource();
    public SecondResource sr=new SecondResource();

    public static void main(String args[]){
        DeadLockDemo deadLockThread=new DeadLockDemo();
    }

    DeadLockDemo(){
        Thread secondThread=new Thread(this);
        //main Thread: Executes FR
        secondThread.start(); //Second Thread: Executes SR
        fr.methordOne(sr);

        //Note: if  secondThread.start();  is placed here instead of above , then No Dead Lock why??
        //Note2: As Thread locks all the code with synchronised keyword in an object.

    }

    public void run(){
        sr.methordOne(fr);
    }
}
