class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    res += 4;
                    if (r > 0 && grid[r - 1][c] == 1) {
                        res -= 2;
                    }
                    if (c > 0 && grid[r][c - 1] == 1) {
                        res -= 2;
                    }
                }
            }
        }
        return res;
    }
}