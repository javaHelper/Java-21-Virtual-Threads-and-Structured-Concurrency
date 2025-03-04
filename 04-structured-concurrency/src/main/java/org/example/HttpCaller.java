package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpCaller {
    
    private static final HttpClient client = HttpClient.newHttpClient();
    
    private final String callName;

    public HttpCaller(String callName) {
        this.callName = callName;
    }
    
    public String makeCall(int secs) throws InterruptedException {
        
        System.out.println(callName + " : BEG call : " + Thread.currentThread());
        
        try {
            URI uri = new URI("http://httpbin.org/delay/" + secs);
            HttpRequest request = HttpRequest.newBuilder().GET().uri(uri).build();
            
            /* Will throw InterruptedException when interrupted */
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body();
        }
        catch (IOException | URISyntaxException exp) {
            throw new RuntimeException(exp);
        }
        finally {
            System.out.println(callName + " : END call : " + Thread.currentThread());
        }
        
    }

}