package Meta;

public class S298 {
    int maxlen = 0;
    
    // int 0 length int 1 prev num
    private int[] dfs(TreeNode root) {
        
        if (root == null) { return new int[]{-1, -1}; }
        
        int[] infoL = dfs(root.left);
        int[] infoR = dfs(root.right);
        
        if (root.val == infoL[1] - 1 && root.val == infoR[1] - 1) {
            return new int[]{Math.max(infoL[0], infoR[0]) + 1, root.val};
        }
        if (root.val == infoL[1] - 1) {
            maxlen = Math.max(maxlen, infoR[0]);
            return new int[]{infoL[0] + 1, root.val};
        }
            
        if (root.val == infoR[1] - 1) {
            maxlen = Math.max(maxlen, infoL[0]);
            return new int[]{infoR[0] + 1, root.val};
        }
        
        maxlen = Math.max(maxlen, infoR[0]);
        maxlen = Math.max(maxlen, infoL[0]);
        return new int[]{1, root.val};
        
    }
    
    public int longestConsecutive(TreeNode root) {
        int[] res = dfs(root);
        maxlen = Math.max(maxlen, res[0]);
        
        return maxlen;
    }
}
