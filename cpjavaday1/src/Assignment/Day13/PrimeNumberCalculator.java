package Assignment.Day13;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class PrimeNumberCalculator {
    public static void main(String[] args) throws Exception {
        int maxNumber = 100000; // Calculate prime numbers up to this number
        String outputFile = "prime_numbers.txt"; // Output file

        System.out.println("Step 1: Creating an ExecutorService with 4 threads");
        // Create an ExecutorService with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("Step 2: Creating a list to store the prime numbers");
        // Create a list to store the prime numbers
        List<Integer> primeNumbers = new ArrayList<>();

        System.out.println("Step 3: Submitting tasks to calculate prime numbers in parallel");
        // Submit tasks to calculate prime numbers in parallel
        List<CompletableFuture<List<Integer>>> futures = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int start = i * (maxNumber / 4);
            int end = (i + 1) * (maxNumber / 4);
            Supplier<List<Integer>> supplier = new PrimeNumberTask(start, end, primeNumbers);
            CompletableFuture<List<Integer>> future = CompletableFuture.supplyAsync(supplier, executor);
            futures.add(future);
        }

        System.out.println("Step 4: Waiting for all tasks to complete");
        // Wait for all tasks to complete
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.get();

        System.out.println("Step 5: Writing the prime numbers to a file asynchronously");
        // Write the prime numbers to a file asynchronously
        CompletableFuture.runAsync(() -> {
            try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
                for (Integer prime : primeNumbers) {
                    writer.println(prime);
                }
                System.out.println("Prime numbers written to " + outputFile);
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }, executor);

        System.out.println("Step 6: Shutting down the ExecutorService");
        // Shut down the ExecutorService
        executor.shutdown();
    }
}

class PrimeNumberTask implements Supplier<List<Integer>> {
    private int start;
    private int end;
    private List<Integer> primeNumbers;

    public PrimeNumberTask(int start, int end, List<Integer> primeNumbers) {
        this.start = start;
        this.end = end;
        this.primeNumbers = primeNumbers;
    }

    @Override
    public List<Integer> get() {
        System.out.println("Calculating prime numbers from " + start + " to " + end);
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
        System.out.println("Prime numbers calculated from " + start + " to " + end);
        return primeNumbers;
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}