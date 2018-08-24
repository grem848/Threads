package threadsDay1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andreas Heick Laptop
 */
public class RunnableDemo implements Runnable
{

    private String name;
    private final int MAX = 30;
    private boolean stop = false;

    public RunnableDemo(String name)
    {
        this.name = name;
    }

    public void stopThread()
    {
        stop = true;
    }
            
    @Override
    public void run()
    {
        int i = 10;
        while (i < MAX && stop == false)
        {
            try
            {
                System.out.println(name + ": " + i++);
                Thread.sleep(3000);
                
            } catch (InterruptedException ex)
            {
                Logger.getLogger(RunnableDemo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
