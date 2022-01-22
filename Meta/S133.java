package Meta;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

// R2
class Solution {
    
    Node[] map = new Node[101];
    
    private void build(Node node) {
        
        // Termination
        if (map[node.val] != null) {
            return;
        }
        
        // Construct self
        Node curr = new Node(node.val);
        map[node.val] = curr;
        
        // dfs construct children
        for (Node src : node.neighbors) {
            build(src);
            curr.neighbors.add(map[src.val]);
        }
        
    }
    
    public Node cloneGraph(Node node) {
        if (node == null) { return null; }
        
        build(node);
        
        return map[node.val];
        
    }
}

public class S133 {

    // Revisit
    Node[] visited = new Node[101];
    
    public Node cloneGraph1(Node node) {
        if (node == null) {
            return null;
        }
        
        // assign the visited map
        Node curr = new Node(node.val);
        curr.neighbors = new ArrayList<>();
        visited[node.val] = curr;
        
        // fill in neighbors
        for (Node n : node.neighbors) {
            if (visited[n.val] == null) {
                curr.neighbors.add(cloneGraph(n));
            } else {
                curr.neighbors.add(visited[n.val]);
            }
        }
        
        return curr;
    }


    
    Node[] map = new Node[101]; // Keeps track of the new nodes
    
    public Node cloneGraph(Node node) {
        
        if (node == null) {
            return null;
        }
        
        if (map[node.val] == null) {
            map[node.val] = new Node(node.val);
        }
        
        for (Node c : node.neighbors) {
            if (map[c.val] == null) {
                cloneGraph(c);
            }
            map[node.val].neighbors.add(map[c.val]);
        }
        
        return map[node.val];
        
    }

}
