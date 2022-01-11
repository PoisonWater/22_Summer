package Meta;

import java.util.ArrayList;
import java.util.Stack;

class BSTIteratorR {

    // Revisit
    // Use 伪 Recursion - Stack
    // Stack里最上面的就是下一个next的返回值
    Stack<TreeNode> stack = new Stack<>();
    
    public BSTIteratorR(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }
    
    public int next() {
        TreeNode curr = stack.pop();
        int ret = curr.val;
        curr = curr.right;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        return ret;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

// O1 Runtime On Space - 构建arrayList
class BSTIterator1 {
    ArrayList<Integer> nodesSorted;
    int index;

    public BSTIterator1(TreeNode root) {

        // Array containing all the nodes in the sorted order
        this.nodesSorted = new ArrayList<Integer>();

        // Pointer to the next smallest element in the BST
        this.index = -1;

        // Call to flatten the input binary search tree
        this._inorder(root);
    }

    private void _inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        this._inorder(root.left);
        this.nodesSorted.add(root.val);
        this._inorder(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return this.nodesSorted.get(++this.index);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.index + 1 < this.nodesSorted.size();
    }
}

// O1 Runtime Oheight Space
class BSTIterator {
        // Inorder Traversal use STACK
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = null;
        boolean isEmpty = false;
        
        // 容易搞错inorder！！！
        public BSTIterator(TreeNode root) {
            // Initialize stack and curr pointer;
            curr = root;
            while (curr!=null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop(); // 先遍历到最底部 让下一次返回curr即可
        }
        
        public int next() {
            // curr即为本次返回
            TreeNode ret = curr;
            curr = curr.right;
            
            // 更新curr
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // 判断empty
            if (!stack.isEmpty()) {
                curr = stack.pop();
            } else {
                isEmpty = true;
            }
            return ret.val;
        }
        
        public boolean hasNext() {
            return !isEmpty;
        }
}
