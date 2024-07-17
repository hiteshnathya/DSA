package Day_14.Lambda.Functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateEx {
    public static void main(String[] args) {
        List<String> li= Arrays.asList("Ram ","Jak","Max","Shyam","Sita","Sam","Raman","Ravi","Ramy");
        //predicate to filter String start with "S"
        Predicate<String> withS= l1 -> l1.startsWith("R");
        List<String> names=li.stream().filter(withS).collect(Collectors.toList());
        System.out.println(names);


        //predicate to filter String with length greater then three
        Predicate<String> ll = l1 -> l1.length() > 4;
        List<String> length = li.stream().filter(ll).collect(Collectors.toList());
        System.out.println(length);


    }
}
