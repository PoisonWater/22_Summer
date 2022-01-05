package Meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S15 {
    public List<List<Integer>> threeSum(int[] nums) {
        
        // threeSum ret
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {continue;} // skip same results
            twoSum(ret, nums, -nums[i], i + 1);
        }
        return ret;
    }
    
    private void twoSum(List<List<Integer>> ret, int[] nums, int target, int index) { 
        // specify begin index for avoiding multiple results
        int lo = index, hi = nums.length-1;
        
        // twoSum 找和为target值，从两端收缩找
        while (lo < hi) {
            if (nums[lo] + nums[hi] == target) {
                // generate result
                List<Integer> toAdd = new ArrayList<>(3);
                toAdd.add(-target);
                toAdd.add(nums[lo]);
                toAdd.add(nums[hi]);
                ret.add(toAdd);
                
                // Skip same results
                lo++;
                hi--;
                while (lo < hi && nums[lo] == nums[lo-1]) {
                    lo++;
                }
                while (lo < hi && nums[hi] == nums[hi+1]) {
                    hi--;
                }
            } else if (nums[lo] + nums[hi] < target) {
                lo++;
            } else {
                hi--;
            }
        }
        
    }
}
