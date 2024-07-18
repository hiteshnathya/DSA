package Day_15.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlEx {
    public static void main(String[] args) throws IOException {
        URL ur =new URL("https://www.simplilearn.com/tutorials/networking-tutorial");
        String protocol=ur.getProtocol();
        System.out.println(protocol);
        int p=ur.getPort();
        String f= ur.getFile();
        System.out.println(" Fort "+p+ "File"+f);
        HttpURLConnection con=(HttpURLConnection) ur.openConnection();
//        con.setRequestMethod("GET");
        int res =con.getResponseCode();
        System.out.println(con);
        BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line=br.readLine();
        System.out.println(line);



    }
}
