class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = (int)1e8;
            }
        }


        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], distance = edge[2];
            dist[u][v] = distance;
            dist[v][u] = distance;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == (int)1e8 || dist[k][j] == (int)1e8) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int min = n;
        int res = -1;

        for (int i = 0; i < n; i++) {
            int srcnt = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    srcnt++;
                }
            }
            if (srcnt <= min) {
                min = srcnt;
                res = i;
            }
        }
        return res;
    }
}