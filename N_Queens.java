import java.util.*;

public class N_Queens {
    
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(solutions, board, 0, n);
        return solutions;
    }

    private static void backtrack(List<List<String>> solutions, char[][] board, int row, int n) {
        if (row == n) { // BAse CAse
            // directly build the solution here
            List<String> sol = new ArrayList<>();
            for (char[] r : board) {
                sol.add(new String(r));
            }
            solutions.add(sol);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(solutions, board, row + 1, n);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col, int n) {
        // check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solutions = solveNQueens(n);
        
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();   
        }
    }
}
