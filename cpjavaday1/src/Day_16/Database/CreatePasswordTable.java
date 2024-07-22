package Day_16.Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CreatePasswordTable {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Connection connection = null;
            Class.forName( "com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro", "root", "rps@123");
            System.out.println("Connected");
            Statement stmt =connection.createStatement();
//table creating
            String create=" create table user("+"user_id INT PRIMERY KEY, "+"password_hash varchar(50) NOT NULL"+")";
            stmt.executeUpdate (create);
            System.out.println("Table created ");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}