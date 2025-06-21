public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                sb.append("n ");
                continue;
            }

            sb.append(node.val + " ");
            queue.offer(node.left);
            queue.offer(node.right);
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;

        Queue<TreeNode> queue = new LinkedList<>();
        String[] vals = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.offer(root);

        for (int i = 1; i < vals.length; i++) {
            TreeNode parent = queue.poll();

            if (!vals[i].equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                parent.left = left;
                queue.offer(left);
            }

            if (!vals[++i].equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                parent.right = right;
                queue.offer(right);
            }
        }

        return root;
    }
}
