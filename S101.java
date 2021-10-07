import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class S101 {
    public boolean isSymmetric(TreeNode root) {

        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list2nd;
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) {return true;}
        que.offer(root);
        int currSize;

        while (!que.isEmpty()) {
            currSize = que.size();
            list2nd = new ArrayList<>();
            while (currSize > 0) {
                TreeNode curr = que.poll();
                if (curr == null) {
                    list2nd.add(null);
                } else {
                    list2nd.add(curr.val);
                    que.offer(curr.left);
                    que.offer(curr.right);
                }
                currSize--;
            }
            list.add(list2nd);
        }

        for (List<Integer> iList : list) {
            ArrayList<Integer> listOrder = new ArrayList<>(iList);
            Collections.copy(listOrder, iList);
            Collections.reverse(iList);
            if (!listOrder.equals(iList)) {
                return false;
            }
        }
        return true;
    }



    // Better: Recursion
    private boolean check(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {return false;}
        return check(left.left, right.right) && check(left.right, right.left);
    }

    public boolean isSymmetric0(TreeNode root) {

        if (root == null) {return true;}

        return check(root.left, root.right);
        
    }
}
