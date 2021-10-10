// import java.util.LinkedList;
// import java.util.Queue;

class S222 {
    // 不要故弄玄虚！！！暴力解法比你以为的更优解更快！法克！
    // public int countNodes(TreeNode root) {
    //     if (root == null) { return 0; }

    //     TreeNode ptr = root;
    //     int depth = 0;

    //     while (ptr != null) {
    //         depth++;
    //         ptr = ptr.left;
    //     }

    //     Queue<TreeNode> que = new LinkedList<>();
    //     que.offer(root);
    //     int currSize;
    //     TreeNode curr;
    //     int maxDepth = depth;

    //     while (depth > 1) {
    //         depth--;
    //         currSize = que.size();

    //         while (currSize > 0) {
    //             curr = que.poll();
    //             que.offer(curr.left);
    //             que.offer(curr.right);
    //             currSize--;
    //         }
    //     }

    //     int lastRowSize = -1;
    //     curr = root;
    //     while (curr != null) {
    //         lastRowSize++;
    //         curr = que.poll();
    //     }

    //     int sum = 0;
    //     for (int i = 0; i < maxDepth - 1; i++) {
    //         sum += Math.pow(2, i);
    //     }

    //     sum += lastRowSize;
    //     return sum;

    // }

    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
