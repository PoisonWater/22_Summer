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

    // R2
    // return node[0] - local head; node[1] - local tail
    private Node[] sort(Node curr) {
        // Termination status
        if (curr == null) { return new Node[]{null, null}; }
        
        // dfs
        Node[] left = sort(curr.left);
        Node[] right = sort(curr.right);
        
        Node head = null, tail = null;
        if (left[0] == null) {
            head = curr;
        } else {
            head = left[0];
            left[1].right = curr;
            curr.left = left[1];
        }
        
        if (right[0] == null) {
            tail = curr;
        } else {
            tail = right[1];
            curr.right = right[0];
            right[0].left = curr;
        }
        return new Node[]{head, tail};
        
    }
    
    public Node treeToDoublyList2(Node root) {
        
        if (root == null) { return null; }
        
        Node[] ret = sort(root);
        ret[0].left = ret[1];
        ret[1].right = ret[0];
        return ret[0];
    }

    // Revisit: TODO: 第二次做错辽
    Node head, tail; // represent the circular double list
    
    private void dfs(Node root) {
        if (root == null) {
            return;
        }
                
        dfs(root.left);
        
        if (head == null) {
            head = root; // 没有head则更新root
        } else {
            // attach current node to the end of list
            // only to tail, connect head and tail at the end
            root.left = tail;
            root.left.right = root;
        }
        
        tail = root; // update tail
        dfs(root.right);
    }
    
    public Node treeToDoublyListR(Node root) {
        if (root == null) {
            return null;
        }
        
        dfs(root);
        head.left = tail;
        tail.right = head;
        
        return head;
        
    }

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
