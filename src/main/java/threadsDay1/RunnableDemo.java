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
    private final int MAX = 10;
    private int count = 0;
    private boolean stop = false;

    public RunnableDemo(String name)
    {
        this.name = name;
    }

    public void stopThread()
    {
        stop = true;
    }

    public boolean checkCount()
    {
        if (count == 10)
        {
            stopThread();
            System.out.println(name + " has stopped after 10 seconds");
            return true;
        }
        return false;
    }

    @Override
    public void run()
    {
        int i = 10;
        int threeSec = 0;
        while (stop == false)
//        while (i < MAX && stop == false)
        {
            try
            {
                System.out.println(name + ": " + i++);
                while (threeSec < 3)
                {
                    Thread.sleep(1000);
                    count++;
                    if(checkCount() == true)
                    {
                        break;
                    }
                    threeSec++;
//                    System.out.println(threeSec);
                    System.out.println(name + " Counter:" + count);
                }
                threeSec = 0;

            } catch (InterruptedException ex)
            {
                Logger.getLogger(RunnableDemo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
