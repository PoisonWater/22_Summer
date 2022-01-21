package Meta;

import java.util.HashMap;

class S236R {

    // R2
    TreeNode lca = null;
    
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {return false;}
        
        // 1. p in left and q in right
        boolean b1 = dfs(root.left, p, q);
        boolean b2 = dfs(root.right, p, q);

        if (b1 && b2) {
            lca = root;
            return false;
        }
        
        // 2. p in left / right and q == root
        if ((root.val == p.val || root.val == q.val) && (b1 || b2)) {
            lca = root;
            return false;
        }
        
        return b1 || b2 || root.val == p.val || root.val == q.val;
        
    }
    
    public TreeNode lowestCommonAncestorR2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return lca;
    }

    // Revisit: 类似 LCA II 原方法更好
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    
    private void buildMap(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        map.put(node, parent);
        buildMap(node.left, node);
        buildMap(node.right, node);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        buildMap(root, null);
        
        TreeNode p1 = p, p2 = q;
        
        while (p1 != p2) {
            p1 = p1 == null ? q : map.get(p1);
            p2 = p2 == null ? p : map.get(p2);
        }
        
        return p1;
    }
}

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
