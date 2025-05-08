class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    public TreeNode bstFromPreorder(int[] preorder, int bound, int[] i) {
        if (i[0] == preorder.length || preorder[i[0]] > bound) return null;

        TreeNode root = new TreeNode(preorder[i[0]++]);

        root.left = bstFromPreorder(preorder, root.val, i);
        root.right = bstFromPreorder(preorder, bound, i);

        return root;
    }
}
/*
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length);
    }
    private TreeNode bstFromPreorder(int[] preorder, int preStart, int preEnd) {
        if (preStart >= preEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int leftStart = preStart + 1;
        int leftEnd = preEnd;

        for (int i = preStart; i < preEnd; i++) {
            if (preorder[i] > root.val) {
                leftEnd = i;
                break;
            }
        }
        root.left = bstFromPreorder(preorder, leftStart, leftEnd);
        root.right = bstFromPreorder(preorder, leftEnd, preEnd);

        return root;
    }
}
*/
