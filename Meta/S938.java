package Meta;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class S938 {

    // R2
    private int dfs(TreeNode root, int lo, int hi) {
        // Termination
        if (root == null) { return 0; }
        
        // in range
        if (root.val >= lo && root.val <= hi) {
            return root.val + dfs(root.left, lo, hi) + dfs(root.right, lo, hi);
        }
        
        // Out of range
        if (root.val < lo) {
            return dfs(root.right, lo, hi);
        }
        // root.val > hi
        return dfs(root.left, lo, hi);
        
    }
    
    public int rangeSumBSTR2(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }
    
    // Revisited
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        if (root == null) { return 0; }
        
        // Recursion to DFS traverse, but pruning makes time better:
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        
        return root.val + rangeSumBST(root.right, low, high) + rangeSumBST(root.left, low, high);
        
    }
    
    // ON O1
    
}