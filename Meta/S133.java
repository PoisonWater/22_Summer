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

public class S133 {

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
