import java.util.*;

class S337 {
    private List<List<Integer>> ret = new ArrayList<>();

    // 1. Recursion Implementation
    private void levelOrderHandler(TreeNode root, int level) {

        if (root == null) { return; }
        if (ret.size() < level) {
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
    
    // WRONG ANSWER
    public int rob(TreeNode root) {
        List<List<Integer>> result = levelOrder(root);
        int even = 0, odd = 0;

        for (int i = 0; i < result.size(); i++) {
            if (i % 2 == 0) {
                even += result.get(i).stream().mapToInt(Integer::intValue).sum();
            } else {
                odd += result.get(i).stream().mapToInt(Integer::intValue).sum();
            }
        }
        return Math.max(even, odd);
    }
}
