package threadsDay2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Andreas Heick Laptop
 */
public class BlockingQueueExample
{

    public static void main(String[] args) throws Exception
    {

        BlockingQueue queue = new ArrayBlockingQueue(10);

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Producer producer4 = new Producer(queue);
        
        Consumer consumer = new Consumer(queue);

        new Thread(producer1).start();
        new Thread(producer2).start();
        new Thread(producer3).start();
        new Thread(producer4).start();
        
        Thread tConsumer = new Thread(consumer);
        tConsumer.start();
        tConsumer.join();

        System.out.println("Sum of all randoms: " + consumer.getSum());
    }
}
