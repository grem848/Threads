package threadsDay1;

/**
 *
 * @author Andreas Heick Laptop
 */
public class EvenThread extends Thread
{

    Even e;

    public EvenThread(Even e)
    {
        this.e = e;
    }

    @Override
    public void run()
    {
        e.next();
    }
}
