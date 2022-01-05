package Meta;

import java.util.Arrays;

public class S16 {

    // 写太复杂了 写一个function里就可以
    
    int dist = Integer.MAX_VALUE, val = -1;
    
    // Time Complexity: O(n^2) 
    // Space Complexity: from O(logn) to O(n), depending on the implementation of the sorting algorithm.
    public int threeSumClosest(int[] nums, int target) {
        // threeSum ret
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            twoSum(nums, target-nums[i], i + 1, nums[i]);
        }
        return val;
    }
    
    private void twoSum(int[] nums, int target, int index, int num0) { 
        // specify begin index for avoiding multiple results
        int lo = index, hi = nums.length-1;

        // twoSum 找和为target值，从两端收缩找
        while (lo < hi) {
            if (nums[lo] + nums[hi] == target) {
                // generate result
                dist = 0;
                val = nums[lo] + nums[hi] + num0;
                return;
            } else if (nums[lo] + nums[hi] < target) {
                if (Math.abs(nums[lo] + nums[hi] - target) < dist) {
                    dist = Math.abs(nums[lo] + nums[hi] - target);
                    val = nums[lo] + nums[hi] + num0;
                }
                lo++;
            } else {
                if (Math.abs(nums[lo] + nums[hi] - target) < dist) {
                    dist = Math.abs(nums[lo] + nums[hi] - target);
                    val = nums[lo] + nums[hi] + num0;
                }
                hi--;
            }
        }
    }
}
