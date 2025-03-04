package org.example;

import java.util.ArrayList;

/**
 Starting main thread
 Ending main thread
 Starting thread VirtualThread[#21]/runnable@ForkJoinPool-1-worker-1
 Starting thread VirtualThread[#26]/runnable@ForkJoinPool-1-worker-3
 Starting thread VirtualThread[#28]/runnable@ForkJoinPool-1-worker-7
 Starting thread VirtualThread[#25]/runnable@ForkJoinPool-1-worker-4
 Starting thread VirtualThread[#29]/runnable@ForkJoinPool-1-worker-6
 Starting thread VirtualThread[#23]/runnable@ForkJoinPool-1-worker-2

 Process finished with exit code 0
 */

public class MainJacket {
    private static void handleUserRequest() {
        //System.out.println("Starting thread " + Thread.currentThread());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //System.out.println("Ending thread " + Thread.currentThread());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting main "+Thread.currentThread());

        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 2000000; i++) {
            threads.add(startThread());
        }

        // join on the threads
        for (Thread thread: threads) {
            thread.join();
        }

        System.out.println("Ending main thread");
    }

    private static Thread startThread() {
        //new Thread(() -> handleUserRequest()).start();

        return Thread.startVirtualThread(() -> handleUserRequest());
    }
}