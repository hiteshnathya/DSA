package Assignment.Day11.KNAPSACK;

public class KnapSack {
    public static int knapsack(int W, int[] weights, int[] values) {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int W = 50; // knapsack capacity
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};

        int maxValue = knapsack(W, weights, values);
        System.out.println("Maximum value: " + maxValue);
    }
}
