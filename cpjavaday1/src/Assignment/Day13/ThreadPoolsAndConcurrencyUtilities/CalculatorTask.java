package Assignment.Day13.ThreadPoolsAndConcurrencyUtilities;

import java.util.concurrent.Callable;

public class CalculatorTask implements Callable<Integer> {
    private int number;

    public CalculatorTask(int number) {
        this.number = number;
    }

    @Override
    public Integer call() {
        // Simulate a complex calculation
        int result = 0;
        for (int i = 0; i < number; i++) {
            result += i * i;
        }
        System.out.println("Task " + number + " completed");
        return result;
    }
}