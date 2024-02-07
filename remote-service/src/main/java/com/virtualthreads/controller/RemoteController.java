package com.virtualthreads.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/remote")
public class RemoteController {

    private static final Logger log = LoggerFactory.getLogger(RemoteController.class);
    AtomicInteger atomicInteger= new AtomicInteger();
    @GetMapping("/{seconds}")
    public ResponseEntity<String> block(@PathVariable("seconds") Integer seconds) throws InterruptedException {
        Thread.sleep(seconds*1000); // Blocks the tomcat-thread for n seconds
        var invokeCount = atomicInteger.incrementAndGet();
        log.info("invokeCount : {} " ,  invokeCount);
        return ResponseEntity.ok("Hello, delayed by "+ seconds + " seconds.");
    }
}
