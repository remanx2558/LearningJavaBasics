package CoreJava.MultiThread.interrupt;

public class SubmissiveTwo extends Thread{

    public void run(){
        try
        {
            for(int i=0;i<10;i++){
                System.out.println("Submissive thread2 :"+i);
                Thread.sleep(2000);
            }
        }
        catch (InterruptedException ie){
            System.out.println("Interrupeted 2");
        }
        System.out.println("End of Submissive Thread 2");
    }
}