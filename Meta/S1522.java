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

    // Revisited
    int max = 0;
    
    // get depth and update max diameter
    private int dfs(Node root) {
        
        // termination
        if (root == null) { return 0; }
        
        // dfs for depth
        int lmax0 = 0, lmax1 = 0;
        for (Node n : root.children) {
            int ld = dfs(n);
            if (ld > lmax0) {
                lmax1 = lmax0;
                lmax0 = ld;
            } else if (ld > lmax1) {
                lmax1 = ld;
            }
            
        }
        
        // update max
        max = lmax0 + lmax1 > max ? lmax0 + lmax1 : max;
        
        // return depth of previous Node
        return 1 + lmax0;
        
    }
    
    public int diameterR(Node root) {
        dfs(root);
        return max;
    }


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
