
package threadsDay2;

/**
 *
 * @author Andreas Heick Laptop
 */
public class MutableInteger
{
    private int i = 0;
    
    public int get()
    {
        return i;
    }
    
    public synchronized void increment()
    {
        this.i++;
    }
    
    
    
}
