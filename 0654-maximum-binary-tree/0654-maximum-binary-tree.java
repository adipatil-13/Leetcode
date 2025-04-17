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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return helper(nums, 0, nums.length - 1);
    }
    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;

        int rangeMax = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[rangeMax]) {
                rangeMax = i;
            }
        }

        TreeNode root = new TreeNode(nums[rangeMax]);

        root.left = helper(nums, start, rangeMax - 1);
        root.right = helper(nums, rangeMax + 1, end);

        return root;
    }
}