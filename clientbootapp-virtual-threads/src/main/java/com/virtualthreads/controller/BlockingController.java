package com.virtualthreads.controller;


import com.virtualthreads.client.RemoteServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlockingController {

    private static final Logger log = LoggerFactory.getLogger(BlockingController.class);

    private final RemoteServiceClient remoteServiceClient;

    public BlockingController(RemoteServiceClient remoteServiceClient) {
        this.remoteServiceClient = remoteServiceClient;
    }

    @GetMapping("/blocking/{seconds}")
    public ResponseEntity<String> block(@PathVariable("seconds") Integer seconds) throws InterruptedException {
        log.info("Received the request with seconds : {} ", seconds);
        return  ResponseEntity.ok(remoteServiceClient.invokeBlockingService(seconds));
    }

    @GetMapping("/currentThread")
    public String currentThread() {
        return  Thread.currentThread().toString();
    }
}
