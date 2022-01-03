package Meta;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class S1522 {
    private int maxDepth = 0;
    
    private int depth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth0 = 0, depth1 = 0;
        
        for (Node node : root.children) {
            int tmp = depth(node) + 1;
            if (tmp > depth0) {
                depth1 = depth0;
                depth0 = tmp;
            } else if (tmp > depth1) {
                depth1 = tmp;
            }
        }
        
        maxDepth = maxDepth >= depth1 + depth0 ? maxDepth : depth1 + depth0;
        
        return depth0;
        
    }
    
    public int diameter(Node root) {
        depth(root);
        return maxDepth;
    }
}
