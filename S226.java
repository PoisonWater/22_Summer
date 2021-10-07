class S226 {

    private void invertTreeHandler(TreeNode root) {
        if (root == null) {return;}
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTreeHandler(root.left);
        invertTreeHandler(root.right);
    }

    public TreeNode invertTree(TreeNode root) {

        invertTreeHandler(root);
        return root;

    }

}
