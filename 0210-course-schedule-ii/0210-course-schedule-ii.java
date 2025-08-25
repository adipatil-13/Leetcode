class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int u = pre[0];
            int v = pre[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int k = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res[k++] = node; 
            
            for (int nb : adj.get(node)) {
                indegree[nb]--;
                if (indegree[nb] == 0) {
                    queue.add(nb);
                }
            }
        }
        if (k != numCourses) return new int[0];
        return res;
    }
}