class Solution {
    boolean[] visited;
    int n;
    int[][] grid;
    public int findCircleNum(int[][] isConnected) {
        grid = isConnected;
        n = grid.length;
        int res = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                res++;
                dfs(i);
            }
        }
        return res;
    }
    private void dfs(int node) {
        visited[node] = true;

        for (int i = 0; i < n; i++) {
            if (grid[node][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }
}