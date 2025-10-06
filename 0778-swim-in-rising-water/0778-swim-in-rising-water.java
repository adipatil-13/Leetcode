class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] vis = new boolean[n][n];

        pq.add(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int ele = curr[0], r = curr[1], c = curr[2];

            if (r == n - 1 && c == n - 1) return ele;

            for (int[] dir : dirs) {
                int nrow = r + dir[0];
                int ncol = c + dir[1];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    pq.add(new int[]{Math.max(ele, grid[nrow][ncol]), nrow, ncol});
                }
            }
        }
        return -1;
    }
}