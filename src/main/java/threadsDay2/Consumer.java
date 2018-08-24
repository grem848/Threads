package threadsDay2;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Andreas Heick Laptop
 */
public class Consumer implements Runnable
{

    protected BlockingQueue queue = null;
    final int MAX_NUMBERS = 1200;
    int sum;

    public int getSum()
    {
        return sum;
    }

    public Consumer(BlockingQueue queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < MAX_NUMBERS; i++)
        {
            try
            {
                sum += (int) queue.take();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
