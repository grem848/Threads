package threadsDay1;


/**
 *
 * @author Andreas Heick Laptop
 */
public class Exercise1Tester
{

    public static void main(String[] args) throws InterruptedException
    {
        Thread t1 = new Thread(() ->
        {
            long sum = 0;
            long billion = 1000000000;
                    
            for (long i = 1; i < billion; i++)
            {
                sum += i;

            }
            System.out.println("T1: " + sum);
        });
        
        Thread t2 = new Thread(() ->
        {
                    
            for (int i = 1; i < 6; i++)
            {
                System.out.println("T2: " + i);

            }
        });
        
        RunnableDemo r3 = new RunnableDemo("T3");
        Thread t3 = new Thread(r3);
        

        t1.start();
        t1.join();
        
        t2.start();
        t2.join();
        
        t3.start();
//        Thread.sleep(10000);
//        r3.stopThread();
        
        t3.join();
        
        
        
        System.out.println("DONE");

    }
}
