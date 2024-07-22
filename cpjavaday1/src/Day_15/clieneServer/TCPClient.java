package Day_15.clieneServer;
import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Step 1: Creating a socket to connect to the server...");
        Socket socket = new Socket("localhost", 8000);
        System.out.println("Connected to server");

        System.out.println("Step 2: Creating an ObjectOutputStream to send data to the server...");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

        System.out.println("Step 3: Creating an ObjectInputStream to receive data from the server...");
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        System.out.println("Step 4: Creating a CalculatorOperation object to send to the server...");
        CalculatorOperation calculatorOperation = new CalculatorOperation(2, 2, "+");

        System.out.println("Step 5: Sending the CalculatorOperation object to the server...");
        objectOutputStream.writeObject(calculatorOperation);
        objectOutputStream.flush();

        System.out.println("Step 6: Waiting for the result from the server...");
        int result = (int) objectInputStream.readObject();
        System.out.println("Result: " + result);
    }
}