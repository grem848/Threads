package threadsDay1;

/**
 *
 * @author Andreas Heick Laptop
 */
public class Tester
{

    public static void main(String[] args)
    {
        MyThread1 t1 = new MyThread1("T1");
        MyThread1 t2 = new MyThread1("T2");
        t1.start();
        t2.start();
        System.out.println("DONE");
        
        
        
    }

}
