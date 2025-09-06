class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0, maxCol = 0, n = stones.length;

        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        Disjoint ds = new Disjoint(maxRow + maxCol + 2);
        HashMap<Integer, Integer> map = new HashMap<>();

         for (int[] stone : stones) {
            int rowNode = stone[0];
            int colNode = stone[1] + maxRow + 1;
            ds.unionBySize(rowNode, colNode);
            map.put(rowNode, 1);
            map.put(colNode, 1);
        }


        int cnt = 0;
        for (int node : map.keySet()) {
            if (ds.find(node) == node) cnt++;
        }
        return n - cnt;
    }
}
class Disjoint {
    List<Integer> parent;
    List<Integer> size;

    Disjoint(int n) {
        parent = new ArrayList<>(n);
        size = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);    
        }
    }

    public int find(int node) {
        if (parent.get(node) != node) {
            parent.set(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) return;

        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
    }
}