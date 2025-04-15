package MultiThread.InterThreadCommunication;

public class SlaveThread extends Thread{

    int sum=0;

    public void run(){
        synchronized (this){
            for(int i=0;i<5;i++){
                sum+=i;
                try {Thread.sleep(1000); }
                catch (InterruptedException ie){ie.printStackTrace();}
                System.out.println(" sum is: "+sum);
            }
            notify();
        }
    }

}
