package CoreJava.MultiThread.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExeutorDemo {
    public static void main(String args[]){


        CheckProcessorTask[] taskList={
                new CheckProcessorTask("ATM"),
                new CheckProcessorTask("Bank"),
                new CheckProcessorTask("Card"),
                new CheckProcessorTask("Cash"),
                new CheckProcessorTask("UPI"),
                new CheckProcessorTask("Online"),
        };

        ExecutorService executorService= Executors.newFixedThreadPool(2);

        for(CheckProcessorTask task: taskList){
            executorService.submit(task);
        }
        executorService.shutdown();
    }
}
