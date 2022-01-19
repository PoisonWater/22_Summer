package Meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class S39 {
    List<List<Integer>> ret = new ArrayList<>();
    LinkedList<Integer> curr = new LinkedList<>();
    
    private void dfs(int[] candidates, int target, int sum, int start) {
        // termination case
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ret.add(new ArrayList<>(curr));
            return;
        }
        
        // add all
        for (int i = start; i < candidates.length; i++) {
            // 这里剪枝可以terminate
            if (sum + candidates[i] > target) { break; }
            curr.push(candidates[i]);
            dfs(candidates, target, sum + candidates[i], i);
            curr.pop();
        }
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // sort后才能剪枝
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return ret;
    }
}
