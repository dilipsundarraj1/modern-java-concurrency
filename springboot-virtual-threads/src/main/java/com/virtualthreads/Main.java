package com.virtualthreads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("availableProcessors = " + Runtime.getRuntime().availableProcessors());
        var tomcatThreads = System.getProperty("server.tomcat.threads.max");
        System.out.println("tomcatThreads : "+ tomcatThreads );
    }
}