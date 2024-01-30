package com.modernjava.virtualthreads;


import com.modernjava.util.CommonUtil;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.modernjava.util.LoggerUtil.log;

public class MaxVirtualThreads {

    static AtomicInteger atomicInteger = new AtomicInteger();

    public static void doSomeWork(int index) {
        log("started doSomeWork : " + index);
        // In this case, we are just blocking the thread by calling sleep.
        //It could be any IO call such as HTTP or File IO call.
        CommonUtil.sleep(5000); // blocking task
        log("finished doSomeWork : " + index);
    }

    public static void main(String[] args) {
        //int MAX_THREADS =1000_000; //10000, 100_000, 1000_000
        // For 1024 MB
        // Run with this thread count and show the outOfMemory error -> 1000, 5000, 10000
        //java.lang.OutOfMemoryError -> at Thread-8171

        int MAX_THREADS = 10;
        //Demo 2- Blocking nature of Java Threads
        // Change the no of MAX_THREADS to 10
        // Enable the loggers
        IntStream.rangeClosed(1, MAX_THREADS)
                .forEach((i) -> {
                    var threads = Thread.ofVirtual().start(() -> MaxVirtualThreads.doSomeWork(i));
                    atomicInteger.incrementAndGet();
                    log("No of threads : " + atomicInteger.get());
                });

        log("Program Completed!");

        CommonUtil.sleep(10000);

    }
}
