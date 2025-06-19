
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return dfs(root);
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0; 
        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == 0 || right == 0) {
            return 1 + left + right;
        }
        return 1 + Math.min(left, right);
    }
}