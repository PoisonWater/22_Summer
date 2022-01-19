package Meta;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class S1110 {
    List<TreeNode> ret = new LinkedList<>();
    Set<Integer> set = new HashSet<>();
    
    // return whether parent should delete current node's connection
    // input whether current node should be added to return list
    private boolean dfs(TreeNode node, boolean isNew) {
        
        // Termination
        if (node == null) { return false; }
        
        // delete?
        if (set.contains(node.val)) {
            dfs(node.left, true);
            dfs(node.right, true);
            return true;
        }
        
        // not delete
        if (dfs(node.left, false)) {
            node.left = null;
        }
        if (dfs(node.right, false)) {
            node.right = null;
        }
        
        if (isNew) {
            ret.add(node);
        }
        return false;
        
    }
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        // initialize toDelete set
        for (int i : to_delete) {
            set.add(i);
        }
        
        // dfs
        dfs(root, true);
        
        return ret;
        
    }
}
