package Meta;

import java.util.HashMap;

class S1644_2 {
    TreeNode merge = null;
    
    private boolean dfs(TreeNode root, int v1, int v2) {
        if (root == null) {
            return false;
        }
        
        boolean b1 = dfs(root.left, v1, v2);
        boolean b2 = dfs(root.right, v1, v2);
        
        if (b1 && b2) {
            merge = root;
            return false;
        }
        
        if ((root.val == v1 || root.val == v2) && (b1 || b2)) {
            merge = root;
            return false;
        }
        
        return root.val == v1 || root.val == v2 || b1 || b2;
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p.val, q.val);
        return merge;
    }
}


public class S1644 {
    HashMap<TreeNode, TreeNode> map = new HashMap<>();

    private void build(TreeNode node, TreeNode parent) {
        if (node == null) {return;}
        map.put(node, parent);
        build(node.left, node);
        build(node.right, node);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Building child - parent map
        build(root, null);
        
        TreeNode p1 = p, p2 = q;
        
        while (p1 != p2) {
            p1 = p1 == null ? q : map.get(p1);
            p2 = p2 == null ? p : map.get(p2);
        }
        
        return p1;
    }
}