class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid == null) return 0;
        int rows = grid.length, cols = grid[0].length;
        int res = 0;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    int area = helper(grid, r, c);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }
    private int helper(int[][] grid, int r, int c) {
        int rows = grid.length, cols = grid[0].length;
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) 
            return 0;
        
        grid[r][c] = 0;
        int area = 1;

        area += helper(grid, r + 1, c);
        area += helper(grid, r - 1, c);
        area += helper(grid, r, c + 1);
        area += helper(grid, r, c - 1);
        return area;
    }
}