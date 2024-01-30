package com.modernjava.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

import static com.modernjava.util.LoggerUtil.log;
import static java.net.http.HttpRequest.newBuilder;

public class CommonUtil {

    public static final HttpClient httpClient = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(2))
            .build();

    public  static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    public static HttpRequest requestBuilder(String url) {
        return newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET() // default (could leave that out)
                .build();
    }

    public static void sleep(long delayMilliSeconds)  {
        try{
            Thread.sleep(delayMilliSeconds);
        }catch (Exception e){
            log("Exception is :" + e.getMessage());
        }

    }


    public static  int noOfCores(){
        return Runtime.getRuntime().availableProcessors();
    }
}
