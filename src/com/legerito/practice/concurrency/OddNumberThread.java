package com.legerito.practice.concurrency;

public class OddNumberThread extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i +=2) {
            try {
                Thread.sleep(1000);
                System.out.print(" " + i + " ");
            } catch (InterruptedException e) {
                System.out.println("odd number thread interrupted");
            }
        }
    }
}
