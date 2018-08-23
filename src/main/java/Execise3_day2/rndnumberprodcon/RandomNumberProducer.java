package Execise3_day2.rndnumberprodcon;

import java.util.concurrent.ArrayBlockingQueue;


public class RandomNumberProducer implements Runnable{

  public static final int MAX_NUMBERS_TO_PRODUCE = 100;
  public static final int MAX_RANDOM = 100;

  ArrayBlockingQueue<Integer> numbersProduced;

  public RandomNumberProducer(ArrayBlockingQueue<Integer> numbersProduced) {
    this.numbersProduced = numbersProduced;
  }
  
  @Override
  public void run() {
    int MAX_RAND = 2;
    for (int i = 0; i < 10; i++) {
    int random = (int) ((Math.random()* MAX_RAND+1));
    numbersProduced.offer(random);
  }
  
//Todo: Produce MAX_NUMBERS_TO_PRODUCE of random numbers between 0 and MAX_RANDOM and
//      place the numbers in numbersProduced
 

  
  
}
}