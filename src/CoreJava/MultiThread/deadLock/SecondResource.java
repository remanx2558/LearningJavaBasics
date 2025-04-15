package CoreJava.MultiThread.deadLock;

public class SecondResource{

    public synchronized void methordOne(FirstResource fr){
        System.out.println("Executing SR-M1");

        try{Thread.sleep(3000);}
        catch (InterruptedException ie){ie.printStackTrace();}
        System.out.println("Invoking FR-M2");
        fr.methordTwo();
    }

    public synchronized void methordTwo(){
        System.out.println("Executing SR-M2");
    }
}

