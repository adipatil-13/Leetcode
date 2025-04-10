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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        TreeNode prevNode = null;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;

            } else {
                root = stack.peek();

                if (root.right == null || root.right == prevNode) {
                    list.add(root.val);
                    stack.pop();

                    prevNode = root;
                    root = null; // go back up the tree
                } else {
                    root = root.right;
                }
            }
        }

        return list;
    }
}
/*
        Stack<TreeNode> mainStack = new Stack<>();
        // Stack to manage the path
        Stack<TreeNode> pathStack = new Stack<>();

        // Start with the root node
        mainStack.push(root);

        // Process nodes until the main stack is empty
        while (!mainStack.isEmpty()) {
            root = mainStack.peek();

            // If the node is in the path stack and it's the top, add its value
            if (!pathStack.isEmpty() && pathStack.peek() == root) {
                result.add(root.val);
                mainStack.pop();
                pathStack.pop();
            } else {
                // Push the current node to the path stack
                pathStack.push(root);
                // Push right child if it exists
                if (root.right != null) {
                    mainStack.push(root.right);
                }
                // Push left child if it exists
                if (root.left != null) {
                    mainStack.push(root.left);
                }
            }
        }

        return result;
*/