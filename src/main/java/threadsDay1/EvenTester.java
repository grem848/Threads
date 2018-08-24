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
    /*
    a) Are you able to provoke the expected error on your machine? Yes and no, I only get even numbers but race condition still happens
    b) How often does the problem occur? Most of the times
    c) Use the synchronization techniques you’ve learned today, to make next() method atomic with respect to itself.
    d) Argue that your solution is correct (argue, don’t prove) 
    Well mine synchronizes the Even n so all threads show 6 when it works, so the threads increment n first and
    shows the same n afterwards, meaning a race condition doesnt happen.
    */
}
