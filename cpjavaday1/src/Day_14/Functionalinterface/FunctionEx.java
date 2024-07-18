package Day_14.Functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionEx {
    public static void main(String[] args) {
        List<String>li= Arrays.asList("Hi","Hello","How","Ho");
        Function<String,String> adding= s -> s+" !";
        List<String> greetings=li.stream().map(adding).collect(Collectors.toList());
        System.out.println("Greetings with exclimanation");
        System.out.println(greetings);

        // Find the length of each string
        Function<String, Integer> stringLength = s -> s.length();
        List<Integer> lengths = li.stream().map(stringLength).collect(Collectors.toList());
        System.out.println("The Length of each string is :");
        System.out.println(lengths);

        //******************//
        //BiFunction

        BiFunction<Integer,Integer,Integer> add=(x,y)->x+y;
        System.out.println(add.apply(33,55));

        BiFunction<Double,Double,Double> sub=(x,y)->x-y;
        System.out.println(sub.apply(133.33,55.34));






    }
}
