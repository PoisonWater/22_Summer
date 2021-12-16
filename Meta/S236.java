package Meta;

public class S236 {

    private TreeNode mergePt = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p.val, q.val);
        return mergePt;
    }
    
    private boolean dfs(TreeNode root, int v1, int v2) {
        
        if (root == null) { return false; }
        
        // 如果是LCA，只有两种情况：
        // 1. LCA左右各一个 p and q
        // 2. LCA本身是p，其中一个子node是q
        if (root.val == v1 || root.val == v2) { 
            mergePt = root; // 应对第 2 种情况，如果其ancestor没有出现第一种情况，只能是第二种情况，即它本身是LCA
            return true; 
        }
        
        boolean b1 = dfs(root.left, v1, v2);
        boolean b2 = dfs(root.right, v1, v2);
        
        if (b1 && b2) {
            mergePt = root;
            return false;
        }
        
        return b1 || b2;
        
    }
    
}
