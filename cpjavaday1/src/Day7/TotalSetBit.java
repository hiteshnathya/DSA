package Day7;

import java.util.Scanner;

public class TotalSetBit {

    public static void main(String[] args) {
        int n;
        System.out.println(" Enter an integer :");
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();

        System.out.println("Binary representation of n is : "+ Integer.toBinaryString(n));
        System.out.println("Count Set Bit with simple bit manipulation  (right shift) is : "+ CountSetbit(n));

        System.out.println("Count Set Bit with Briain bit manipulation is : "+ brian(n));

    }



    private static int Counts(int n){
        int bitCount =0;
        for (int i=0;i<n;i++){
            bitCount=bitCount+CountSetbit(i);

        }
        return bitCount;
    }
    public static int brian(int x)
    {
        int r =0;
        while (x > 0)
        {
            x = x & (x-1);

            r++;

        }
        return r;
    }
    private static int CountSetbit(int x) {
        int r=0;
        while (x>0){
            if (x%2!=0){
                r++;

            }
            x=x/2;

        }
        return r;
    }




}
