package threadsDay1;

/**
 *
 * @author Andreas Heick Laptop
 */
public class Even
{

    private int n = 0;
    
    public synchronized int next()
    {
        n++;
        n++;
        return n;
    }

    public int getN()
    {
        return n;
    }
}
