package Day_15.serealisation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerealisationEx {
    public static void main(String[] args) throws IOException {
        Employee emp1=new Employee(111,"ram",21);
        FileOutputStream fo= new FileOutputStream("C:\\Users\\natha\\Desktop\\ASSIGNMENT\\foleIO\\Employee.ser");
        ObjectOutputStream out=new ObjectOutputStream(fo);
        out.writeObject(emp1);
        System.out.println(" Serealization done for the employee  int tha file Employee.ser : ");
        out.close();



    }
}
