package Assignment.Day13.ThreadIncrementDecrement;

import java.util.concurrent.atomic.AtomicReference;

// Thread-safe Counter class using AtomicInteger


// Main class to demonstrate usage
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        AtomicReference<Data> data = new AtomicReference<>(new Data(0));

        // Create 5 threads to increment and decrement the counter
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    counter.increment();
                    System.out.println("Incremented: " + counter.getCount());
                    data.set(new Data(counter.getCount())); // create a new immutable Data object
                    System.out.println("Data value: " + data.get().getValue());
                    counter.decrement();
                    System.out.println("Decremented: " + counter.getCount());
                }
            });
        }

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Final count: " + counter.getCount());
    }
}