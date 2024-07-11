package Day_10;

import java.util.Arrays;
public class KnightProblem {
    static final int N = 8;
    static int[][] sol = new int[N][N];
    //check place is in range and not assigned yet
    static boolean isValid(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }
    static void displaySolution() {
        System.out.println("The possible solution: ");
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.printf("%3d ", sol[x][y]);
            System.out.println();
        }
    }
    static boolean knightTour(int x, int y, int move, int[] xMove, int[] yMove) {
        int xNext, yNext;
        //when the total board is covered
        if (move == N*N)
            return true;
        for (int k = 0; k < 8; k++) {
            xNext = x + xMove[k];
            yNext = y + yMove[k];
            //check room is preoccupied or not
            if (isValid(xNext, yNext)) {
                sol[xNext][yNext] = move;
                if (knightTour(xNext, yNext, move+1, xMove, yMove))
                    return true;
                else
                    // backtracking
                    sol[xNext][yNext] = -1;
            }
        }
        return false;
    }
    static boolean findKnightTourSol() {
        //initially set all values to -1 of solution matrix
        for (int[] row : sol)
            Arrays.fill(row, -1);
        //all possible moves for knight
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
        //starting from room (0, 0)
        sol[0][0] = 0;
        if (!knightTour(0, 0, 1, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            displaySolution();
        return true;
    }
    public static void main(String[] args) {
        findKnightTourSol();
    }
}