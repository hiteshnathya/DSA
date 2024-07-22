package Day_15.clieneServer;
import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Step 1: Creating a ServerSocket to listen for incoming connections...");
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started. Listening for incoming connections...");

        System.out.println("Step 2: Waiting for an incoming connection...");
        Socket socket = serverSocket.accept();
        System.out.println("Incoming connection accepted");

        System.out.println("Step 3: Creating an ObjectInputStream to receive data from the client...");
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        System.out.println("Step 4: Creating an ObjectOutputStream to send data to the client...");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

        System.out.println("Step 5: Entering the main loop to process incoming requests...");
        while (true) {
            System.out.println("Waiting for a CalculatorOperation object from the client...");
            CalculatorOperation calculatorOperation = (CalculatorOperation) objectInputStream.readObject();
            System.out.println("Received CalculatorOperation object: num1 = " + calculatorOperation.getNum1() + ", num2 = " + calculatorOperation.getNum2() + ", operation = " + calculatorOperation.getOperation());

            System.out.println("Calculating the result...");
            int result = calculateResult(calculatorOperation.getNum1(), calculatorOperation.getNum2(), calculatorOperation.getOperation());
            System.out.println("Result calculated: " + result);

            System.out.println("Sending the result back to the client...");
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
            System.out.println("Result sent successfully");
        }
    }
    private static int calculateResult(int num1, int num2, String operation) {
        System.out.println("Calculating the result for num1 = " + num1 + ", num2 = " + num2 + ", operation = " + operation);
        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new UnsupportedOperationException("Unsupported operation");

        }
    }
}