package Meta;

import java.util.HashMap;

public class S325 {
    
    // PrefixSum & HashMap
    public int maxSubArrayLen(int[] nums, int k) {
    
        // prefix sum value - first occurances index
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] preSum = new int[nums.length];
        
        // construct map & psum & result
        int sum = 0, maxLen = 0;
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = sum;
            
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return maxLen;
        
    }
}
