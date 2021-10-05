import java.util.ArrayList;
import java.util.List;

// public class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

public class BinaryTreeTraversal {

    private ArrayList<Integer> list = new ArrayList<>();

    private void inorderHandler(TreeNode root) {
        if (root == null) {return;}

        inorderHandler(root.left);
        list.add(root.val);
        inorderHandler(root.right);
    }

    public ArrayList<Integer> inorder(TreeNode root) {

        if (root == null) {return list;}
        
        inorderHandler(root);

        return list;

    }


    private void preorder(TreeNode root) {

        if (root == null) {return;}

        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
        
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {return list;}

        preorder(root);

        return list;

    }


    private void postorder(TreeNode root) {

        if (root == null) {return;}

        postorder(root.left);
        postorder(root.right);
        list.add(root.val);

    }

    public List<Integer> postorderTraversal(TreeNode root) {

        if (root == null) {return list;}

        postorder(root);

        return list;

    }

}