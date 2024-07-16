package Day_13.Generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardEx
{
    public static void show(List<?> l1)
    {
        for(Object ob : l1)
            System.out.println(ob);
    }
    public static void main(String args[])
    {
        List<String> l11 = new ArrayList();
        l11.add("hvds");
        l11.add("sdhgcds");
        List<Integer> l12 = new ArrayList<>();
        l12.add(111);
        l12.add(12345);
        show(l11);
        show(l12);
    }
}
