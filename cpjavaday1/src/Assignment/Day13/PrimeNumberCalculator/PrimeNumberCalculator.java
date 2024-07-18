package Assignment.Day13.PrimeNumberCalculator;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PrimeNumberCalculator {
    public static void main(String[] args) throws IOException {
        int maxNumber = 100000; // calculate prime numbers up to this number
        int numThreads = 4; // number of threads to use

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        List<Future<List<Integer>>> futuresList = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            int start = i * (maxNumber / numThreads);
            int end;
            if (i == numThreads - 1) {
                end = maxNumber;
            } else {
                end = (i + 1) * (maxNumber / numThreads);
            }
            Callable<List<Integer>> task = () -> calculatePrimes(start, end);
            Future<List<Integer>> future = executor.submit(task);
            futuresList.add(future);
        }

        executor.shutdown();

        final List<Future<List<Integer>>> futures = futuresList; // declare a final variable

        CompletableFuture<Void> writeFuture = CompletableFuture.allOf(futures.stream()
                        .map(future -> CompletableFuture.completedFuture(future))
                        .toArray(CompletableFuture[]::new))
                .thenRunAsync(() -> {
                    List<Integer> primes = new ArrayList<>();
                    for (Future<List<Integer>> future : futures) {
                        try {
                            primes.addAll(future.get());
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                    writePrimesToFile(primes, "primes.txt");
                });

        try {
            writeFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
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

    private static void writePrimesToFile(List<Integer> primes, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Integer prime : primes) {
                writer.write(prime + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}