import java.util.LinkedList;
import java.util.Queue;

class S111 {
    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int currSize;
        int depth = 0;

        while (!que.isEmpty()) {
            currSize = que.size(); 
            depth++;
            while (currSize > 0) {
                TreeNode curr = que.poll();
                if (curr.left == null && curr.right == null) {return depth;}
                if (curr.left != null) {que.offer(curr.left);}
                if (curr.right != null) {que.offer(curr.right);}
                currSize--;
            }

        }

        return -1;

    }
}
