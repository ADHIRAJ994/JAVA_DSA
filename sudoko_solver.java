import java.util.Arrays;

public class sudoko_solver {
    public static void solveSudoku(char[][]board){
        backtrack(board);
    }
    public static boolean backtrack(char[][]board){
        for(int r = 0;r<9;r++){
            for(int c = 0;c<9;c++){
                if(board[r][c]=='.'){
                    for(char ch = '1';ch<='9';ch++){
                        if(isSafe(board,r,c,ch)){
                            board[r][c] = ch;
                            if(backtrack(board)) return true;
                            board[r][c] = '.';
                        }
                    }
                    return false; // no digit works → backtrack
                }
            }
        }
        return true; // no empty cells → solved
    }
    public static boolean isSafe(char board[][],int row,int col,char ch){
        for(int i = 0;i<9;i++){
            // check row
            if(board[row][i]==ch) return false;
            //check col
            if(board[i][col]==ch) return false;

            //check 3x3 box
          int boxrow = 3 * (row / 3) + i / 3;
          int boxcol = 3 * (col / 3) + i % 3;

            if(board[boxrow][boxcol]==ch) return false;
        }
        return true;
    }
    public static void main(String[] args){
         char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
        // Print solved board
        for (int r = 0; r < 9; r++) {
            System.out.println(Arrays.toString(board[r]));
        }
    }
}
