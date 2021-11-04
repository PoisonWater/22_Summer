import java.util.HashSet;
import java.util.LinkedList;

class S1059 {
    private LinkedList<Integer> visited = new LinkedList<>();
    private HashSet<Integer>[] graph;
    
    private boolean dfs(int currNode, int destination) {
    
        // Cycle detection
        if (visited.contains(currNode)) {
            return false;
        }
        
        // Destination is the end?
        if (currNode == destination) {
            if (graph[currNode].isEmpty()) {
                return true;
            }
            return false;
        }
        
        // End of Graph?
        if (graph[currNode].isEmpty()) {
            return false;
        }
        
        visited.add(currNode); // 注意DFS的Return位置！

        // dfs neighbors
        boolean ret = true;
        for (int neighbor : graph[currNode]) {
            ret = ret && dfs(neighbor, destination);
        }
        
        visited.removeLast();
        return ret;
    }
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        graph = new HashSet[n];
        
        // Build a graph accordingly
        for (int i = 0; i < n; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        
        // dfs
        
        return dfs(source, destination);
        
    }
}
