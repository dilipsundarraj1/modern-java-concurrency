package com.virtualthreads.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class RemoteServiceClient {
    private static final Logger log = LoggerFactory.getLogger(RemoteServiceClient.class);

    private final RestClient restClient;

    public RemoteServiceClient(RestClient.Builder builder ) {
        this.restClient = builder.build();
    }

    public String invokeBlockingService(Integer seconds){
        log.info("Current Executing Thread : {} ", Thread.currentThread());
        var response = restClient
                .get()
                .uri("http://localhost:8085/remote/"+seconds)
                .retrieve()
                .toEntity(String.class);
        log.info("response : {} , and the Thread is {}", response.getStatusCode(), Thread.currentThread());

        return response.getBody();

    }
}
