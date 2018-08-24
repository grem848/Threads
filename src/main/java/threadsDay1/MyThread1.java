package threadsDay1;

/**
 *
 * @author Andreas Heick Laptop
 */
public class MyThread1 extends Thread
{

    private String name;
    public MyThread1(String name)
    {
        this.name = name;
    }
    
    
    @Override
    public void run()
    {
        for (int i = 0; i < 6; i++)
        {
            System.out.println(name + ": " + i);
            
        }
    }

}
