class Solution {
    public int minimumEffortPath(int[][] heights) {
        // O(n.m.log(m.n)), O(m.n)
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.distance - b.distance);

        int n = heights.length, m = heights[0].length;
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int)1e9;
            }
        }

        dist[0][0] = 0;
        pq.add(new Pair(0, 0, 0));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (pq.size() != 0) {
            Pair p = pq.poll();
            int diff = p.distance;
            int r = p.row;
            int c = p.col;

            if (r == n - 1 && c == m - 1) return diff;

            for (int i = 0; i < 4; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];
                if (newr >= 0 && newc >= 0 && newr < n && newc < m) {
                    int effort = Math.max(Math.abs(heights[r][c] - heights[newr][newc]), diff);
                    if (effort < dist[newr][newc]) {
                        dist[newr][newc] = effort;
                        pq.add(new Pair(effort, newr, newc));
                    }
                }
            }
        }
        return 0;
    }
}
class Pair {
    int distance;
    int row, col;
    public Pair (int distance, int row, int col) {
        this.distance = distance;
        this.row = row;
        this.col = col;
    }
}