package org.example.threads.demo;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class ExampleLambda {
    public static void main(String[] args) {
        System.out.println("Starting Main Thread ..");

        Thread.ofPlatform().start(() -> {
            System.out.println("Starting Simple Thread");

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Ending Simple Thread");
        });
        System.out.println("Ending Main Thread ..");
    }
}