package Assignment.Day15.SerializationandDeserialization;

import Assignment.Day15.SerializationandDeserialization.Employee1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample {
    public static void main(String[] args) throws IOException {
        Employee1 employee = new Employee1(1, "John Doe", 30, 5000.0);

        employee.displayEmployeeInfo();

        double annualSalary = employee.calculateAnnualSalary();
        System.out.println("Annual Salary: " + annualSalary);

        boolean isEligibleForPromotion = employee.isEligibleForPromotion();
        System.out.println("Is Eligible for Promotion: " + isEligibleForPromotion);


        FileOutputStream fos = new FileOutputStream("\\C:\\Users\\natha\\Desktop\\ASSIGNMENT\\foleIO\\Employee1.ser.txt");        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(employee);
        System.out.println(" Serealization done for the employee  int tha file Employee.ser : ");
        oos.close();


    }
}