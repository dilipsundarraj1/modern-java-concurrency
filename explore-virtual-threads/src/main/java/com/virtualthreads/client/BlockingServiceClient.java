package com.virtualthreads.client;


import com.virtualthreads.controller.BlockingController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class BlockingServiceClient {
    private static final Logger log = LoggerFactory.getLogger(BlockingServiceClient.class);

    private final RestClient restClient;

    public BlockingServiceClient(RestClient.Builder builder ) {
        this.restClient = builder.build();
    }

    public ResponseEntity<String> invokeBlockingService(Integer seconds){
        var response = restClient
                .get()
                .uri("http://localhost:8085/blocking/"+seconds)
                .retrieve()
                .toEntity(String.class);
        log.info("response : {} , and the Thread is {}", response.getStatusCode(), Thread.currentThread().getName());

        return response;

    }
}
