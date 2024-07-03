package Day2;

import java.util.Scanner;

public class linearsearch {

    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60,70};
        Scanner sc=new Scanner(System.in);
        System.out.println(" Enter element to search in array");
        int target = sc.nextInt();
        Search(arr,target);


    }

    public static boolean Search(int arr[] ,int target) {

        for (int i = 0; i < arr.length ; i++) {
            if (arr[i]==target)
            {
                System.out.println("Element " + target + " found at index " + i);
            }
        }
        return false;

    }

}
