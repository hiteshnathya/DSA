package Day_15.serealisation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fi=new FileInputStream("C:\\Users\\natha\\Desktop\\ASSIGNMENT\\foleIO\\Employee.ser");
        ObjectInputStream oi=new ObjectInputStream(fi);
        Employee e=(Employee) oi.readObject();
        System.out.println(" Deserialization Object Value "+" \n "+ e.toString());



    }
}
