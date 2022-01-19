package Meta;

public class S977 {
    public int[] sortedSquares(int[] nums) {
        int[] ret = new int[nums.length];
        
        // find first element >= 0
        int ptr = 0;
        while (ptr < nums.length && nums[ptr] < 0) {
            ptr++;
        }
        
        // Corner cases 不必要！还会变慢
        // // corner cases
        // if (ptr == 0) {
        //     for (int i = 0; i < nums.length; i++) {
        //         ret[i] = nums[i] * nums[i];
        //     }
        //     return ret;
        // }
        // if (ptr == nums.length) {
        //     for (int i = nums.length - 1; i >= 0; i--) {
        //         ret[nums.length - i - 1] = nums[i] * nums[i];
        //     }
        //     return ret;
        // }
        
        // p1 < 0; p2 > 0
        int p1 = ptr - 1, p2 = ptr;
        ptr = 0;
        
        while (p1 >= 0 && p2 < nums.length) {
            if (-nums[p1] < nums[p2]) {
                ret[ptr] = nums[p1] * nums[p1];
                p1--;
            } else {
                ret[ptr] = nums[p2] * nums[p2];
                p2++;
            }
            ptr++;
        }
        
        
        // add rest
        while (p1 >= 0) {
            ret[ptr] = nums[p1] * nums[p1];
            p1--;
            ptr++;
        }
        while (p2 < nums.length) {
            ret[ptr] = nums[p2] * nums[p2];
            p2++;
            ptr++;
        }
        
        return ret;
        
    }
}
