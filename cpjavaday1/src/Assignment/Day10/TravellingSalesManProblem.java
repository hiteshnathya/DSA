package Assignment.Day10;

public class TravellingSalesManProblem {
    static int n = 4;
    static int[][] distan = {
            {0, 20, 42, 25},{20, 0 , 30, 34}, {42, 30, 0, 10}, {25, 34, 10, 0}
    };
    static int completed_visit = (1 << n) - 1;
    static int[][] DP = new int[32][8];
    static int TSP(int mark, int position) {
        System.out.println("\nEntering TSP with mark = " + mark + " and position = " + position);
        if (mark == completed_visit) {
            System.out.println("Returning distance from " + position + " to 0: " + distan[position][0]);
            return distan[position][0];
        }


        if (DP[mark][position] != -1) {
            System.out.println("Returning cached result for mark = " + mark + " and position = " + position + ": " + DP[mark][position]);
            return DP[mark][position];
        }
        int answer = Integer.MAX_VALUE;
        System.out.println("Exploring cities from position " + position);

        for (int city = 0; city < n; city++) {
            if ((mark & (1 << city)) == 0) {
                System.out.println("Visiting city " + city);

                int newAnswer = distan[position][city] + TSP(mark | (1 << city), city);
                System.out.println("\nDistance from " + position + " to " + city + " and then to remaining cities: " + newAnswer);

                answer = Math.min(answer, newAnswer);
            }
        }
        System.out.println("Minimum distance from position " + position + " to remaining cities: " + answer);
        DP[mark][position] = answer;
        return answer;
    }
    public static void main(String[] args) {
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                DP[i][j] = -1;
            }
        }
        System.out.println("Starting TSP with initial mark = 1 and position = 0");
        System.out.println("Minimum Distance Travelled -> " + TSP(1, 0));

    }
}