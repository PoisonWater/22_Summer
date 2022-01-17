package Meta;

import java.util.ArrayList;
import java.util.List;

public class S163 {

    // Revisited
    // 拆分helper function
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> ret = new ArrayList<>();
        
        if (nums.length == 0) {
            ret.add(genStr(lower, upper));
            return ret;
        }
                
        if (nums[0] > lower) {
            ret.add(genStr(lower, nums[0] - 1));
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i+1]) {
                ret.add(genStr(nums[i]+1, nums[i+1]-1));
            }
        }
        
        if (nums[nums.length-1] < upper) {
            ret.add(genStr(nums[nums.length-1] + 1, upper));
        }
        
        return ret;
        
    }
    
    private String genStr(int lo, int hi) {
        if (lo == hi) {
            return String.valueOf(lo);
        }
        return String.valueOf(lo) + "->" + String.valueOf(hi);
    }
}
