package CoreJava.MultiThread.InterThreadCommunication;

public class MasterThread {
    public static void main(String args[]){

        SlaveThread slaveThread=new SlaveThread();

        slaveThread.start();
        synchronized (slaveThread){
            System.out.println(" Master thread gonna wait now");

            try {slaveThread.wait();}//mater thread waits till child finishes
            catch (InterruptedException e) {
               e.printStackTrace();
            }

            System.out.println(" Master thread is Notified");
            System.out.println(" Master thread have sum: "+slaveThread.sum);
        }

    }
}
