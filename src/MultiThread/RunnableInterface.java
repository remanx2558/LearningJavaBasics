package MultiThread;

public class RunnableInterface implements Runnable{


    public static void main(String args[]){
        RunnableInterface ri=new RunnableInterface();
        Thread newThread=new Thread(ri);
        newThread.start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
