package Day_14.Lambda.Functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerEx1 {

    public static void main(String[] args) {
        // Step 1: Create a list of strings
        List<String> l2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));
        System.out.println(" List with original data " + l2);

        // Step 2: Create a Consumer functional interface
        Consumer<List<String>> product = list -> {
            System.out.println(" Inside Consumer lambda expression");
            for (int i = 0; i < list.size(); i++) {
                System.out.println("\n Before conversion, list.get(" + i + ") = " + list.get(i));

                //making all element inn Uppercase
                list.set(i, list.get(i).toUpperCase());
                System.out.println(" After conversion, list.get(" + i + ") = " + list.get(i));
            }
        };

        // Step 6: Call the accept method of Consumer functional interface
        product.accept(l2);
        System.out.println("\n\n List after applying Consumer Accept method " + l2);
    }
}