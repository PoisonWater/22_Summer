package Meta;

class S536R {

    // Revisit
    // TODO: Rewrite
    private int build(TreeNode node, String s, int ptr) {
        
        // 1. Get current node number
        // +/-
        char c = s.charAt(ptr);
        int num = 0, sign = 1;
        
        if (c == '-') { 
            sign = -1; 
            ++ptr;
        } else if (c == '+') {
            ++ptr;
        }
        
        // number
        while (ptr < s.length() && Character.isDigit(s.charAt(ptr))) {
            c = s.charAt(ptr++);
            num = (c - '0') + 10*num;
        }
        num *= sign;
        
        // Assign Node Number
        node.val = num;
        
        // 2. curr ptr eval
        // end
        if (ptr >= s.length()) { return ptr; }
        
        // construct left node?
        c = s.charAt(ptr);
        if (c == '(') {
            node.left = new TreeNode();
            ptr = build(node.left, s, ptr + 1);
            if (ptr >= s.length()) { return ptr; }
            c = s.charAt(ptr);
            
            // construct right node?
            if (c == '(') {
                node.right = new TreeNode();
                ptr = build(node.right, s, ptr + 1);
                return ptr + 1; // 跳过')'
                
            // no right node;
            } else {
                return ptr + 1;
            }
            
        // no left node
        } else {
            return ptr + 1;
        }
        
    }
    
    public TreeNode str2tree(String s) {
        if (s.length() == 0) { return null; }
        TreeNode ret = new TreeNode();
        build(ret, s, 0);
        return ret;
    }
}

public class S536 {

    TreeNode result = new TreeNode();

    // 注意：返回处理过的index 传入要添加的node
    private int build(TreeNode node, int n, String s) {
        
        // 1. Get Value for current node
        int cval = 1, val = 0;
        if (s.charAt(n) == '-') {
            cval = -1;
            n++;
        }
        while (n < s.length() && Character.isDigit(s.charAt(n))) {
            val = 10 * val + (s.charAt(n) - '0');
            n++;
        }

        cval *= val;
        node.val = cval;
        
        // 2. Handle reaching finish
        if (n >= s.length()) {
            return n-1;
        }
        
        // 3. leftNode
        char c = s.charAt(n);
        if (c == ')') {
            return n + 1;
        } else if (c == '('){
            TreeNode newNode = new TreeNode();
            node.left = newNode;
            n = build(newNode, n + 1, s);
            if (n == s.length()) {
                return s.length();
            }
            
            // 4. rightNode
            char c1 = s.charAt(n);
            if (c1 == ')') {
                return n + 1;
            } else if (c1 == '('){
                newNode = new TreeNode();
                node.right = newNode;
                n = build(newNode, n + 1, s);
                if (n == s.length()) {
                    return s.length();
                }
                return n + 1;
            }
        }
        return 0; // Not Reachable
    }
    
    public TreeNode str2tree(String s) {
        if (s.length() == 0) {
            return null;
        }
        build(result, 0, s);
        return result;
    }
    
}
