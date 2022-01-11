package Meta;

public class S162 {

    // Revisit
    public int findPeakElement1(int[] nums) {
        // Binary Search + 顺着坡向上走
        // 注意Corner Cases
        int lo = 0, hi = nums.length - 1, mid = (lo + hi) / 2;
        
        if (nums.length < 2 || nums[0] > nums[1]) { return 0; }
        if (nums[hi] > nums[hi - 1]) { return hi; }
        
        while (nums[mid] < nums[mid + 1] || nums[mid] < nums[mid - 1]) {
            if (nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            mid = (hi + lo) / 2;
        }
        
        return mid;
        
    }

    public int findPeakElement(int[] nums) {
        
        int mid = 0;
        int i = 0, j = nums.length - 1;
        
        // Corner Cases
        if (nums.length == 1) {return 0;} 
        if (nums[i] > nums[i + 1]) {return 0;}
        if (nums[j - 1] < nums[j]) {return j;}
        
        
        while (mid != i + (j-i) / 2) {
            mid = i + (j-i) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) { // peak
                return mid;
            }
            if (nums[mid] < nums[mid - 1]) { // left higher
                j = mid; // 这个不用 mid - 1 因为会 out of bound
            } else { // right higher or bottom
                i = mid + 1; // 注意二分查找的index！省去没用的index，用mid + 1！
            }
        }
        return -1;
    }
    
}
