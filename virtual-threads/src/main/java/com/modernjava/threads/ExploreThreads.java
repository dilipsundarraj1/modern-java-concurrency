package com.modernjava.threads;

import com.util.CommonUtil;

import static com.util.LoggerUtil.log;

public class ExploreThreads {
    public static void doSomeWork() {
        log("started doSomeWork");
        CommonUtil.sleep(1000);
        log("finished doSomeWork");
    }

    public static void main(String[] args) {

        var thread1 = Thread.ofPlatform().name("t1");
        var thread2 = Thread.ofPlatform().name("t2");
//                .unstarted(() -> doSomeWork());

        thread1.start(() -> {
            // CommonUtil.delay(5000);
            log("Run task1 in the background");

        });
        log("Is it a daemon ?"+ thread1.daemon());
        thread2.start(ExploreThreads::doSomeWork);

        log("Program Completed!");

    }
}
