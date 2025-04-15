package CoreJava.MultiThread.demon;

public class UserThread {
    public static void main(String args[]){

        //Check current main thread is Demon or not
        System.out.println(Thread.currentThread().isDaemon());
        DemonThread demonThread=new DemonThread();

        //NOTE: Un-comment only one

        //Test Case:1: Not Demon Thread so will Keep executing till it finishes
//        System.out.println(demonThread.isDaemon());
//        demonThread.start();

       // Test Case 2: when main thread finishes it also finishes
//        demonThread.setDaemon(true);
//        System.out.println(demonThread.isDaemon());
//        demonThread.start();

        //Test case 3: Cannot make thread demon after starting it
        demonThread.start();
        System.out.println(demonThread.isDaemon());
        demonThread.setDaemon(true);
        System.out.println(demonThread.isDaemon());















    }
}
