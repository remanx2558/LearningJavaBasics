package MultiThread.interrupt;

public class Submissive extends Thread{

    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Submissive thread "+i);
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException ie){
                System.out.println("Interrupeted ");
            }

        }
        System.out.println("End of Submissive Thread");

    }
}
