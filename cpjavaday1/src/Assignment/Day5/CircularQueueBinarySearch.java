package Assignment.Day5;
public class CircularQueueBinarySearch {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 2;

        System.out.println("Original Array: ");
        printArray(arr);

        int result = binarySearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found");
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int n = arr.length;
        int pivot = findPivot(arr, 0, n - 1);

        System.out.println("Pivot Index: " + pivot);

        if (pivot == -1) {
            // Array is not rotated, perform regular binary search
            return binarySearch(arr, 0, n - 1, target);
        }

        if (arr[pivot] == target) {
            return pivot;
        }

        if (arr[0] <= target) {
            // Search left half
            System.out.println("Searching left half...");
            return binarySearch(arr, 0, pivot - 1, target);
        } else {
            // Search right half
            System.out.println("Searching right half...");
            return binarySearch(arr, pivot + 1, n - 1, target);
        }
    }

    private static int findPivot(int[] arr, int low, int high) {
        if (high < low) {
            return -1;
        }
        if (high == low) {
            return low;
        }

        int mid = low + (high - low) / 2;

        System.out.println("Mid Index: " + mid);

        if (mid < high && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (mid > low && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }
        if (arr[low] >= arr[mid]) {
            return findPivot(arr, low, mid - 1);
        } else {
            return findPivot(arr, mid + 1, high);
        }
    }

    private static int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            System.out.println("Mid Index: " + mid);

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}