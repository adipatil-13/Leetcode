class BSTIterator {
    LinkedList<Integer> list = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        traverse(root);
    }
    
    public int next() {
        return list.poll();
    }
    
    public boolean hasNext() {
        return list.peek() != null;
    }
    
    private void traverse(TreeNode node) {
        if (node == null) return;

        traverse(node.left);
        list.offer(node.val);
        traverse(node.right);

        return;
    }
}