package org.example;

/**
 Starting main thread
 Ending main thread
 Starting thread Thread[#21,Thread-0,5,main]
 Ending thread Thread[#21,Thread-0,5,main]
 */

public class MainJacket {
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
        new Thread(() -> handleUserRequest()).start();
        System.out.println("Ending main thread");
    }
}