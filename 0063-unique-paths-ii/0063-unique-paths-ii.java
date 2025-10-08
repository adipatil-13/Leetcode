class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n]; 
        
        for (int[] row : dp)
            Arrays.fill(row, -1);
        
        return helper(m - 1, n - 1, obstacleGrid, dp);
    }
    private int helper(int i, int j, int[][] grid, int[][] dp) {
        if (i >= 0 && j >= 0 && grid[i][j] == 1) return 0;

        if (i == 0 && j == 0) return grid[0][0] == 1 ? 0 : 1;

        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1)return dp[i][j];

        int up = helper(i - 1, j, grid, dp);
        int left = helper(i, j - 1, grid, dp);

        return dp[i][j] = up + left;
    }
}