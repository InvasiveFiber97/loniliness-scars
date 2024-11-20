package com.legerito.practice.concurrency;

public class CustomThread extends Thread{

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
            System.out.print(" 1 ");
            try {
                Thread.sleep(500);
//                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
