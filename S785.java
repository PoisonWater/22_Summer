import java.util.LinkedList;
import java.util.Queue;

class S785 {
    public boolean isBipartite(int[][] graph) {
        int[] colorMap = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < graph.length; i++) {
            // Visited: jump to next coloring
            if (colorMap[i] != 0) {
                continue;
            }
            colorMap[i] = 1;
            queue.offer(i);
            
            while (!queue.isEmpty()) {
                int j = queue.poll();
                for (int k : graph[j]) {
                    if (colorMap[k] != 0 && colorMap[k] != -colorMap[j]) {
                        return false;
                    }
                    if (colorMap[k] == 0) {
                        colorMap[k] = -colorMap[j];
                        queue.offer(k);
                    }
                }
            }
            
        }
        return true;
    }
}
