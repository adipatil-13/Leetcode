class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), res); //1 to 9
        return res;
    }
    private void backtrack(int i, int k, int n, List<Integer> currPath, List<List<Integer>> res) {
        if (n == 0 && k == 0) { //both target sum & exactly k numbers, add the list
            res.add(new ArrayList<>(currPath));
            return;
        }

        if (i > 9) return;
        if (n < 0 || k < 0) return;

        List<Integer> temp = new ArrayList<>(currPath);
        // modifications made during one path of recursion don't accidentally affect other paths.
        temp.add(i);
        backtrack(i + 1, k - 1, n - i, temp, res); //Include i
        backtrack(i + 1, k, n, currPath, res); //Skip i
    }
}