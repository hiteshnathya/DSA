package Day_14.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEx {
    public static void main(String[] args) {

        List<Integer> num= Arrays.asList(12,34,54,65);
        List<Integer> even=num.stream().filter(n->n%2==0).collect(Collectors.toList());
        System.out.println("\nEven Number : "+even);


        int total=even.stream().mapToInt(Integer::intValue).sum();
        System.out.println("\nTotal value "+total);

        List<Double> num1= Arrays.asList(23.45,45.45,33.54,77.22,56.66);
        Double totalDouble=num1.stream().mapToDouble(Double::doubleValue).max().getAsDouble();
        System.out.println("\nTotal Double value "+totalDouble);

        // Additional map operation: square each number
        List<Integer> num2= Arrays.asList(12,36,34,54,65);
        List<Integer> squaredEven = num2.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("\nSquared Even Numbers: " + squaredEven);

        // Additional filter operation: filter out numbers greater than 100
        List<Integer> num3= Arrays.asList(1144,1169,1000,36,44,2,34,54,65);
        List<Integer> SquaredEven = num3.stream().filter(n -> n <= 100).collect(Collectors.toList());
        System.out.println("\nSquared Even Numbers: " + SquaredEven);

        List<Integer> num4= Arrays.asList(28,36,444,400,342,4554);
        List<Integer> MultipleOf4 = num4.stream().filter(n -> n % 4 == 0).collect(Collectors.toList());
        System.out.println("\nEven Numbers that are multiples of 4: " + MultipleOf4);



    }
}
