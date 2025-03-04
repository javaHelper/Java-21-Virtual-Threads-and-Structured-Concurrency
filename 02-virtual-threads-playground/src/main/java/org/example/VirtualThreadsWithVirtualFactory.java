package org.example;


import java.util.concurrent.ThreadFactory;

public class VirtualThreadsWithVirtualFactory {
    private static void handleRequest(){
        System.out.println("Starting thread "+ Thread.currentThread());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ending thread "+ Thread.currentThread());
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting main");

        playWithFactory();

        System.out.println("Ending main");
    }

    /**
     Starting main
     Starting thread VirtualThread[#23,userthread1]/runnable@ForkJoinPool-1-worker-2
     Starting thread VirtualThread[#21,userthread0]/runnable@ForkJoinPool-1-worker-1
     Ending thread VirtualThread[#21,userthread0]/runnable@ForkJoinPool-1-worker-1
     Ending thread VirtualThread[#23,userthread1]/runnable@ForkJoinPool-1-worker-2
     Ending main
     */
    private static void playWithFactory() throws InterruptedException {
        ThreadFactory factory = Thread.ofVirtual().name("userthread", 0).factory();

        Thread thread1 = factory.newThread(VirtualThreadsWithVirtualFactory::handleRequest);
        thread1.start();

        Thread thread2 = factory.newThread(VirtualThreadsWithVirtualFactory::handleRequest);
        thread2.start();

        thread1.join();
        thread2.join();
    }
}