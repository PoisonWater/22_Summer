package Meta;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class S199 {

    // R2
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        
        if (root == null) { return ret; }
        
        Queue<TreeNode> queue = new LinkedList<>();
        int counter;
        queue.offer(root);
        while (!queue.isEmpty()) {
            // elements in the current layer
            counter = queue.size();
            // pop all other and push;
            TreeNode curr = null;
            for (int i = 0; i < counter; i++) {
                curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            ret.add(curr.val);
            
        }
        return ret;
    }
}
