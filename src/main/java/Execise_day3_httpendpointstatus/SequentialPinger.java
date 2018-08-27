/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execise_day3_httpendpointstatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//omkring 29 sekunder.

public class SequentialPinger
{

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {

        ArrayBlockingQueue<String> urls = new ArrayBlockingQueue(20);

        urls.add("http://cphbusiness.com");
        urls.add("http://yahoo.com");
        urls.add("http://crunchify.com");
        urls.add("http://www.ebay.com");
        urls.add("http://www.example.com");
        urls.add("https://paypal.com");
        urls.add("http://bing.com");
        urls.add("http://techcrunch.com");
        urls.add("http://thenextweb.com");
        urls.add("http://wordpress.com");
        urls.add("http://example.com");
        urls.add("http://sjsu.com");
        urls.add("http://ebay.com");
        urls.add("http://wikipedia.com");
        urls.add("http://phoronix.com");
        urls.add("http://stackoverflow.com");
        urls.add("http://dr.dk");
        urls.add("http://studypoint-plaul.rhcloud.com");
        urls.add("http://imgur.com");

        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<String>> list = new ArrayList<>();

        for (String url : urls)
        {
            Callable<String> callable = new CallDemo(url);

            Future<String> future = executor.submit(callable);

            list.add(future);
        }

        for (Future<String> fut : list)
        {
            try
            {

                String getUrl = urls.poll();
                String status = fut.get();

                System.out.println(getUrl + "\t\tStatus:" + status);

            } catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
