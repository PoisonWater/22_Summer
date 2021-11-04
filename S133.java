import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


// Definition for a Node.
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

class S133 {
    // Keep track of visited Copies so the loop would stop and reference can be found.
    private HashMap<Integer,Node> visited = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        
        if (node == null) { return null; }
        
        // Visited then return the previous copy
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }

        // Init New Copy
        Node copy = new Node(node.val, new ArrayList<>());

        // Add the Entry for current Copy into the HashMap();
        // Note that the copy has not finished the copy process, but it can still be added because it will always use the same reference.
        // In graph, especially cycles, we can use the node before finish creating them, because the reference would stay the same anyway
        visited.put(copy.val, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));

        }

        return copy;
        
    }

    public static void main(String[] args) {
        
        
        Node input = new Node(3, new ArrayList<>());
        input.neighbors.add(new Node(2));
        input.neighbors.add(new Node(1));
        input.neighbors.get(1).neighbors.add(new Node(0));
        input.neighbors.get(1).neighbors.add(input);

        S133 test = new S133();
        test.cloneGraph(input);

    }
    
}
