package Meta;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S515 {

    // Revisited
    // BFS Tree
    public List<Integer> largestValues(TreeNode root) {
    
        // 1. Arguments
        List<Integer> ret = new ArrayList<>();
        if (root == null) { return ret; } // 注意corner case！！！！！
        
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 1, max = root.val;
        queue.offer(root);
        
        // 2. Traversal Row-wise
        while (!queue.isEmpty()) {
            
            size = queue.size();
            max = queue.peek().val;
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (max < curr.val) {
                    max = curr.val;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            
            ret.add(max);
            
        }
        
        // 3. return
        return ret;
        
    }
}
