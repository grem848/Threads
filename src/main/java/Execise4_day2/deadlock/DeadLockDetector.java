/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execise4_day2.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;

/**
 *
 * @author rasmu
 */
public class DeadLockDetector extends Thread {

    ThreadMXBean bean = ManagementFactory.getThreadMXBean();
    boolean done = false;

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public void run() {
        while (done == false) {
            long[] threadIds = bean.findDeadlockedThreads();
            System.out.println("Deadlock found: " + Arrays.toString(threadIds));
            //...
        }
    }

}
