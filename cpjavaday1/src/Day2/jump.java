package Day2;

public class jump  {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610 };
        int x = 55; // Element to search for

        System.out.println(" Array is - ");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("Searching for element: " + x);

        // Find the index of 'x' using Jump Search
        int index = jumpSearch(arr, x);

        // Print the result
        if (index != -1)
        {
            System.out.println("\nElement " + x + " is at index " + index);
        }
        else
        {
            System.out.println("\nElement " + x + " is not present in the array");
        }

        }
        public static int jumpSearch(int[] arr, int x)
        {
            int n = arr.length;
            System.out.println("array length is "+n);

            System.out.println("Finding block size to be jumped");
            int step = (int) Math.floor(Math.sqrt(n));
            System.out.println("step ="+step);


            System.out.println("Finding the block where element is present (if it is present)");
            int prev = 0;

            while (arr[Math.min(step, n) - 1] < x)
            {
                System.out.println("\nChecking index =" + prev + "\nvalue =" + arr[prev]);
                prev = step;
                step += (int) Math.floor(Math.sqrt(n));
                if (prev >= n)
                {
                    return -1;
                } // Element is not present in the array
            }


            System.out.println();
            System.out.println("Perform a linear search for x in block beginning with prev");
            while (arr[prev] < x)
            {
                System.out.println("\nChecking index =" + prev + "\nvalue =" + arr[prev]);
                prev++;
                if (prev == Math.min(step, n))
                return -1;
                // Element is not present in the block
            }


            // If element is found
            if (arr[prev] == x)
                return prev;

            return -1; // Element is not present in the array
        }
    }
