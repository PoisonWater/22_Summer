package Meta;

// Revisited - DFS Tree
class S543 {
    
    private int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        
        // The last layer of the traversal is at depth 0
        // Depth represent the distance of the PARENT node to the most bottom node
        // https://jamboard.google.com/d/1XJUfAqPPh3fNhcmVXAVAaP4xF7cJ3-nBctEW9-up0oE
        if (root == null) { return 0; }
        
        int leftD = maxDepth(root.left);
        int rightD = maxDepth(root.right);
        
        // Update the maxDepth along the traversal
        if (leftD + rightD > max) {
            max = leftD + rightD;
        }
        
        return Math.max(leftD, rightD) + 1;
        
    }
    
}
