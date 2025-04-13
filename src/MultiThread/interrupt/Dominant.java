package MultiThread.interrupt;

public class Dominant {
    public static void main(String args[]){
        Submissive submissive=new Submissive();
        submissive.start();
        submissive.interrupt();
        System.out.println("End of Dominant Thread");
    }
}
