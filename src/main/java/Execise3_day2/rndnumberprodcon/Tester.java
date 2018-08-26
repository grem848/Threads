package Execise3_day2.rndnumberprodcon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Tester
{

    public static void main(String[] args) throws InterruptedException
    {
        //This represent the Queue in the exercise-figure. Observe the size of the Queue
        ArrayBlockingQueue<Integer> numbers = new ArrayBlockingQueue(5);

        ExecutorService es = Executors.newCachedThreadPool();
        //Create and start four producers (P1-P4 in the exercise-figure)
        es.execute(new RandomNumberProducer(numbers));
        es.execute(new RandomNumberProducer(numbers));
        es.execute(new RandomNumberProducer(numbers));
        es.execute(new RandomNumberProducer(numbers));

        //Create and start single consumer (C1 in the exercise-figure)
        RandomNumberConsumer consumer = new RandomNumberConsumer(numbers);

        es.execute(consumer);

        es.shutdown();
        es.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Total of all random numbers: " + consumer.getSumTotal());
        System.out.println("Number of random numbers below 50: " + consumer.getBelow50().size());
        System.out.println("Number of random numbers >= 50: " + consumer.getAboveOr50().size());
    }
    /*
    1. If we need a “large” collection of random numbers, what is the advantage (if any) of introducing a number of threads to “produce” the numbers?
    Performance, multiple threads work faster
  
    2. Why does the exercise suggest 4 producer threads, and is this always the right  number?
    To show how queue works, so we use 4 to show that the program can manage  more input than output.
  
    3. Given that the Queue is a BlockingQueue implementation, how would you insert data into the Queue
    (add(), offer(), put() ) if it’s limited in capacity, and items are produced much faster than they
    are consumed (Think: what happens when you insert into a full queue)?
    We are blocked if we try to insert, and if we use put we will get an exception, we need to use offer().
  
    4. Given that the Queue is a BlockingQueue implementation, how would you fetch data from the Queue (remove(),
    poll(), take() ) if Production is slow, compared to how we consume items
    Poll() so the queue can be empty without throwing an exception
     */
}
