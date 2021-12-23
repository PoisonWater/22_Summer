package Meta;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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

class Solution {
    
    // Remember Comparator!
    // Default Min Heap a - b
    private PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if (a[0] != b[0]) return a[0] - b[0]; // diff col
        if (a[1] != b[1]) return a[1] - b[1]; // diff row
        return a[2] - b[2]; // diff value;
    });
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        // DFS + Heap
        dfs(root, 0, 0);
        
        List<List<Integer>> ret = new ArrayList<>();
        int currCol = pq.peek()[0];
        List<Integer> listPtr = new ArrayList<>();
        ret.add(listPtr);
        
        while(!pq.isEmpty()) {
            
            int[] currNode = pq.poll();
            if (currCol != currNode[0]) {
                // New Col
                listPtr = new ArrayList<>();
                ret.add(listPtr);
                currCol = currNode[0];
            }
            
            listPtr.add(currNode[2]);
            
        }
        
        return ret;
        
    }
    
    // DFS
    private void dfs(TreeNode root, int row, int col) {
        pq.add(new int[]{ col, row, root.val });
        if (root.left != null) {
            dfs(root.left, row + 1, col - 1);
        }
        if (root.right != null) {
            dfs(root.right, row + 1, col + 1);
        }
    }
    
}
