package threadsDay1;

/**
 *
 * @author Andreas Heick Laptop
 */
public class Even
{

    private int n = 0;
    
    public int next()
    {
        synchronized(this){
            for(int i = 0; i < 500; i++)
            {
                n++;
                n++; 
            }
        }
        return n;
    }

    public int getN()
    {
        return n;
    }
}
