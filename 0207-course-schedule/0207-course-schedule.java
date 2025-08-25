class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int u = pre[0];
            int v = pre[1];
            adj.get(v).add(u);
        }

        // 0 = unvisited, 1 = visiting, 2 = visited
        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, adj, visited)) return false;
        }

        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, int[] visited) {
        if (visited[node] == 1) return true;
        if (visited[node] == 2) return false;

        visited[node] = 1;

        for (int neighbor : adj.get(node)) {
            if (hasCycle(neighbor, adj, visited)) {
                return true;
            }
        }
        visited[node] = 2;
        return false;
    }
}