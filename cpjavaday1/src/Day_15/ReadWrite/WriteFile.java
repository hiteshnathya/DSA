package Day_15.ReadWrite;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        FileOutputStream fo=new FileOutputStream("C://Users//natha//Desktop//ASSIGNMENT//foleIO//names.txt");

        String names =("Anuj ,Amar,Hitesh,Jay,Max,Jassi");
        byte arr[]=names.getBytes();
        fo.write(arr);
        fo.close();

    }
}
