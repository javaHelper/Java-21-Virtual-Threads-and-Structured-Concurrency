package org.example.threads.demo;

import org.example.threads.SimpleRunnable;

public class ExampleRunnableFluent {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Main Thread ..");

        Runnable runnable = new SimpleRunnable();
        Thread thread = Thread.ofPlatform()
                .name("Simple")
                .daemon(true)
                .start(runnable);
        thread.join();

        System.out.println("Ending Main Thread ..");
    }
}