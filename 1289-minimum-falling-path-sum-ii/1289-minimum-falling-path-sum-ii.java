class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int min1Idx = -1;

        for (int i = 0; i < n; i++) {
            int newMin1 = Integer.MAX_VALUE, newMin2 = Integer.MAX_VALUE;
            int newMin1Idx = -1;

            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    if (j == min1Idx) {
                        grid[i][j] += min2;
                    } else {
                        grid[i][j] += min1;
                    }
                }

                int val = grid[i][j];

                if (val < newMin1) {
                    newMin2 = newMin1;
                    newMin1 = val;
                    newMin1Idx = j;
                } else if (val < newMin2) {
                    newMin2 = val;
                }
            }

            min1 = newMin1;
            min2 = newMin2;
            min1Idx = newMin1Idx;
        }
        return min1;
    }
}