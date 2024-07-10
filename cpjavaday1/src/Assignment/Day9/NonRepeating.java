    package Assignment.Day9;
    import java.util.Arrays;

    public class NonRepeating
    {
        public static void nonRepeating(int[] arr)
        {
            int xor = 0;
            System.out.println("Calculating XOR of all elements:");
            for(int n:arr)
            {
                System.out.println("XOR of " + xor + " and " + n + " is " + (xor ^ n));
                xor = xor ^ n;
            }
            System.out.println("XOR of all elements is " + xor);
            int setBit = xor & ~(xor -1);
            System.out.println("Rightmost set bit is " + setBit);
            System.out.println();
            int x = 0, y= 0;
            System.out.println("Dividing elements into two groups based on the rightmost set bit:");
            System.out.println();
            for(int num : arr)
            {
                if((num & setBit) != 0)
                {
                    System.out.println(num + " belongs to group 1");
                    x = x^num;
                }
                else
                {
                    System.out.println(num + " belongs to group 2");
                    y = y^num;
                }
            }
            System.out.println("Non repeating elements in the array are :  "+x +"  "+y);
        }



        public static void Repeating(int[] arr)
        {
            boolean[] repeat = new boolean[arr.length];
            System.out.print("Repeating elements in the array are : ");

            for (int i = 0; i < arr.length; i++)
            {
                int R = 0;
                System.out.println("\nChecking for element " + arr[i]);

                for (int j = 0; j < arr.length; j++)
                {
                    if (arr[i] == arr[j])
                    {
                        R++;
                        System.out.println("Found " + arr[i] + " at index " + j);

                    }
                }
                System.out.println("Count for " + arr[i] + " is " + R);

                if (R > 1 &&!repeat[i])
                {
                    System.out.print(arr[i] + " ");
                    repeat[i] = true;
                }
                System.out.println();
            }
            System.out.println();
        }

        public static void main(String args[])
        {
            int []arr = {1,2,3,2,1,4};
            System.out.println("Array is :"+ Arrays.toString(arr));
            nonRepeating(arr);
            System.out.println();
            System.out.println();
            Repeating(arr);
        }
    }