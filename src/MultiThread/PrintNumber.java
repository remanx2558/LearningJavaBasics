package MultiThread;

public class PrintNumber extends Thread{

    public static void main(String args[]){

        PrintNumber pn=new PrintNumber();
        pn.start();
        for(int i=0;i<200;i++){
            System.out.print("i "+i+" \t");
            try {Thread.sleep(1000);}
            catch (InterruptedException ie){ ie.printStackTrace();}
        }
    }

    //override run() for Thread class: This will become a new thread
    public void run(){
        for(int j=0;j<200;j++){
            System.out.print("j "+j+" \t");
            try {Thread.sleep(1000);}
            catch (InterruptedException ie){ ie.printStackTrace();}

        }
    }
}
