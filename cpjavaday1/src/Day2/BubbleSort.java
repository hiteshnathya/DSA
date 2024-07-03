package Day2;

public class BubbleSort {

    public static void main(String[] args) {
        int arr[] = {13, 60, 135, 112, 425, 20, 15, 233};

        System.out.println(" Before Sort Array is =");
        printArray(arr);
        System.out.println();

        bubbleSort(arr);
        System.out.println();

        System.out.println("Array After Bubble Sort");
        printArray(arr);
        System.out.println();
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }

            System.out.println("Step - " + (i + 1));
            printArray(arr);
            System.out.println();
            System.out.println();
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
    }

}

