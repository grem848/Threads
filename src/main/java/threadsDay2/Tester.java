package threadsDay2;

/**
 *
 * @author Andreas Heick Laptop
 */
public class Tester
{

    public static void main(String[] args) throws InterruptedException
    {
        MutableInteger mi = new MutableInteger();
        CounterThread t1 = new CounterThread(mi);
        CounterThread t2 = new CounterThread(mi);
        CounterThread t3 = new CounterThread(mi);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Result: " + mi.get());
    }
}
