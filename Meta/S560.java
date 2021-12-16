package Meta;

import java.util.HashMap;

class S560 {
    
    // https://www.youtube.com/watch?v=fFVZt-6sgyo&ab_channel=NeetCode
    
    public int subarraySum(int[] nums, int k) {
        
        // PrefixSum, Count of PS
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int counter = 0, currSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            // Update current prefix_sum
            currSum += nums[i];
            
            // Whether current prefix sum can be minused by a previous prefix sum to make the target K
            // In other words, is there a subarray adds up to K?
            if (map.containsKey(currSum - k)) {
                counter += map.get(currSum - k);
            }
            
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
            
        }
        
        return counter;
        
    }
}
