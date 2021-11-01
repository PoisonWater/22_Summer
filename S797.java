import java.util.LinkedList;
import java.util.*;

class S797 {

    private List<List<Integer>> ret;
    private List<Integer> currPath;
    private int[][] graphCopy;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ret = new LinkedList<>();
        currPath = new LinkedList<>();
        graphCopy = graph;
        // currPath.add(0);
        dfs(0);
        return ret;
    }

    private void dfs(int index) {

        currPath.add(index);

        // Termination Condition
        if (index == graphCopy.length - 1) {
            ret.add(new LinkedList<>(currPath));
            return;
        }

        // Looping through currIndex's children
        for (int child : graphCopy[index]) {
            dfs(child);
        }

        currPath.remove(currPath.size() - 1);

    }

}
