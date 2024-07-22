package Day_17;

public class BiggestNumber {

    public  static  int biggest(int arr[]) {
        int biggest = 0;
        for (int i = 0; i < arr.length; i++) {
            biggest = 0;
            if (biggest < arr[i])
                biggest = arr[i];
        }
        return biggest;
    }
    public static int product(int arr[]) {
        int product = 1;
        for (int i = 0; i < arr.length; i++) {
            product *= arr[i];
        }
        return product;
    }

    public static int smallest(int arr[]) {
        int smallest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (smallest > arr[i])
                smallest = arr[i];
        }
        return smallest;
    }


}
