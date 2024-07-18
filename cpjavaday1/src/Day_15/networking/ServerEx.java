import Day_15.networking.Calculation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(9999);
        while (true) {
            Socket client = serverSocket.accept();
            System.out.println("Connected");

            // ObjectInputStream to read the Calculation object
            ObjectInputStream oi = new ObjectInputStream(client.getInputStream());
            Calculation ob = (Calculation) oi.readObject();
            int result = 0;
            int a = ob.getX();
            int b = ob.getY();
            String operation = ob.getOperation();

            switch (operation) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b != 0) {
                        result = a / b;
                    } else {
                        System.out.println("Division by zero is not allowed.");
                        result = 0;
                    }
                    break;
                default:
                    System.out.println("Invalid operation.");
                    result = -1;
                    break;
            }
            // ObjectOutputStream to write the result back to the client
            ObjectOutputStream o = new ObjectOutputStream(client.getOutputStream());
            o.writeObject(result);
            o.flush();

            // Close the client connection
            client.close();}

    }
}

