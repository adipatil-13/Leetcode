class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) 
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        int min = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) 
            min = Math.min(min, dfs(0, j, matrix, dp));
        
        return min;
    }
    private int dfs(int i, int j, int[][] matrix, int[][] dp) {
        int n = matrix.length;
        if (j < 0 || j >= n) return Integer.MAX_VALUE;

        if (i == n - 1) return matrix[i][j];


        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int down = dfs(i + 1, j, matrix, dp);
        int left = dfs(i + 1, j - 1, matrix, dp);
        int right = dfs(i + 1, j + 1, matrix, dp);

        return dp[i][j] = matrix[i][j] + Math.min(down, Math.min(left, right));
    }
}