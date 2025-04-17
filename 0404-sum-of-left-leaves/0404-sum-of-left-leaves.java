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
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                if (curr.left.left == null && curr.left.right == null) {
                    res += curr.left.val;
                } else {
                    queue.offer(curr.left);
                }
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        return res;
    }
}
/*
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }
    
    private int dfs(TreeNode root, boolean isLeft) {
        if (node == null)  return 0;

        if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }
        int leftSum = dfs(root.left, true);
        int rightSum = dfs(root.right, false);
        
        return leftSum + rightSum;
    }
}
*/