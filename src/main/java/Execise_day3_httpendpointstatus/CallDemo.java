/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Execise_day3_httpendpointstatus;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

/**
 *
 * @author rasmu
 */
public class CallDemo implements Callable<String>{

    
    
    String url;

    public CallDemo(String url) {
        this.url = url;
    }
             
    @Override
     public String call() throws Exception {
         String result = "Error";
        try {
            
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            if (code == 200) {
                result = "Green";
            }
            if (code == 301) {
                result = "Redirect";
            }
        } catch (Exception e) {
            result = "->Red<-";
        }
        return result;
              
        
        
    }
    
}
