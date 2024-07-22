package Day_16.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.Class.forName;

public class ConnectDB {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        try
        {
            Connection connection=null;
            Class.forName( "com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection( "jdbc:mysql://localhost:3306/wipro",  "root",  "rps@123");
            System.out.println("Connected");
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter id, name, password");
            int id=Integer.parseInt(sc.nextLine());
            String name=sc.nextLine();
            String password=sc.nextLine();
            String insertQuery="insert into student1 (student_id, student_name, student_password) values (?,?,?)";
            PreparedStatement pstmt=connection.prepareStatement(insertQuery);
            pstmt.setInt( 1,id);
            pstmt.setString ( 2,name);
            pstmt.setString ( 3, password);
            int x=pstmt.executeUpdate();
            if (x>0)
                System.out.println("Insert successfully");
            System.out.println("could not able to insert");






            System.out.println("Enter id to update:");
            int id1 = Integer.parseInt(sc.nextLine());
            System.out.println("Enter new name:");
            String newName = sc.nextLine();
            System.out.println("Enter new password:");
            String newPassword = sc.nextLine();

            String updateQuery = "update student1 set student_name = ?, student_password = ? where student_id = ?";
            PreparedStatement pstmt1 = connection.prepareStatement(updateQuery);
            pstmt.setString(1, newName);
            pstmt.setString(2, newPassword);
            pstmt.setInt(3, id);

            int y = pstmt.executeUpdate();
            if (y > 0) {
                System.out.println("Update successfully");
            } else {
                System.out.println("Could not update");
            }


            System.out.println("Enter id to delete:");
            int id2 = Integer.parseInt(sc.nextLine());

            String deleteQuery = "delete from student1 where student_id =?";
            PreparedStatement pstmt2 = connection.prepareStatement(deleteQuery);
            pstmt2.setInt(1, id2);

            int z = pstmt2.executeUpdate();
            if (z > 0) {
                System.out.println("Delete successfully");
            } else {
                System.out.println("Could not delete");
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
