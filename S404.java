class S404 {
    public int sumOfLeftLeaves(TreeNode root) {

        // 不把当前recursion的root做主体！！把当前node的left node做主体！
        // 这样就不会让第一层的遍历变得奇怪
        // 计算什么就用什么的子项做主体！

        // 1. 确定递归函数的参数和返回值
        // 2. 确定终止条件
        // 3. 确定单层递归的逻辑，（根据第一层递归适配，并让之后和终止条件适应第一层创建的逻辑。也可以使用Helper Function避免第一层递归冲突）

        // 先进行层序recursion遍历
        if (root == null) return 0;
        int leftValue = sumOfLeftLeaves(root.left);    // 左
        int rightValue = sumOfLeftLeaves(root.right);  // 右

        // 判断下一个left有没有加入， 没有则加入midVal
        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) { // 中
            midValue = root.left.val;
        }
        int sum = midValue + leftValue + rightValue;
        return sum;
    }
}
