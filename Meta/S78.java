package Meta;

import java.util.ArrayList;
import java.util.List;

public class S78 {

    // TODO: Rewrite

    // Storing global results
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> curr = new ArrayList<>(); // to backtrack on
    
    // copy List
    private List<Integer> currCopy() {
        List<Integer> cp = new ArrayList<>();
        for (Integer i : curr) {
            cp.add(i);
        }
        return cp;
    }
    
    // back tracking + dfs
    // !!! i is the index that we need to make the decision BOTH add to curr and NOT add to curr
    private void dfs(int[] nums, int i) {
        
        // Termination
        if (i == nums.length) {
            ret.add(currCopy());
            return;
        }
            
        // Include nums[i];
        curr.add(nums[i]);
        dfs(nums, i+1);
        curr.remove(curr.size() - 1);
            
        // NOT include nums[i];
        dfs(nums, i+1);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return ret;
    }
}
