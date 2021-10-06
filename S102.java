import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class S102 {

    private List<List<Integer>> ret = new ArrayList<>();

    // 1. Recursion Implementation
    private void levelOrderHandler(TreeNode root, int level) {

        if (root == null) { return; }
        if (ret.size() < level+1) {
            ret.add(new ArrayList<Integer>());
        }
        ret.get(level - 1).add(root.val);
        levelOrderHandler(root.left, level+1);
        levelOrderHandler(root.right, level+1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return ret;
        }

        levelOrderHandler(root, 1);

        return ret;
    }

    // 2. Queue Implementation
    public List<List<Integer>> levelOrder1(TreeNode root) {

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root); // Queue - offer()

        while (!que.isEmpty()) {

            int len = que.size();
            ArrayList<Integer> list2nd = new ArrayList<>();

            while (len > 0) {
                TreeNode curr = que.poll();
                list2nd.add(que.poll().val);
                
                if (curr.left != null) {
                    que.offer(curr.left);
                }
                if (curr.right != null) {
                    que.offer(curr.right);
                }
                len--;
            }
            ret.add(list2nd);
        }

        return ret;

    }
}
