class Solution {
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        dfs(root, res);
        return res[0];
    }
    private int dfs(TreeNode root, int[] res){
        if(root == null) return 0;

        // Recursively calculate maximum sum for left & right subtrees
        // Ignore negative sums by taking maximum with 0
        int leftMax = Math.max(dfs(root.left, res), 0); 
        int rightMax = Math.max(dfs(root.right, res), 0); 

        // Update global max path sum with current node's value
        res[0] = Math.max(res[0], root.val + leftMax + rightMax);
        // Return max path sum including current node & one of its subtrees
        return root.val + Math.max(leftMax, rightMax);
    }
}