package Meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class S314 {
    
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