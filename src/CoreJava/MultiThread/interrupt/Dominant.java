package CoreJava.MultiThread.interrupt;

public class Dominant {
    public static void main(String args[]){
        SubmissiveOne submissive=new SubmissiveOne();
        SubmissiveTwo submissiveTwo=new SubmissiveTwo();

        //
        submissiveTwo.start();
        submissiveTwo.interrupt();
        //
        submissive.start();
        submissive.interrupt();
        System.out.println("End of Dominant Thread");
    }
}
