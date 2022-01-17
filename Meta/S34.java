package Meta;

public class S34 {
    private int findFirst(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return lo;
    }
    
    private int findLast(int[] nums, int target, int lo) {
        int hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return hi;
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        // corner cases
        if (nums.length == 0) { return new int[]{-1, -1}; }
        
        // bin search
        int firstIndex = findFirst(nums, target);
        // 注意corner case out of bound
        if (firstIndex >= nums.length || nums[firstIndex] != target) { return new int[]{-1, -1}; }
        int lastIndex = findLast(nums, target, firstIndex);
        
        return new int[]{firstIndex, lastIndex};
    }
}
