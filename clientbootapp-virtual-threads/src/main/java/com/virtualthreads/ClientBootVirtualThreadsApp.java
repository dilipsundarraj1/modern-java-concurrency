package com.virtualthreads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ClientBootVirtualThreadsApp {
    private static final Logger log = LoggerFactory.getLogger(ClientBootVirtualThreadsApp.class);

    @Value("${spring.threads.virtual.enabled:false}")
    private boolean virtualThreadFlag;

    public static void main(String[] args) {
        SpringApplication.run(ClientBootVirtualThreadsApp.class, args);
        log.info("availableProcessors = {} ", Runtime.getRuntime().availableProcessors());


    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        log.info("virtualThreadFlag : {} ", virtualThreadFlag);
        if (virtualThreadFlag) {
            log.info("Started the Client App in Tomcat virtual thread mode !");
        } else {
            log.info("Started the Client App in Tomcat thread pool mode !");
        }
    }
}