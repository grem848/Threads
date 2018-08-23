package Execise4_day2.deadlock;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Tester {

    public static void main(String[] args) {

        try {

            DeadLockDetector dld = new DeadLockDetector();
            dld.start();
        //found out that the problem was with tread with id = 12 meaning that it was ResourceUser2
            
            ResourceContainer resources = new ResourceContainer();
            ResourceUser1 t1 = new ResourceUser1(resources);
            ResourceUser2 t2 = new ResourceUser2(resources);

            t1.start();
            t2.start();

            t1.join();
            t2.join();
            
            dld.setDone(true);
            System.out.println("Done");
            System.out.println("Words produced: " + resources.getResourceWords().size());
            System.out.println("Numbers produced: " + resources.getResourceNumbers().size());
        } catch (InterruptedException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
