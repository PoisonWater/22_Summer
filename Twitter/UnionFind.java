package Twitter;
import java.util.*;

class Result {

    /*
     * Complete the 'countGroups' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY related as parameter.
     */

    private static int[] parent;
    
    public static int countGroups(List<String> related) {
    // Write your code here
        int[][] graph = new int[related.size()][related.size()];
        int size = related.size();
    
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j] = (int) related.get(i).charAt(j);
            }
        }
        
        parent = new int[size];
        
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (graph[i][j] == 1) {
                    parent[find(i)] = parent[find(j)];
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < parent.length; i++) {
            set.add(parent[i]);
        }
        
        return set.size();
        
    }
    
    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

}
