package Meta;

public class S129 {

    int sum = 0;
    
    private void dfs(TreeNode node, int prev) {
        
        int val = prev * 10 + node.val;
        
        if (node.left == null && node.right == null) {
            sum += val;
            return;
        }
        
        if (node.left != null) {
            dfs(node.left, val);
        }
        if (node.right != null) {
            dfs(node.right, val);
        }
        
    }
    
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

}
