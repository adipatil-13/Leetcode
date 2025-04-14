class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) return;

        if (depth == res.size()) {
            res.add(root.val);
        } else {
            res.set(depth, Math.max(res.get(depth), root.val));
        }

        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }
}
/*
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                
                max = Math.max(max, curr.val);

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);   
            }
            res.add(max);
        }
        return res;
    }
}
*/

