package Day_15.ReadWrite;

import java.io.*;
import java.nio.Buffer;

public class ReadLine {
    public static void main(String[] args) throws IOException {

        BufferedReader bf=new BufferedReader(new FileReader("C://Users//natha//Desktop//ASSIGNMENT//foleIO//names.txt"));
        String line= bf.readLine();
        while (line !=null){
            System.out.println(line+ " " +line.length());
            line=bf.readLine();

            // Convert to uppercase
            String upperCaseLine = line.toUpperCase();
            System.out.println("\nUppercase Line: " + upperCaseLine);

            // Convert to lowercase
            String lowerCaseLine = line.toLowerCase();
            System.out.println("\nLowercase Line: " + lowerCaseLine);

            // Trim the line (remove leading and trailing whitespaces)
            String trimmedLine = line.trim();
            System.out.println("\nTrimmed Line: " + trimmedLine);

            // Replace a substring (e.g., replace "old" with "new")
            String replacedLine = line.replace("old", "new");
            System.out.println("\nReplaced Line: " + replacedLine);

        }



        bf.close();
    }
}
