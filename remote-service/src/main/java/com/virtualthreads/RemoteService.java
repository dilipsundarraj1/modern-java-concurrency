package com.virtualthreads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RemoteService {
    private static final Logger log = LoggerFactory.getLogger(RemoteService.class);
    public static void main(String[] args) {
        SpringApplication.run(RemoteService.class, args);
        log.info("Started the RemoteService App!");

    }
}