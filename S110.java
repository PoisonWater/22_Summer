class S110 {

    private int height(TreeNode root) {
        if (root == null) {return 0;}

        int leftH = height(root.left);
        int rightH = height(root.right);

        if (leftH == -1 || rightH == -1 || Math.abs(leftH - rightH) > 1) {return -1;}
        return Math.max(leftH, rightH) + 1;
        
    }

    public boolean isBalanced(TreeNode root) {
        if (height(root) == -1) {return false;}
        return true;
    }
}
