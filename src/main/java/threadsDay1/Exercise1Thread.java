package threadsDay1;

/**
 *
 * @author Andreas Heick Laptop
 */
public class Exercise1Thread extends Thread
{

    private String name;
    private long sum;

    public Exercise1Thread(String name, long sum)
    {
        this.name = name;
        this.sum = sum;
    }

    @Override
    public void run()
    {
        for (int i = 1; i < 1000000000; i++)
        {
            sum += i;
            
        }
        System.out.println(sum);
    }

}
