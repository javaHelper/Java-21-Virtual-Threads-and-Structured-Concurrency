package org.example;


public class VirtualThreadsWithVirtualBuilder {
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

        playWithVirtualBuilder();

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
    private static void playWithVirtualBuilder() throws InterruptedException {
        // Create a Virtual Builder object with name and initial index
        Thread.Builder.OfVirtual vBuilder = Thread.ofVirtual().name("userthread", 0);

        // Start two virtual threads using the builder
        Thread vThread1 = vBuilder.start(VirtualThreadsWithVirtualBuilder::handleRequest);
        Thread vThread2 = vBuilder.start(VirtualThreadsWithVirtualBuilder::handleRequest);

        // Make sure the threads terminate
        vThread1.join();
        vThread2.join();
    }
}