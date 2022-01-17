package Meta;

import java.util.LinkedList;
import java.util.Queue;

public class S958 {
    // Revisited
    // BFS
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                } else {
                    // BFS Queue中 只要第一个null出现，本row后面的node和下一个row必为null；
                    // 换句话讲，BFS Queue中 只要第一个null出现，queue中只能有null
                    while (!queue.isEmpty()) {
                        if (queue.poll() != null){
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
