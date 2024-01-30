package com.virtualthreads.controller;


import com.virtualthreads.client.BlockingServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class BlockingController {

    private static final Logger log = LoggerFactory.getLogger(BlockingController.class);

    private final BlockingServiceClient blockingServiceClient;

    public BlockingController(BlockingServiceClient blockingServiceClient) {
        this.blockingServiceClient = blockingServiceClient;
    }

    @GetMapping("/blocking/{seconds}")
    public ResponseEntity<String> block(@PathVariable("seconds") Integer seconds) throws InterruptedException {
        log.info("Received the request with seconds : {} ", seconds);
        return  blockingServiceClient.invokeBlockingService(seconds);

    }
}
