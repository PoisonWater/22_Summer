import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/explore/featured/card/graph/619/depth-first-search-in-graph/3893/
// Name: Find if Path Exists in Graph
// There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). 
// The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. 
// Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
// You want to determine if there is a valid path that exists from vertex start to vertex end.
// Given edges and the integers n, start, and end, return true if there is a valid path from start to end, or false otherwise.

class Graph01 {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        
        List<LinkedList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            graph.add(new LinkedList<Integer>());
        }
        for(int edge[]:edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);

        while (!queue.isEmpty()) {
            
            // Get current node.
            int currNode = queue.poll();
            visited[currNode] = true;
            if (end == currNode) { return true; }

            for (int integer : graph.get(currNode)) {
                if (!visited[integer]) {
                    queue.offer(integer);
                }
            }

        }

        return false;
        
    }
}
