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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        dfs(root, diameter);
        return diameter[0];
    }
    public int dfs(TreeNode root, int[] diameter) {
        if (root == null) return 0;

        int left = dfs(root.left, diameter);
        int right = dfs(root.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right);

        return 1 + Math.max(left, right);
    } 
}
/*
\U0001f4cd Node 4:
Left: null → height = 0
Right: null → height = 0
Diameter at this node: 0 + 0 = 0
Return height = 1 + max(0, 0) = 1

\U0001f4cd Node 5:
Left: null → height = 0
Right: null → height = 0
Diameter at this node: 0 + 0 = 0
Return height = 1 + max(0, 0) = 1

\U0001f4cd Node 2:
Left (from node 4): height = 1
Right (from node 5): height = 1
Diameter at this node: 1 + 1 = 2 ✅ update global diameter → diameter = 2
Return height = 1 + max(1, 1) = 2

\U0001f4cd Node 3:
Left: null → height = 0
Right: null → height = 0
Diameter at this node: 0 + 0 = 0
Return height = 1 + max(0, 0) = 1

\U0001f4cd Node 1 (Root):
Left (from node 2): height = 2
Right (from node 3): height = 1
Diameter at this node: 2 + 1 = 3 ✅ update global diameter → diameter = 3
Return height = 1 + max(2, 1) = 3
*/