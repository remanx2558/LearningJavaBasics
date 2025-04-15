package CoreJava.MultiThread.yeild;

public class WaitClass extends Thread{
    // Un Comment each Thread.yield() to see the differene in output
    public void run(){

        //Thread.yield();
        for(int i=0;i<10;i++){
            System.out.println("Wait class: "+i);
            Thread.yield();

        }
        //Thread.yield();

    }
}
