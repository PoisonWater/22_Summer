package TikTok;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class S337 {
    // 树形DP : https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0337.%E6%89%93%E5%AE%B6%E5%8A%AB%E8%88%8DIII.md
    // int res[0] == 不要这一层最大值
    // int res[1] == 要这一层的最大值
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        
        return Math.max(res[0], res[1]);
        
    }
    
    private int[] dfs(TreeNode node) {
        
        // Termination Status
        if (node == null) { return new int[]{0, 0}; }
        
        // dfs
        int[] res = new int[2];
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        // 不要这一层的最大值，下一层可要可不要
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 要这一层的最大值，下一层必不要
        res[1] = left[0] + right[0] + node.val;
        
        return res;
        
    }
}
