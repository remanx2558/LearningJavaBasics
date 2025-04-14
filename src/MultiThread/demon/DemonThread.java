package MultiThread.demon;

public class DemonThread extends Thread{
    public void run(){

        for(int i=0;i<10;i++){
            System.out.println("Demon Thread: "+i);
            try {Thread.sleep(1000);}
            catch (InterruptedException ie){ie.printStackTrace();}
        }


    }
}
