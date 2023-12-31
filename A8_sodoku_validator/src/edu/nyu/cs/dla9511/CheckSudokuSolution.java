import java.util.Scanner;

public class CheckSudokuSolution {
    public static void main(String[] args) {
        // Read a Sudoku solution
        int[][] grid = readASolution();

        System.out.println(isValid(grid) ? "Valid solution" : "Invalid solution");
    }
    /*
     * Read a Sudoku solution from the console
     */
    public static int[][] readASolution() {
        // Ask the user for a Sudoku solution
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Sudoku puzzle solution:");
        int[][] grid = new int[9][9];

        // Complete the method here.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = input.nextInt();
            }
        }

        input.close();
        return grid;
    }

    /*
     * Check whether a solution is valid
     */
    public static boolean isValid(int[][] grid) {
        // check each row
        for (int i = 0; i < 9; i++) {
            if (!isValidArray(grid[i])) {
                return false;
            }
        }

        // check each column
        for (int j = 0; j < 9; j++) {
            int[] column = new int[9];
            for (int i = 0; i < 9; i++) {
                column[i] = grid[i][j];
            }
            if (!isValidArray(column)) {
                return false;
            }
        }

        // check each 3x3 box
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {
                int[] box = new int[9];
                int index = 0;
                for (int i = boxRow * 3; i < boxRow * 3 + 3; i++) {
                    for (int j = boxCol * 3; j < boxCol * 3 + 3; j++) {
                        box[index++] = grid[i][j];
                    }
                }
                if (!isValidArray(box)) {
                    return false;
                }
            }
        }

        return true;
    }

    // check if each array contains only unique numbers from 1 to 9
    private static boolean isValidArray(int[] array) {
        boolean[] used = new boolean[9];
        for (int num : array) {
            if (num < 1 || num > 9 || used[num - 1]) {
                return false; 
            }
            used[num - 1] = true;
        }
        return true;
    }
}
