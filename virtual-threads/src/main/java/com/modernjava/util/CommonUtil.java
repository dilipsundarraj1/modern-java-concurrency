package com.modernjava.util;


import static com.modernjava.util.LoggerUtil.log;

public class CommonUtil {
    public static void sleep(long delayMilliSeconds)  {
        try{
            Thread.sleep(delayMilliSeconds);
        }catch (Exception e){
            log("Exception is :" + e.getMessage());
        }

    }

    public static  int noOfCores(){
        return Runtime.getRuntime().availableProcessors();
    }
}
