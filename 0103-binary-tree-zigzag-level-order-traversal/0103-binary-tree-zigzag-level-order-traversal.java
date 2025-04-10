class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();

                if (leftToRight) level.add(currNode.val);
                else level.add(0, currNode.val);    

                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
            leftToRight = !leftToRight;

            result.add(level);
        }
        return result;
    }
}
/*  //Using deque
    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        Deque<Integer> level = new LinkedList<>();
        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();
            if (leftToRight)
                level.offerLast(node.val);
            else
                level.offerFirst(node.val); 
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        result.add(new ArrayList<>(level));
        leftToRight = !leftToRight;
    }

// Using DFS
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int depth) {
        if(root != null) {
            if(result.size() == depth) result.add(new ArrayList<>());
            if(depth % 2 == 0) result.get(depth).add(root.val);
            else result.get(depth).add(0, root.val);
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }
    }
}
*/