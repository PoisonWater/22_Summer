package Meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class S863 {

    // Revisit 
    // Todo: ON space
    HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();
    
    private void build(TreeNode root) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(root, new ArrayList<>());
        if (root.left != null) {
            // connect
            map.putIfAbsent(root.left, new ArrayList<>());
            map.get(root).add(root.left);
            map.get(root.left).add(root);
            
            // dfs using build
            build(root.left);
        }
        if (root.right != null) {
            // connect
            map.putIfAbsent(root.right, new ArrayList<>());
            map.get(root).add(root.right);
            map.get(root.right).add(root);
            
            // dfs using build
            build(root.right);
        }
    }
    
    public List<Integer> distanceKR(TreeNode root, TreeNode target, int k) {
        build(root);
        
        List<Integer> ret = new ArrayList<>();
        
        // BFS the graph
        Queue<TreeNode> queue = new LinkedList<>();
        boolean[] visited = new boolean[501];
        int step = 0;
        queue.offer(target); // 注意start from target！！！
        visited[target.val] = true;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Termination
            if (step == k) {
                for (TreeNode node : queue) {
                    ret.add(node.val);
                }
                return ret;
            }
            
            // traversal
            for (int i = 0; i < size; i++) {
                List<TreeNode> curr = map.get(queue.poll());
                for (TreeNode node : curr) {
                    if (!visited[node.val]) {
                        queue.offer(node);
                        visited[node.val] = true;
                    }
                }
            }
                
            // step++
            step++;
        }
        
        return ret;
        
    }

    // Sol 1. 重建无向图后BFS找depth为2的点
    // Sol 2. HashMap BFS 差不多 有剪枝 先跳过了
    Map<Integer, List<TreeNode>> graph = new HashMap<>();

    private void buildGraph(TreeNode root, TreeNode parent) {
        
        if (root == null) {return;}
        
        graph.putIfAbsent(root.val, new ArrayList<>());
        
        graph.get(root.val).add(parent);
        graph.get(parent.val).add(root);
        
        buildGraph(root.left, root);
        buildGraph(root.right, root);
        
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        // 1. graph
        graph.put(root.val, new ArrayList<>());
        buildGraph(root.left, root);
        buildGraph(root.right, root);
        
        // 2. BFS the graph
        Queue<TreeNode> queue = new LinkedList<>();
        boolean[] visited = new boolean[501]; // Graph Traversal 要有visited！
        visited[target.val] = true; // 初始化visited数组！！
        queue.offer(target);
        int depth = 0;
        
        while (!queue.isEmpty() && depth != k) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                List<TreeNode> curr = graph.get(queue.poll().val);
                for (TreeNode node : curr) {
                    if (!visited[node.val] ) {
                        queue.offer(node);
                        visited[node.val] = true;
                    }
                }
            }
            
            depth++; // 记得加depth！
            
        }
        
        // 3. return
        List<Integer> ret = new ArrayList<>();
                    
        for (TreeNode node : queue) {
            ret.add(node.val);
        }
        
        return ret;
    }
}
