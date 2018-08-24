
package threadsDay1;

/**
 *
 * @author Andreas Heick Laptop
 */
public class Tester2
{
    public static void main(String[] args) throws InterruptedException
    {
        RunnableDemo r1 = new RunnableDemo("T1");
        RunnableDemo r2 = new RunnableDemo("T2");
        
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        
        Thread.sleep(6000);
        r1.stopThread();
        r2.stopThread();
        
        t1.join();
        t2.join();
        
        System.out.println("DONE");
    }
    
}
