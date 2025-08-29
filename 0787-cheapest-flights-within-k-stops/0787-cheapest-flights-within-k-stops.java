class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], stops = curr[1], cost = curr[2];

            if (stops > k) continue;

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.first, edgeWt = neighbor.second;
                if (cost + edgeWt < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edgeWt;
                    queue.offer(new int[]{adjNode, stops + 1, cost + edgeWt});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
