class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                char val = board[r][c];
                int boxIdx = (r / 3) * 3 + (c / 3);

                if (rows[r].contains(val) || cols[c].contains(val) || boxes[boxIdx].contains(val)) {
                    return false;
                }
                rows[r].add(val);
                cols[c].add(val);
                boxes[boxIdx].add(val);
            }
        }
        return true;
    }
}
/*
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0;i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] != '.') {
                    char temp = board[i][j];
                    board[i][j] = '.';
                    if (!check(board, i, j, temp)) 
                        return false;
                    board[i][j] = temp;
                }
            }
        }
        return true;
    }

    public static boolean check(char[][] board,int row,int col,char store){
        // row check 
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == store) return false;
        }
        
        // col check
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == store) return false;
        }

        // grid check
        int r = row / 3; 
        int c = col / 3;

        for (int i = r * 3; i < r * 3 + 3; i++) {
            for (int j = c * 3; j < c * 3 + 3; j++) {
                if (board[i][j] == store)
                    return false;
            }
        }

        return true;
    }
*/