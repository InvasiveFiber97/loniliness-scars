package com.legerito.practice.concurrency;

import java.util.concurrent.TimeUnit;

public class ThreadsMain {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        printThreadState(thread);

        CustomThread customThread = new CustomThread();
        customThread.start();

        Runnable runnable = () -> {
            for (int i = 1; i < 9; i++) {
                System.out.print(" 2 ");
                try {
                    TimeUnit.MILLISECONDS.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread runnableThread = new Thread(runnable);
        runnableThread.start();

        for (int i = 1; i < 4; i++) {
            System.out.print(" 0 ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void printThreadState(Thread thread) {
        System.out.println("-".repeat(20));
        System.out.println("Thread ID: " + thread.getId());
        System.out.println("Thread Name: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
        System.out.println("Thread State: " + thread.getState());
        System.out.println("Thread Group: " + thread.getThreadGroup());
        System.out.println("Thread Is Alive: " + thread.isAlive());
        System.out.println("-".repeat(20));
    }
}
