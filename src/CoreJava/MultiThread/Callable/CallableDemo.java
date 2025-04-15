package CoreJava.MultiThread.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String args[]){

        SumCallable[] sumCallables={
                new SumCallable(4),
                new SumCallable(7),
                new SumCallable(10),
                new SumCallable(17),
                new SumCallable(30),
                new SumCallable(89)};


        ExecutorService executorService= Executors.newFixedThreadPool(3);

        for(SumCallable sumTask: sumCallables){
            Future<Integer> futureSum=executorService.submit(sumTask);

            try{
                System.out.println(futureSum.get());
            }
            catch(InterruptedException | ExecutionException ex){
                ex.printStackTrace();
            }

        }

        executorService.shutdown();

    }
}
