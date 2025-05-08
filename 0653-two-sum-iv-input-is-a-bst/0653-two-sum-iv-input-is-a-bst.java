class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(set, root, k);
    }
    private boolean dfs(HashSet<Integer> set, TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(set, root.left, k) || dfs(set, root.right, k);
    }
}