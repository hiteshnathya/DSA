package Day_14.Lambda.Functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerEx {
    public static void main(String[] args) {
        List<Integer> l1=new ArrayList<>(Arrays.asList(11,22,33,44,55));//list created
        System.out.println(" List with original data "+l1);
        //using consumer functional interface

        Consumer<List<Integer>> product= list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i,list.get(i)*2);
            }

        };

        //calling the accept method of conusmer functional interface
        product.accept(l1);
        System.out.println(" List after applying Consumer Accept method "+l1);

    }
}
