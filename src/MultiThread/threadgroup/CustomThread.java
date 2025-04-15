package MultiThread.threadgroup;

public class CustomThread extends Thread{


    CustomThread(ThreadGroup tg, String name){
        super(tg,name);
    }


    public void run(){
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
