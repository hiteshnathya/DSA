package Day2;

public class BinarySearch {

    public static void main(String args[]) {
        int arr[] = {12, 23, 44, 70, 140, 156, 177, 199, 203, 250, 279, 367};
        int target = 250;

        int result = binarySearch(arr, target);


        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("\nElement found at index " + result);
    }

    private static int binarySearch(int[] arr, int target) {

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Check if Target is present at mid
            System.out.println(" Mid value =" + mid);
            System.out.print("  Lower value is=" + left);
            System.out.print("  Hiogher value is =" + right);

            if (arr[mid] == target) {
                return mid;
                // The target found at index mid
            }


            // If Target greater than mid, ignore left half
            if (target > arr[mid]) {
                left = mid + 1;
            }


            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }

        // The target was not present in array
        return -1;
    }

}
