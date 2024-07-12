package Assignment.Day12.Rat_in_a_Maze;

import java.util.ArrayList;
import java.util.List;
public class RatInMaze {
    static final int N = 6; // Maze size

    // Directions to move in the maze (up, down, left, right)
    static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Function to check if a cell is valid (within bounds and not a wall)
    static boolean isValid(int[][] maze, int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    // Function to solve the maze using backtracking
    static boolean solveMaze(int[][] maze, int x, int y, int[][] solution) {
        // If we've reached the destination, return true
        if (x == N - 1 && y == N - 1) {
            solution[x][y] = 1;
            return true;
        }

        // Mark the current cell as part of the solution
        solution[x][y] = 1;

        // Explore all possible directions
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            // If the new cell is valid and not already part of the solution
            if (isValid(maze, newX, newY) && solution[newX][newY] == 0) {
                // Recursively explore the new cell
                if (solveMaze(maze, newX, newY, solution)) {
                    return true;
                }
            }
        }

        // If no solution is found, backtrack and mark the current cell as not part of the solution
        solution[x][y] = 0;
        return false;
    }

    // Main function to solve the maze
    static boolean solveMaze(int[][] maze) {
        int[][] solution = new int[N][N];

        // Initialize the solution matrix with all zeros
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                solution[i][j] = 0;
            }
        }

        // Start solving the maze from the top left corner
        return solveMaze(maze, 0, 0, solution);
    }

    // Print the solution matrix
    static void printSolution(int[][] solution) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1}
        };

        if (solveMaze(maze)) {
            int[][] solution = new int[N][N];
            solveMaze(maze, 0, 0, solution);
            printSolution(solution);
        } else {
            System.out.println("No solution exists");
        }
    }
}