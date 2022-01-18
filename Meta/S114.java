package Meta;

public class S114 {
    // return last node in list
    private TreeNode dfs(TreeNode node) {
    
        TreeNode left = node.left, right = node.right;
        
        if (left == null && right == null) {return node;}
        
        if (left == null) { return dfs(right); }
        
        if (right == null) {
            node.right = left;
            node.left = null;
            return dfs(left);
        }
        
        node.left = null;
        node.right = left;
        dfs(left).right = right;
        return dfs(right);
        
    }
    
    public void flatten(TreeNode root) {
        if (root == null) { return; }
        dfs(root);
    }
}
