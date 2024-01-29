package com.modernjava.threads;

import com.util.CommonUtil;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.util.LoggerUtil.log;

public class MaxThreads {

    static AtomicInteger atomicInteger = new AtomicInteger();

    public static void doSomeWork(int index) {
        log("started doSomeWork : " + index);
        //Any task that's started by a thread is blocked until it completes.
        //It could be any IO call such as HTTP or File IO call.
        CommonUtil.sleep(5000);
        log("finished doSomeWork : " + index);
    }

    public static void main(String[] args) {
        int MAX_THREADS =10000;
        // For 1024 MB
        // Run with this thread count and show the outOfMemory error -> 1000, 5000, 10000
        //java.lang.OutOfMemoryError -> at Thread-8171

        //int MAX_THREADS = 10;
        //Demo 2- Blocking nature of Java Threads
        // Change the no of MAX_THREADS to 10
        // Enable the loggers
        IntStream.rangeClosed(1, MAX_THREADS)
                .forEach((i) -> {
                    var threads = Thread.ofPlatform().start(() -> MaxThreads.doSomeWork(i));
                    atomicInteger.incrementAndGet();
                    log("No of threads : " + atomicInteger.get());
                });

        log("Program Completed!");

    }
}
