class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        final long mod = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long distance = curr[0];
            int node = (int)curr[1];

            if (distance > dist[node]) continue;

            for (int[] nb : adj.get(node)) {
                int next = nb[0];
                int time = nb[1];

                if (dist[node] + time < dist[next]) {
                    dist[next] = dist[node] + time;
                    ways[next] = ways[node];
                    pq.offer(new long[]{dist[node] + time, next});
                } else if (dist[node] + time == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % mod;
                }
            }
        }
        return (int)ways[n - 1];
    }
}