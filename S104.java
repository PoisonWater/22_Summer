class S104 {

    private int maxDepth = 0;

    private void check(TreeNode curr, int currDepth) {
        if (curr == null) {return;}
        maxDepth = Math.max(maxDepth, currDepth);
        check(curr.left, currDepth+1);
        check(curr.right, currDepth+1);
    }

    public int maxDepth(TreeNode root) {

        if (root == null) {return maxDepth;}

        check(root, 1);

        return maxDepth;
    }

}