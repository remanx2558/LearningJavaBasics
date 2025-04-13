package MultiThread.yeild;

public class GoClass {
    public static void main(String args[]){
        WaitClass waitClass=new WaitClass();
        waitClass.start();

        for(int i=0;i<10;i++){
            System.out.println("Go class "+i);
        }
    }
}
