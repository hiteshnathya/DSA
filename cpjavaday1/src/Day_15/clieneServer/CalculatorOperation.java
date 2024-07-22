package Day_15.clieneServer;

import java.io.Serializable;

public class CalculatorOperation implements Serializable {
    private int num1;
    private int num2;
    private String operation;

    public CalculatorOperation(int num1, int num2, String operation) {
        System.out.println("Step 1: Creating a CalculatorOperation object...");
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        System.out.println("CalculatorOperation object created with num1 = " + num1 + ", num2 = " + num2 + ", and operation = " + operation);
    }

    public int getNum1() {
        System.out.println("Getting num1...");
        return num1;
    }

    public int getNum2() {
        System.out.println("Getting num2...");
        return num2;
    }

    public String getOperation() {
        System.out.println("Getting operation...");
        return operation;
    }
}