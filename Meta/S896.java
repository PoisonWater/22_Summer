package Meta;

public class S896 {

    // Revisit
    public boolean isMonotonicR(int[] nums) {
        
        // 1. 只有一个element
        if (nums.length == 1) { return true; }
        
        // 找第一个不相同element
        int ptr = 0;
        while (ptr < nums.length - 1 && nums[ptr] == nums[ptr + 1]) {
            ptr++;
        }
        
        // 2. 全是相同的
        if (ptr == nums.length - 1) { return true; }
        
        // 3. 有不相同的
        int sign = nums[ptr + 1] - nums[ptr];
        
        for (int i = ptr; i < nums.length - 1; i++) {
            
            if (nums[i] == nums[i + 1]) { continue; }
            
            if ((sign > 0 && nums[i] > nums[i + 1]) || (sign < 0 && nums[i] < nums[i + 1])) {
                return false;
            }
            
        }
        
        return true;
        
    }

    public boolean isMonotonic(int[] nums) {
        
        if (nums.length == 1) { return true; }
        
        // skip same num sequences
        int i = 0;
        while (i + 1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        
        if (i + 1 == nums.length) {
            return true;
        }
        
        // Increasing
        if (nums[i+1] > nums[i]) {
            while (i + 1 < nums.length) {
                if (nums[i] > nums[i+1]) {
                    return false;
                }
                i++;
            }
            return true;
        } else {
            // Decreasing
            while (i + 1 < nums.length) {
                if (nums[i] < nums[i+1]) {
                    return false;
                }
                i++;
            }
            return true;
        }
        
    }
}
