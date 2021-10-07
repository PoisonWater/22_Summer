import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class BTTraversalStack {

    private ArrayList<Integer> ret = new ArrayList<>();

    public ArrayList<Integer> inorder(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        if (root == null) { return ret; }
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            
            // Always Try pushing the Left Child
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;

            // If no left child, pop back (to the last node), ADD it, and try the Right Child
            } else {
                curr = stack.pop();
                ret.add(curr.val);
                curr = curr.right;
            }

        }
        return ret;

    }

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {return ret;}
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr;

        while (!stack.isEmpty()) {
            curr = stack.pop();
            ret.add(curr.val);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }

        return ret;

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

}
