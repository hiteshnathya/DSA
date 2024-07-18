package Assignment.Day15.ReadWrite;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWriteExample {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\natha\\Desktop\\ASSIGNMENT\\foleIO\\task1.txt";
        String outputFile = "C:\\Users\\natha\\Desktop\\ASSIGNMENT\\foleIO\\ask1output.txt";

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer))!= -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.err.println("Error reading or writing file: " + e.getMessage());
        }
    }
}