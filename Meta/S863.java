package Meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class S863 {
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
