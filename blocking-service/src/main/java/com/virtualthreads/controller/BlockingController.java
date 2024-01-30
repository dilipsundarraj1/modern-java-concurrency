package com.virtualthreads.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/blocking")
public class BlockingController {
    AtomicInteger atomicInteger= new AtomicInteger();
    @GetMapping("/{seconds}")
    public ResponseEntity<String> block(@PathVariable("seconds") Integer seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
        System.out.println("Response Complete");
        var invokeCount = atomicInteger.incrementAndGet();
        System.out.println("invokeCount = " + invokeCount);
        return ResponseEntity.ok("Hello");
    }
}
