package Meta;

import java.util.ArrayList;
import java.util.List;

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
