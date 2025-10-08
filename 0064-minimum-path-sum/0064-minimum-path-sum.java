class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(0, 0, grid, dp);
    }
    private int helper(int i, int j, int[][] grid, int[][] dp) {
        int m = grid.length, n = grid[0].length;
        if (i == m - 1 && j == n - 1) return grid[i][j];

        if (i > m - 1 || j > n - 1) return Integer.MAX_VALUE;

        if (dp[i][j] != -1) return dp[i][j];

        int down = helper(i + 1, j, grid, dp);
        int right = helper(i, j + 1, grid, dp);

        dp[i][j] = grid[i][j] + Math.min(down, right);
        return dp[i][j];
    }
}