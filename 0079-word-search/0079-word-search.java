class Solution {
    public boolean exist(char[][] board, String word) {
        // Brute force - backtracking, DFS

        // A -> B look for neighbours horizontally and vertically
        // |
        // S 

        //
        int rows = board.length, cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boolean[][] visited = new boolean[rows][cols];
                if (backtrack(board, word, r, c, 0, visited)) {
                    return true;
                }
            }
        }
        return false;

    }
    private boolean backtrack(char[][] board, String word, int r, int c, int idx, boolean[][] visited) {
        if (idx == word.length()) return true;

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c] || board[r][c] != word.charAt(idx)) {
            return false;
        }

        visited[r][c] = true;
        boolean res = backtrack(board, word, r + 1, c, idx + 1, visited) || 
                      backtrack(board, word, r - 1, c, idx + 1, visited) ||
                      backtrack(board, word, r, c + 1, idx + 1, visited) ||
                      backtrack(board, word, r, c - 1, idx + 1, visited);
        visited[r][c] = false;
        
        return res;
    }
}