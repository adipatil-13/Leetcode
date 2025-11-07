class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) return 0;
        int rows = board.length, cols = board[0].length;
        int res = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'X') {
                    if (r > 0 && board[r - 1][c] == 'X') continue;
                    if (c > 0 && board[r][c - 1] == 'X') continue;  
                    res++;
                }
            }
        }
        return res;
    }
}