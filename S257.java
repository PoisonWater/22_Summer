import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class S257 {

    private LinkedList<Integer> currRoute = new LinkedList<>();
    private List<String> ret = new ArrayList<>();

    private void findRoute(TreeNode root) {
        currRoute.add(root.val);
        if (root.left == null && root.right == null) {
            addRoute();
            currRoute.removeLast();
            return;
        }
        if (root.left != null) {
            findRoute(root.left);
        }
        if (root.right != null) {
            findRoute(root.right);
        }
        currRoute.removeLast();
    }

    private void addRoute() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < currRoute.size() - 1; i++) {
            s.append(currRoute.get(i));
            s.append("->");
        }
        s.append(currRoute.get(currRoute.size() - 1));
        ret.add(s.toString());
    }

    public List<String> binaryTreePaths(TreeNode root) {
        findRoute(root);
        return ret;
    }
}
