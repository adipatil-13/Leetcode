class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        DSU dsu = new DSU(n);
        for (int[] conn : connections) {
            dsu.union(conn[0], conn[1]);
        }

        Set<Integer> roots = new HashSet<>();
        for (int i = 0; i < n; i++) {
            roots.add(dsu.find(i));
        }

        return roots.size() - 1;
    }
}
class DSU {
    int[] parent;
    int[] rank;
        
    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    public int find(int node){
        if (node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }
    public void union(int u, int v){
        int up = find(u);
        int vp = find(v);
            
        if (up == vp) return;
        if (rank[up] < rank[vp]){
            parent[up] = parent[vp];
        } else if(rank[up] > rank[vp]){
            parent[vp] = parent[up];
        } else {
            parent[vp] = parent[up];
            rank[up]++;
        }
    }
}