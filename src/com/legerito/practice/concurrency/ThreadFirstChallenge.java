package com.legerito.practice.concurrency;

public class ThreadFirstChallenge {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();

        OddNumberThread oddNumberThread = new OddNumberThread();

        Runnable evenNumberRunnanble = () -> {
            for (int i = 2; i <= 10; i +=2) {
                try {
                    Thread.sleep(500);
                    System.out.print(" " + i + " ");
                } catch (InterruptedException e) {
                    System.out.println("even number thread interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread evenNumberThread = new Thread(evenNumberRunnanble);

        oddNumberThread.start();
        evenNumberThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        evenNumberThread.interrupt();
    }
}
