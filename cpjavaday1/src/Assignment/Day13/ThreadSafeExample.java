package Assignment.Day13;
// Thread-safe Counter class
class Counter {
    private int count = 0;

    public synchronized int increment() {
        return ++count;
    }

    public synchronized int decrement() {
        return --count;
    }

    public synchronized int getCount() {
        return count;
    }
}

// Immutable Data class
final class Data {
    private final int value;

    public Data(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class ThreadSafeExample {
    public static void main(String[] args) throws InterruptedException {
        // Create a thread-safe Counter instance
        Counter counter = new Counter();

        // Create multiple threads to increment and decrement the counter
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.decrement();
            }
        });

        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();

        // Print the final count
        System.out.println("Final count: " + counter.getCount());

        // Create an immutable Data instance
        Data data = new Data(42);

        // Create multiple threads to access the immutable data
        Thread thread3 = new Thread(() -> {
            System.out.println("Thread 3: " + data.getValue());
        });

        Thread thread4 = new Thread(() -> {
            System.out.println("Thread 4: " + data.getValue());
        });

        thread3.start();
        thread4.start();

        // Wait for both threads to finish
        thread3.join();
        thread4.join();
    }
}