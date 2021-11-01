// Union-Find Version of Graph01.java

class S1971 {

    int[] parents;

    public boolean validPath(int n, int[][] edges, int start, int end) {

        // Disjoint Set Init
        parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i; // Parent of itself
        }

        // Loop through edges for union:
        for (int[] edge : edges) {
            // Union Operation: if same parent between edge[0] and edge[1], then the assign will not change anything
            // if different parent between edge[0] and edge[1], then the assign will not change anything
            parents[find(edge[0])] = parents[find(edge[1])];
        }

        return find(start) == find(end);
    
    }

    private int find(int child) {

        int parent = parents[child];

        while (parent != child) {
            child = parent;
            parent = parents[child];
        }

        return parent;

    }
    
}
