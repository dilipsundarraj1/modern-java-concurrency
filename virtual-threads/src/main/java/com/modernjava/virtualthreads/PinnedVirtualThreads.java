package com.modernjava.virtualthreads;

import com.modernjava.util.CommonUtil;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static com.modernjava.util.LoggerUtil.log;

public class PinnedVirtualThreads {


    public static void main(String[] args) {

        log("Program Completed!");
        CommonUtil.sleep(10000);

    }
}
