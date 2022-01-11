package Meta;

import java.util.ArrayList;
import java.util.List;

// Revisit
class S1382R {
    private void dfs(List<TreeNode> sorted, TreeNode node) {
        if (node == null) { return; }
        dfs(sorted, node.left);
        sorted.add(node);
        dfs(sorted, node.right);
    }
    
    // 注意此处return TreeNode供上一层construct - DFS + Binary Search
    private TreeNode build(List<TreeNode> sorted, int lo, int hi) {
        if (lo > hi) {return null;}
        
        // clear original connections
        if (lo == hi) {
            TreeNode node = sorted.get(lo);
            node.left = null; 
            node.right = null;
            return node;
        }
        
        // Binary Search
        int mid = (lo + hi) / 2;
        TreeNode curr = sorted.get(mid);
        curr.left = build(sorted, lo, mid - 1);
        curr.right = build(sorted, mid + 1, hi);
        
        return curr;
    }
    
    public TreeNode balanceBST(TreeNode root) {
        
        // Construct sorted nodes
        List<TreeNode> sorted = new ArrayList<>();
        dfs(sorted, root);
        
        // Build Tree
        TreeNode ret = build(sorted, 0, sorted.size() - 1);
        
        return ret;
        
    }
}

public class S1382 {

    // 先构建 sorted array 再转化成 BST
    private List<Integer> sorted = new ArrayList<>();
    
    private void traverse(TreeNode root) {
        if (root.left != null) {
            traverse(root.left);
        } 
        sorted.add(root.val);
        if (root.right != null) {
            traverse(root.right);
        }
    }
    
    private TreeNode build(Integer[] arr, int start, int end) {
        if (start > end || start < 0 || end >= arr.length) {
            return null;
        }
        
        int mid = (start+end)/2;
        TreeNode curr = new TreeNode(arr[mid]);
        curr.left = build(arr, start, mid - 1);
        curr.right = build(arr, mid + 1, end);
        return curr;
    }
    
    public TreeNode balanceBST(TreeNode root) {
        traverse(root);

        // int[] arr = new int[sorted.size()];
        // for (int i = 0; i < sorted.size(); i++) {
        //     arr[i] = sorted.get(i);
        // }

        return build(sorted.toArray(new Integer[sorted.size()]), 0, sorted.size() - 1);
    }
}
