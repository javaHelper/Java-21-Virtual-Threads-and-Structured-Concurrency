package org.example;

/**
This will work, now the VM argument
 -Xss1M -Xmx1G
 */

public class MainJacket2 {
    private static void handleUserRequest() {
        System.out.println("Starting thread " + Thread.currentThread());

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Ending thread " + Thread.currentThread());
    }

    public static void main(String[] args) {
        System.out.println("Starting main thread");

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> handleUserRequest()).start();
        }

        System.out.println("Ending main thread");
    }
}