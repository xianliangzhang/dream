package com.god.dream.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Willer on 16/4/4.
 */
public class MyThread {
    private static ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor();

    public static int counter = 0;

    public static void main(String... args) {
        MyThread.EXECUTOR_SERVICE.execute(new Runnable() {
            @Override
            public void run() {
                while (counter < 1000) {
                    System.out.println(++counter + " -- ");
                }
            }
        });
    }
}
