package threadsDay3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableForDemo implements Callable<String>
{
    int taskId;

    public CallableForDemo(int taskId)
    {
        this.taskId = taskId;
    }
    
    @Override
    public String call() throws Exception
    {
        Thread.sleep(1000);
        //return the thread name executing this callable task
        return "TaskID: " + taskId + " --- " + Thread.currentThread().getName();
    }
}

public class MyCallable
{

    public static void main(String args[])
    {
        // Could have been somthing relevant (URLS for example)
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        
        //Get ExecutorService from Executors utility class, thread pool size is 10
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //create a list to hold the Future object associated with Callable
        List<Future<String>> list = new ArrayList<>();
        //Create MyCallable instance
        for (int id : ids)
        {
            Callable<String> callable = new CallableForDemo(id);   
            //submit Callable tasks to be executed by thread pool
            Future<String> future = executor.submit(callable);
            //add Future to the list, we can get return value using Future
            list.add(future);
        }
        for (Future<String> fut : list)
        {
            try
            {
                //print the return value of Future, notice the output delay in console
                // because Future.get() waits for task to get completed
                System.out.println(fut.get());
            } catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }
        //shut down the executor service now
        executor.shutdown();
    }

}
