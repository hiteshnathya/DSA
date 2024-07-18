package Day_15.ReadWrite;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        FileInputStream fi=new FileInputStream("C://Users//natha//Desktop//ASSIGNMENT//foleIO//names.txt");
        int i=0;
        while ((i=fi.read())!=-1){
            System.out.print((char)i);
        }
        fi.close();
    }
}
