/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int inorder(TreeNode root, TreeNode[] prev) {
        if (root == null) return Integer.MAX_VALUE;

        int leftMin = inorder(root.left, prev);

        int minDiff = Integer.MAX_VALUE;
        if (prev[0] != null) {
            minDiff = Math.min(minDiff, root.val - prev[0].val);
        }

        prev[0] = root;

        int rightMin = inorder(root.right, prev);

        return Math.min(minDiff, Math.min(leftMin, rightMin));
    }


    public int getMinimumDifference(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        return inorder(root, prev);
    }
}