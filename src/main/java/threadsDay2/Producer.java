package threadsDay2;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andreas Heick Laptop
 */
public class Producer implements Runnable
{

    protected BlockingQueue queue = null;
    private final int NUMBERS_TO_MAKE = 300;

    public Producer(BlockingQueue queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < NUMBERS_TO_MAKE; i++)
        {

//            int randomNum = ThreadLocalRandom.current().nextInt(1, 10 + 1);
            int randomNum = 100;
            try
            {
                queue.put(randomNum);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
