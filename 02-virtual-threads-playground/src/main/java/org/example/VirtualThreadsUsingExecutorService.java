package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class VirtualThreadsUsingExecutorService {
    private static void handleUserRequest() {
        System.out.println("Starting thread " + Thread.currentThread());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Ending thread " + Thread.currentThread());

    }

    public static void main(String[] args) {
        System.out.println("Starting main");

        playWithVirtualExecutorService();

        System.out.println("Ending main");
    }

    private static void playWithVirtualExecutorService() {
        // Create a Virtual Thread factory with custom name
        ThreadFactory factory
                = Thread.ofVirtual().name("userthread", 0).factory();

        try(ExecutorService executorService = Executors.newThreadPerTaskExecutor(factory)){

            // Submit two tasks to the Executor service
            executorService.submit(VirtualThreadsUsingExecutorService::handleUserRequest);
            executorService.submit(VirtualThreadsUsingExecutorService::handleUserRequest);
        }
    }
}