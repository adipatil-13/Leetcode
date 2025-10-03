class Solution {
    public int trapRainWater(int[][] heightMap) {
        int[] drow = {0, 0, -1, 1};
        int[] dcol = {1, -1, 0, 0};
        int numRows = heightMap.length;
        int numCols = heightMap[0].length;
        if (numRows < 3 || numCols < 3) return 0;

        boolean[][] vis = new boolean[numRows][numCols];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < numRows; i++) {
            pq.offer(new int[] {heightMap[i][0], i, 0});
            pq.offer(new int[] {heightMap[i][numCols - 1], i, numCols - 1});
            vis[i][0] = vis[i][numCols - 1] = true;
        }

        for (int j = 0; j < numCols; j++) {
            pq.offer(new int[] {heightMap[0][j], 0, j});
            pq.offer(new int[] {heightMap[numRows - 1][j], numRows - 1, j});
            vis[0][j] = vis[numRows - 1][j] = true;
        }

        int res = 0;

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int height = cell[0], r = cell[1], c = cell[2];

            for (int k = 0; k < 4; k++) {
                int nrow = r + drow[k];
                int ncol = c + dcol[k];

                if (nrow >= 0 && nrow < numRows && ncol >= 0 && ncol < numCols && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    res += Math.max(0, height - heightMap[nrow][ncol]);
                    pq.offer(new int[] {Math.max(heightMap[nrow][ncol], height), nrow, ncol});
                }
            }
        }
        return res;

    }
}