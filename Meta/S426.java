package Meta;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class S426 {
    Node sentinel = new Node(-1);
    Node ptr = sentinel;
    
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfsInorder(root);
        attach(sentinel.right);
        return ptr;
    }
    
    private void attach(Node node) {
        ptr.right = node;
        node.left = ptr;
        ptr = node;
    }
    
    private void dfsInorder(Node root) {
        
        if (root == null) {
            return;
        }
        
        // do left
        dfsInorder(root.left);
        
        // do current
        attach(root);
        
        // do right
        dfsInorder(root.right);
        
    }
    
}
