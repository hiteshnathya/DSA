package Day7;

import java.util.Scanner;

public class SwapingBit {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        System.out.println(" Enter Integer Number here >>> ");
        int num = sc.nextInt();


        System.out.println("\nEnter  Position of First bit to Swap >>>");
        int pos1 = sc.nextInt();
        System.out.println("position of first bit to swap : "+pos1);


        System.out.println(" \nEnter  Position of Second bit to Swap >>>");
        int pos2 = sc.nextInt();
        System.out.println("position of Second bit to swap : "+pos2);


        System.out.println("\nOriginal number: " + num);
        System.out.println("== Binary representation Before Swap: " + Integer.toBinaryString(num));

        // Step 1: Check if bits at pos1 and pos2 are different
        int bit1 = (num >> pos1) & 1;
        int bit2 = (num >> pos2) & 1;
        System.out.println("\nBit at position " + pos1 + ": " + bit1);
        System.out.println("Bit at position " + pos2 + ": " + bit2);

        if (bit1 != bit2) {
            // Step 2: Create a mask to swap the bits
            int S = (1 << pos1) | (1 << pos2);
            System.out.println("S: " + Integer.toBinaryString(S));

            // Step 3: Swap the bits using XOR
            //num:
            //  S:
            //  ----
            // num ^=s is result: xor of num and s
            num ^= S;
            System.out.println("\nNumber after swapping bits: " + num);
            System.out.println("== Binary representation after swap: " + Integer.toBinaryString(num));
        }
        else
        {
            System.out.println("Bits at positions " + pos1 + " and " + pos2 + " are already the same.");
        }

    }
}
