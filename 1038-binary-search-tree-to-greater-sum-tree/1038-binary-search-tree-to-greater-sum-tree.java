class Solution {
    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;
    }
    public int dfs(TreeNode node, int sum) {
        if (node == null) return sum;
        int rightSum = dfs(node.right, sum);
        node.val += rightSum;
        return dfs(node.left, node.val);
    } 
}
/*
class Solution {
    private int sum = 0;
    public TreeNode bstToGst(TreeNode root) {

        if (root != null) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }
}
*/