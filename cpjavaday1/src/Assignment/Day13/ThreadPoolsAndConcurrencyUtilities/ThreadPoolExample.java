package Assignment.Day13.ThreadPoolsAndConcurrencyUtilities;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed-size thread pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Submit multiple tasks
        for (int i = 0; i < 10; i++) {
            CalculatorTask task = new CalculatorTask(i * 10);
            executor.submit(task);
        }

        // Shut down the thread pool
        executor.shutdown();
    }
}