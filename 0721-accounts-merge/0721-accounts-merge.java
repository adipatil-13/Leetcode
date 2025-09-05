class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);

        Map<String, Integer> emailGroup = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!emailGroup.containsKey(email)) {
                    emailGroup.put(email, i);
                } else {
                    dsu.unionBySize(i, emailGroup.get(email));
                }
            }
        }

        Map<Integer, List<String>> comp = new HashMap<>();
        for (String email : emailGroup.keySet()) {
            int group = emailGroup.get(email);
            int groupPar = dsu.find(group);

            comp.putIfAbsent(groupPar, new ArrayList<>());
            comp.get(groupPar).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (int group : comp.keySet()) {
            List<String> component = comp.get(group);
            Collections.sort(component);
            component.add(0, accounts.get(group).get(0));
            res.add(component);
        }

        return res;
    }
}
class DSU {
    int[] parent;
    int[] size;
    
    DSU(int n) {
        parent = new int[n];
        size = new int[n];
        
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    public void unionBySize(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return;
    
        if (size[pa] >= size[pb]) {
            size[pa] += size[pb];
            parent[pb] = pa;
        } else {
            size[pb] += size[pa];
            parent[pa] = pb;
        }
    }
}