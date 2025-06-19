
class Solution {
    // TreeNode prev = null;
    public void flatten(TreeNode root) {
        // if (root == null) return;
        // flatten(root.right);
        // flatten(root.left);
        // root.right = prev;
        // root.left = null;
        // prev = root;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode runner = curr.left;
                while (runner.right != null) runner = runner.right;
                runner.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}