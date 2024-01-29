package com.modernjava.virtualthreads;

import com.util.CommonUtil;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.util.LoggerUtil.log;

public class PinnedVirtualThreads {

    static AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        var counter = new Counter();
        int MAX_THREADS = 10;
        IntStream.rangeClosed(1, MAX_THREADS)
                .forEach((i) -> {
                    //Thread.ofVirtual().start(() -> counter.getAndIncrement(i));
                    Thread.ofVirtual().start(() -> counter.getAndIncrementUsingRentrantLock(i));
                    atomicInteger.incrementAndGet();
                    log("No of threads : " + atomicInteger.get());
                });

        log("Program Completed!");

        CommonUtil.sleep(10000);

    }
}
