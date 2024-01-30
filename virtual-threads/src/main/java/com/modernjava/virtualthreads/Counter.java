package com.modernjava.virtualthreads;

import com.modernjava.util.CommonUtil;

import java.util.concurrent.locks.ReentrantLock;

import static com.modernjava.util.LoggerUtil.log;

public class Counter {
    private int counter;

    private final ReentrantLock reentrantLock = new ReentrantLock();

    private final Object lock = new Object();
    public int getAndIncrement(int index ) {
        synchronized (lock) {
            log("started doSomeWork : " + index);
            CommonUtil.sleep(1000);
            log("finished doSomeWork : " + index);
            return counter++;
        }
    }

    public int getAndIncrementUsingRentrantLock(int index ) {
        reentrantLock.lock();
        try {
            log("started doSomeWork : " + index);
            CommonUtil.sleep(1000);
            log("finished doSomeWork : " + index);
            return counter++;
        }finally {
            reentrantLock.unlock();
        }
    }

}
