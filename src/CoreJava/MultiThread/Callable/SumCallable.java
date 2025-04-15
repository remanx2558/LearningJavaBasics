package CoreJava.MultiThread.Callable;

import java.util.concurrent.Callable;

public class SumCallable implements Callable<Integer> {

    int num;

    SumCallable(int num){this.num=num;}


    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" is calculating sum till : "+num);

        int sum=0;
        for(int i=1;i<=num;i++){
            sum+=i;
        }
        return sum;
    }
}
