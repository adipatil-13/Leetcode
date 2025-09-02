class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int res = 0;

        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Integer> map = new HashMap<>();
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int cost = edge[0];
            int u = edge[1];

            if (vis[u]) continue;
            vis[u] = true;

            res += cost;

            for (int v = 0; v < n; v++) {
                if (!vis[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    if (dist < map.getOrDefault(v, Integer.MAX_VALUE)) {
                        map.put(v, dist);
                        pq.offer(new int[]{dist, v});
                    }
                }
            }
        }
        return res;
    }
}