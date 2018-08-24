package threadsDay1;

/**
 *
 * @author Andreas Heick Laptop
 */
public class EvenTester
{

    public static void main(String[] args) throws InterruptedException
    {
        Even e = new Even();
        EvenThread t1 = new EvenThread(e);
        EvenThread t2 = new EvenThread(e);
        EvenThread t3 = new EvenThread(e);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(t1.getName() + " - " + e.getN());
        System.out.println(t2.getName() + " - " + e.getN());
        System.out.println(t3.getName() + " - " + e.getN());

        System.out.println("DONE");

    }
}
