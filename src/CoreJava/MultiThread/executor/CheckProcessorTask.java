package CoreJava.MultiThread.executor;

public class CheckProcessorTask implements Runnable{
    String name;

    CheckProcessorTask(String name){
        this.name=name;
    }
    public void run(){
        System.out.println(name+" check process has started by thread: "+Thread.currentThread().getName());
        try{Thread.sleep(2000);}
        catch (InterruptedException ie){ie.printStackTrace();}
        System.out.println(name+" check process is done by thread: "+Thread.currentThread().getName());
    }
}
