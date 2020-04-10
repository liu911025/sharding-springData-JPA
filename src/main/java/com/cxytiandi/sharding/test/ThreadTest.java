package com.cxytiandi.sharding.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadTest {

    public static void main(String[] args) {
        /*try {
            Thread thread = new Thread(new ThreadExceptionRunner(), "子线程");
            thread.start();
        }catch (Exception e) {
            System.out.println("主线程异常!");
            e.printStackTrace();
        }*/
        System.out.println(123);
        ExecutorService exec = Executors.newCachedThreadPool(new HandleThreadFactory());
        exec.execute(new ThreadExceptionRunner());
        exec.shutdown();
    }

}

class ThreadExceptionRunner implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException(Thread.currentThread().getName() + "--->>>抛个异常...");
    }
}

class MyUncaughtExceptionHandle implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName() + "--->caught:" + e);
    }
}

class HandleThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println("create thread t");
        Thread t = new Thread(r);
        System.out.println("set uncaughtException for t");
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandle());
        return t;
    }
}