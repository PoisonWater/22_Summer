package Meta;

public class S270 {
    public int closestValue(TreeNode root, double target) {
        TreeNode node = root;
        int close = root.val;
        
        while (node != null) {
            if (node.val == target) {
                return node.val;
            }
            if (Math.abs((double)close - target) > Math.abs((double)node.val - target)) {
                close = node.val;
            }
            if (node.val < target) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        
        return close;
    }
}
