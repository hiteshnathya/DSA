package Day_10;

public class LIS {
    public static  int lis(int arr[])
    {
        int n = arr.length;
        int lis[] = new int[n];
        for(int i=0;i<n;i++)
            lis[i] = 1;
        System.out.println("Initial LIS array:");
        printArray(lis);
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j] && lis[i]< lis[j] +1)
                    lis[i]= lis[j]+1;
            }
            System.out.println("LIS array after processing element " + i + ":");
            printArray(lis);
        }
        int m=0;
        for( int i=0;i<n;i++)
        {
            if (m<lis[i])
                m= lis[i];
            System.out.println("Final LIS array:");
        printArray(lis);
//
        }
        return m;
    }
    public static void printArray(int arr[]) {
       for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[])
    {
//            int arr[] = {7,7,7,7,7,7,7};
        int arr[] = {10, 22, 9, 33, 21, 50, 41,60};
        int length = lis(arr);
        System.out.println("Length of the Longest Increasing Subsequence is : "+ length);
    }
}


