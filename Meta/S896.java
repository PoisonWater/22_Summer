package Meta;

public class S896 {
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
