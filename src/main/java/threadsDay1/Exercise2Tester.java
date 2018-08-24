package threadsDay1;

/**
 *
 * @author Andreas Heick Laptop
 */
public class Exercise2Tester
{

    public static void main(String[] args) throws InterruptedException
    {

        Thread[] threads = new Thread[5];
        
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(() ->
            {
                int p = 1;
                int t = 1;

                while(p <= 100)
                {
                System.out.println(Thread.currentThread().getName() + " : " + p);
                p++;
                }
            });
            threads[i].start();
            
//            threads[i].join();
//            Thread.sleep(1000);
            
        }
            System.out.println("DONE");
    }
    
    /*
    a) describe the output. Is it what you expected?
    Nope, expected "DONE" to show at the end, not after every thread is DONE, but it looks cool anyway.
    
    b) If the threads do not interleave, can you make them, by making the threads sleep for a short period of time? (think milliseconds).
    Yup
    
    */
}
