class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            adj.get(time[0] - 1).add(new Pair(time[1] - 1, time[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);

        int[] vis = new int[n];
        Arrays.fill(vis, Integer.MAX_VALUE);
        vis[k - 1] = 0;

        pq.add(new Pair(k - 1, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.first;
            int currTime = p.second;

            for (Pair nb : adj.get(node)) {
                int adjNode = nb.first;
                int edgeTime = nb.second;

                if (currTime + edgeTime < vis[adjNode]) {
                    vis[adjNode] = currTime + edgeTime;
                    pq.add(new Pair(adjNode, vis[adjNode]));
                }
            }
        }

        int maxTime = 0;
        for (int time : vis) {
            if (time == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }
}
class Pair {
    int first, second;
    Pair (int first, int second) {
        this.first = first;
        this.second = second;
    }
}