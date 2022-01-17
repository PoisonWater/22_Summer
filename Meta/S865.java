package Meta;

public class S865 {
        
    // node stores local result node
    // dist is the depth of current node
    // So that one can pick deeper subtree
    class Pair {
        TreeNode node;
        int dist;
        public Pair(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    
    private Pair dfs(TreeNode root) {
        
        // null return self
        if (root == null) {
            return new Pair(null, 0);
        }
        
        Pair depthL = dfs(root.left), depthR = dfs(root.right); 
        
        // same depth return self
        if (depthL.dist == depthR.dist) {
            return new Pair(root, depthL.dist + 1);
        }
        // pick deeper pair
        if (depthL.dist > depthR.dist) {
            depthL.dist++;
            return depthL;
        }
        depthR.dist++;
        return depthR;

    }
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
}
