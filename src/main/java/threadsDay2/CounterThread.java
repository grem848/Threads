
package threadsDay2;

/**
 *
 * @author Andreas Heick Laptop
 */
public class CounterThread extends Thread
{

    MutableInteger mi;
    int MAX = 100_000;
    
    public CounterThread(MutableInteger mi)
    {
        this.mi = mi;
    }
    
    
    @Override
    public void run()
    {
        for(int i = 0; i < MAX; i++)
        {
            mi.increment();
        }
    }
    
}
