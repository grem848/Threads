package Execise1_day2.webscraper;

public class Tester {

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();

        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
        TagCounter tc1 = new TagCounter("http://www.fck.dk");
        tc1.start();
        TagCounter tc2 = new TagCounter("http://www.google.com");
        tc2.start();
        TagCounter tc3 = new TagCounter("http://politiken.dk/");
        tc3.start();

//        tc1.run();
//        tc2.run(); // Time Sequential: 2911846237 2.9 sek
//        tc3.run();

        tc1.join();
        tc2.join(); // Time Sequential: 1640934628 1.6 sek
        tc3.join();

        long end = System.nanoTime();
        System.out.println("Time Sequential: " + (end - start));

        System.out.println("Title: " + tc1.getTitle());
        System.out.println("Div's: " + tc1.getDivCount());
        System.out.println("Body's: " + tc1.getBodyCount());

        System.out.println("Title: " + tc2.getTitle());
        System.out.println("Div's: " + tc2.getDivCount());
        System.out.println("Body's: " + tc2.getBodyCount());

        System.out.println("Title: " + tc3.getTitle());
        System.out.println("Div's: " + tc3.getDivCount());
        System.out.println("Body's: " + tc3.getBodyCount());
    }
}

