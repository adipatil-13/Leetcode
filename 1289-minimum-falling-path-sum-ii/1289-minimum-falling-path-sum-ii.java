class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dfs(0, i, grid, dp));
        }
        return min;
    }
    private int dfs(int i, int j, int[][] grid, int[][] dp) {
        int n = grid.length;
        if (i == n - 1) return grid[i][j];

        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = 0; k < n; k++) {
            if (k == j) continue;
            min = Math.min(min, dfs(i + 1, k, grid, dp));
        }
        return dp[i][j] = grid[i][j] + min;
    }
}