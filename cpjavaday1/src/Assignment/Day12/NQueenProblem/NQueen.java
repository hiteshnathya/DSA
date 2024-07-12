package Assignment.Day12.NQueenProblem;

public class NQueen {
    final int N = 8;
    void print(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print("" + board[i][j] + "     ");
            System.out.println();
            System.out.println(" ");
        }
    }
    boolean isSafe(int board[][], int r, int c) {
        for (int i = 0; i < c; i++) {
            if (board[r][i] == 1)
                return false;
            if (r - i > 0 && board[r - i][c - i] == 1)
                return false;
            if (r + i < N && board[r + i][c - i] == 1)
                return false;

        }
        return true;
    }
    boolean solveNQUtil(int board[][], int c, int step) {
        if (c >= N) {
            System.out.println("\nSolution found:");
            print(board);
            return true;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, c)) {
                board[i][c] = 1;
                System.out.println("\nStep " + step + ":");
                print(board);
                if (solveNQUtil(board, c + 1, step + 1)) {
                    return true;
                }
                board[i][c] = 0; // Back tracking
            }
        }
        return false;
    }
    boolean solveNQ() {
        int board[][] = new int[N][N];
        if (!solveNQUtil(board, 0, 0)) {
            System.out.println("\nSolution not found");
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        NQueen obj = new NQueen();
        obj.solveNQ();
    }

}