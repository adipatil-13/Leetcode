class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] count = {0};
        TreeNode res = helper(root, k, count);
        return res != null ? res.val : -1;
    } 
    private TreeNode helper(TreeNode root, int k, int[] count) {
        if (root == null) return null;

        TreeNode left = helper(root.left, k, count);
        if (left != null) return left;
        count[0]++;
        if (count[0] == k) return root;
        return helper(root.right, k, count);
    }
}