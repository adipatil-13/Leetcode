class Solution {
    class Pair {
        int row, col, time;
        Pair (int r, int c, int tm) {
            this.row = r;
            this.col = c;
            this.time = tm;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();

        int[][] visited = new int[n][m];
        int freshCnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }
                if (grid[i][j] == 1) freshCnt++;
            }
        }

        int maxTime = 0;
        int drow[] = {-1, 0, +1, 0};
        int dcol[] = {0, 1, 0, -1};
        int count = 0;

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            int row = p.row;
            int col = p.col;
            int time = p.time;

            maxTime = Math.max(maxTime, time);

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                        && visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    queue.add(new Pair(nrow, ncol, time + 1));
                    visited[nrow][ncol] = 2;
                    count++;
                }
            }
        }
        return (count == freshCnt) ? maxTime : -1;
    }
}