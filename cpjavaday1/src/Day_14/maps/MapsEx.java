package Day_14.maps;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapsEx {

    // All about Map
    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("41", "62", "83", "94");
        List<Double> l2 = l1.stream().map(Double::valueOf).collect(Collectors.toList());
        System.out.println("\nOriginal List :" + l1);
        System.out.println("List after map operation :" + l2);


//All about flatMap
        List<List<String>> f1 = Arrays.asList(
                Arrays.asList("23", "44", "65"),
                Arrays.asList("11", "22", "33"),
                Arrays.asList("42", "54", "65")
        );
        List<String> flat = f1.stream().flatMap(a -> a.stream()).toList();
        System.out.println("\n\nOriginal List :" + f1);
        System.out.println("List after flatmap operation :" + flat);


// Another example of flatMap
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
// Flat the list of lists into a single list
        List<Integer> flatNumbers = numbers.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("\n\nOriginal List of numbers :" + numbers);
        System.out.println("List of numbers after flatmap operation :" + flatNumbers);


// Another example of flatMap
        List<String> words = Arrays.asList("hello world", "java programming", "CP batch");
// Flatten the list of lists into a single list
        List<String> flatWords = words.stream().map(word -> word.split(" ")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println("\n\nOriginal List of words :" + words);
        System.out.println("\nList of words after flatmap operation :" + flatWords);


    }
}



