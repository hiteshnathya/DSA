package Day_15.networking;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientEx
{
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("local host", 9999);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            String s = "Calculate";
            Calculation obj = new Calculation(20, 30, "*");
            System.out.println("X: "+obj.getX()+"Y: "+obj.getY()+"Operation: "+obj.getOperation());
            out.writeObject(obj);
            /* out.flush(); */
            ObjectInputStream oi = new ObjectInputStream(socket.getInputStream());

            int responseResult = oi.readInt();
            System.out.println("The result is: "+responseResult);

        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}