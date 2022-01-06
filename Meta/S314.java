package Meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class S314 {

    // Revisit: 用BFS 不用DFS！
    public List<List<Integer>> verticalOrder1(TreeNode root) {
    
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        
        // Key - Col; Value - list of nodes
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueCol = new LinkedList<>();
        
        // Queue Init
        queue.offer(root);
        queueCol.offer(0);
        
        // BFS Tree
        int min = 0, max = 0; // Note 1. 别忘加 min max 之后按顺序返回list
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 1. read current node and col
                int currCol = queueCol.poll();
                TreeNode currNode = queue.poll();
                
                // 2. add to map
                map.putIfAbsent(currCol, new ArrayList<Integer>());
                map.get(currCol).add(currNode.val);
                
                // 3. update queue using curr left right
                if (currNode.left != null) {
                    queue.offer(currNode.left);
                    queueCol.offer(currCol - 1);
                    min = min > (currCol - 1) ? (currCol - 1) : min;
                } 
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                    queueCol.offer(currCol + 1);
                    max = max < (currCol + 1) ? (currCol + 1) : max;
                }
            }
        }
        
        // Gen Return
        for (; min <= max; min++) {
            ret.add(map.get(min)); // Note 2. 这里要按顺序返回list
        }
        
        return ret;
        
    }
    
    // Can also use 2 queues to simulate the pair! Much faster!
    class Pair {
        TreeNode node;
        int col;
        
        public Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> ret = new ArrayList<>();

        if (root == null) { return ret; }
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); // < Column, List of Node Values>
        Queue<Pair> queue = new LinkedList<>();
        int min = 0, max = 0;
        
        queue.offer(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            map.putIfAbsent(current.col, new ArrayList<Integer>());
            map.get(current.col).add(current.node.val);
            
            if (current.node.left != null) {
                queue.offer(new Pair(current.node.left, current.col-1));
                if (current.col - 1 < min) {
                    min = current.col - 1;
                } 
            }
            if (current.node.right != null) {
                queue.offer(new Pair(current.node.right, current.col+1));
                if (current.col + 1 > max) {
                    max = current.col + 1;
                } 
            }
            
        }
        
        
        for (int i = min; i < max + 1 ; i++) {
            ret.add(map.get(i));
        }
        
        return ret;
        
    }
    
}

// class Solution {
//     public List<List<Integer>> verticalOrder(TreeNode root) {
//         if (root == null) return new ArrayList<>();
//         Map<Integer, List<Integer>> map = new HashMap<>();
//         map.put(0, new ArrayList<>());
//         map.get(0).add(root.val);
        
//         int min = 0, max = 0;
//         Queue<TreeNode> queue = new LinkedList<>();
//         Queue<Integer> cols = new LinkedList<>();
//         cols.offer(0);
//         queue.offer(root);
//         while (!queue.isEmpty()) {
//             TreeNode node = queue.poll();
//             int col = cols.poll();
//             if (node.left != null) {
//                 map.putIfAbsent(col - 1, new ArrayList<>());
//                 map.get(col - 1).add(node.left.val);
//                 min = Math.min(min, col - 1);
//                 cols.offer(col - 1);
//                 queue.offer(node.left);
//             }
//             if (node.right != null) {
//                 map.putIfAbsent(col + 1, new ArrayList<>());
//                 map.get(col + 1).add(node.right.val);
//                 max = Math.max(max, col + 1);
//                 cols.offer(col + 1);
//                 queue.offer(node.right);
//             }
//         }
        
//         List<List<Integer>> res = new ArrayList<>();
//         for (int i = min; i <= max; i++) {
//             res.add(map.get(i));
//         }
        
//         return res;
//     }
// }