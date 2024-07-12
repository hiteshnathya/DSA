package Day_11;

import javax.swing.*;

public class SubSet2{
    static boolean isSubSet(int set[], int n, int sum, String subset) {
        if (sum == 0) {
            System.out.println("Found subset: " + subset);
            return true;
        }
        if (n == 0 && sum!= 0) {
            System.out.println("No subset found for sum " + sum + " with subset " + subset);
            return false;
        }
        if (set[n - 1] > sum) {
            System.out.println("Skipping " + set[n - 1] + " as it's greater than sum " + sum + " with subset " + subset);
            return isSubSet(set, n - 1, sum, subset);
        }
        System.out.println("Trying with " + set[n - 1] + " and sum " + sum + " with subset " + subset);
        boolean include = isSubSet(set, n - 1, sum - set[n - 1], subset + " + " + set[n - 1]);
        if (!include) {
            System.out.println("Trying without " + set[n - 1] + " and sum " + sum + " with subset " + subset);
            include = isSubSet(set, n - 1, sum, subset);
        }
        return include;
    }

    public static void main(String[] args) {
        int set[] = {1, 9, 7, 5, 18, 12, 20, 15};
        int sum = 27;
        int n = set.length;
        if (isSubSet(set, n, sum, "")) {
            System.out.println("Subset is present");
        } else {
            System.out.println("Subset not present");
        }
    }
}