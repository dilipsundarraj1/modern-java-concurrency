package com.modernjava.util;

import static com.util.LoggerUtil.log;

public class CommonUtil {
    public static void sleep(long delayMilliSeconds)  {
        try{
            Thread.sleep(delayMilliSeconds);
        }catch (Exception e){
            log("Exception is :" + e.getMessage());
        }

    }

    public static String transForm(String s) {
        CommonUtil.sleep(500);
        return s.toUpperCase();
    }

    public static void startTimer(){
        //stopWatchReset();
       // stopWatch.start();
    }

    public static void timeTaken(){
      //  stopWatch.stop();
       // log("Total Time Taken : " +stopWatch.getTime());
    }

//    public static void stopWatchReset(){
//        stopWatch.reset();
//    }

    public static  int noOfCores(){
        return Runtime.getRuntime().availableProcessors();
    }
}
