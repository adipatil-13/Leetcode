class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(0, new ArrayList<>(), 0, candidates, target, res);
        return res;
    }

    private static void dfs(int idx, List<Integer> path, int curr, int[] candidates, int target, List<List<Integer>> res) {
        if (curr == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (curr + candidates[i] > target) {
                break;
            }

            path.add(candidates[i]);
            dfs(i + 1, path, curr + candidates[i], candidates, target, res);
            path.remove(path.size() - 1);
        }
    }
}