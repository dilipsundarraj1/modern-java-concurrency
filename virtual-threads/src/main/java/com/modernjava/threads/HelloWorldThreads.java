package com.modernjava.threads;


import static com.modernjava.util.CommonUtil.sleep;

public class HelloWorldThreads {
    private static String result="";

    private static void hello(){
        sleep(500);
        result = result.concat("Hello");

    }
    private static void world(){
        sleep(600);
        result = result.concat("World");
    }

    public static void main(String[] args) throws InterruptedException {

        //Starting the thread
        var helloThread = Thread.ofPlatform().name("t1")
                .start(HelloWorldThreads::hello);
        var worldThread = Thread.ofPlatform().name("t2")
                .start(HelloWorldThreads::world);


        //Joining the thread (Waiting for the threads to finish)
        helloThread.join();
        worldThread.join();

        System.out.println("Result is : " + result);

    }
}
