package MultiThread.interrupt;

public class SubmissiveOne extends Thread{

    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Submissive thread1 : "+i);
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException ie){
                System.out.println("Interrupeted 1");
            }

        }
        System.out.println("End of Submissive Thread 1");

    }
}
