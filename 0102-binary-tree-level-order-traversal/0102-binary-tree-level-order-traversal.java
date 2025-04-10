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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //BFS USING QUEUE
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int sizeLevel = queue.size();

            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < sizeLevel; i++) {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
            res.add(currLevel);
        }
        return res;
    }
}
/*
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int level = 0;
        newList(root, res, level);
        return res;
    }
    public void newList(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        List<Integer> currLevel = res.get(level);
        currLevel.add(root.val);
        newList(root.left, res, level + 1);
        newList(root.right, res, level + 1);
    }
}
*/