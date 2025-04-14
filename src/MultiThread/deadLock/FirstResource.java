package MultiThread.deadLock;

public class FirstResource{

    public synchronized void methordOne(SecondResource sr){
        System.out.println("Executing FR-M1");

        try{Thread.sleep(3000);}
        catch (InterruptedException ie){ie.printStackTrace();}
        System.out.println("Invoking SR-M2");

        sr.methordTwo();
    }

    public synchronized void methordTwo(){
        System.out.println("Executing FR-M2");
    }
}
