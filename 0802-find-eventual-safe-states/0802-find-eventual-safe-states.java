class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, vis)) {
                res.add(i);
            }
        }
        return res;
    }
    private boolean dfs(int node, int[][] graph, int[] vis) {
        if (vis[node] > 0) return vis[node] == 2;
        vis[node] = 1;

        for (int neighbor : graph[node]) {
            if (vis[neighbor] == 1 || !dfs(neighbor, graph, vis)) {
                return false; // cycle detected
            }
        }
        vis[node] = 2;
        return true;
    }
}