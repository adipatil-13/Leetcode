class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(res, 0, new ArrayList<>(), 0, candidates, target);
        return res;
    }
    private void dfs(List<List<Integer>> res, int i, List<Integer> curr, int total, int[] candidates, int target) {
        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (total + candidates[j] > target) {
                return;
            }
            
            curr.add(candidates[j]);
            dfs(res, j, curr, total + candidates[j], candidates, target);
            curr.remove(curr.size() - 1);
        }
    } 
}
/*
class Solution {

    private void findCombinations(int i, int[] candidates, int target, List<List<Integer>> res, List<Integer> curr) {
        if (i == candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(curr));
            }
            return;
        }

        if (candidates[i] <= target) {
            curr.add(candidates[ind]);
            findCombinations(i, candidates, target - candidates[i], res, curr);
            curr.remove(curr.size() - 1);
        }
        findCombinations(i + 1, candidates, target, res, curr);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinations(0, candidates, target, res, new ArrayList<>());
        return res;
    }
}
*/