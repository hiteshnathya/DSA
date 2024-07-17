package Assignment.Day13;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class PrimeNumberCalculator {
    public static void main(String[] args) throws Exception {
        int maxNumber = 100; // Calculate prime numbers up to this number
        ExecutorService executor = Executors.newFixedThreadPool(4); // Create an ExecutorService with 4 threads

        // Step 1: Calculate prime numbers in parallel using ExecutorService
        List<CompletableFuture<List<Integer>>> futures = new ArrayList<>();
        for (int i = 0; i < maxNumber; i += 25) {
            int start = i;
            int end = Math.min(i + 25, maxNumber);
            CompletableFuture<List<Integer>> future = CompletableFuture.supplyAsync(() -> calculatePrimes(start, end), executor);
            futures.add(future);
        }

        // Step 2: Combine the results of the futures
        CompletableFuture<List<Integer>> combinedFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream().map(CompletableFuture::join).flatMap(List::stream).collect(Collectors.toList()));

        // Step 3: Write the results to a file asynchronously using CompletableFuture
        CompletableFuture<Void> writeFuture = combinedFuture.thenAcceptAsync(primeNumbers -> {
            try (FileWriter writer = new FileWriter("prime_numbers.txt")) {
                for (int prime : primeNumbers) {
                    writer.write(prime + "\n");
                }
                System.out.println("Wrote prime numbers to file");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        });

        // Step 4: Wait for the write operation to complete
        writeFuture.get();

        // Shut down the ExecutorService
        executor.shutdown();
    }

    private static List<Integer> calculatePrimes(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean isPrime(int number) {
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


/* out put is Step 1: Calculate prime numbers in parallel using ExecutorService
Calculating primes from 0 to 25...
Calculating primes from 25 to 50...
Calculating primes from 50 to 75...
Calculating primes from 75 to 100...

Step 2: Combine the results of the futures
Combining results...

Step 3: Write the results to a file asynchronously using CompletableFuture
Writing prime numbers to file...

Step 4: Wait for the write operation to complete
Wrote prime numbers to file

Prime numbers written to file:
2
3
5
7
11
13
17
19
23
29
31
37
41
43
47
53
59
61
67
71
73
79
83
89
97 */