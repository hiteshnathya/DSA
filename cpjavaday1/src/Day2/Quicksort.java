package Day2;

import java.util.Arrays;

class Quicksort {

    // method to find the partition position
    static int partition(int array[], int low, int high) {

        // choose the rightmost element as pivot
        int pivot = array[high];

        // pointer for greater element
        int i = (low - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;
                // swapping element at i with element at j
                System.out.println("Swapping " + array[i] + " and " + array[j]); // Print swap operation

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                System.out.println("Array after swap: \n" + Arrays.toString(array));  // Print current array state
                System.out.println();

                int partitionPosition = i + 1;
                System.out.println("Partition position: " + partitionPosition);
            }

        }

        // swapt the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        System.out.println("Pivot (" + pivot + ") placed at index " + (i + 1));
        System.out.println();// Print pivot placement
        // return the position from where partition is done
        return (i + 1);
    }

    static void quickSort(int array[], int low, int high)
    {
        if (low < high)
        {
            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pi = partition(array, low, high);

            // recursive call on the left of pivot
            quickSort(array, low, pi - 1);

            // recursive call on the right of pivot
            quickSort(array, pi + 1, high);
        }
    }
}

// Main class
class Main
{
    public static void main(String args[])
    {
        int[] arr = { 8, 7, 2, 1, 0, 9, 6, 13, 17, 5 };
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(arr));
        int size = arr.length;
        // call quicksort() on array data
        Quicksort.quickSort(arr, 0, size - 1);
        System.out.println("Sorted Array in Ascending Order ");
        System.out.println(Arrays.toString(arr));
    }
}