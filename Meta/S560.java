package Meta;

import java.util.HashMap;

class S560 {

    // Revisit
    public int subarraySumR(int[] nums, int k) {
        int ctr = 0, sum = 0; // prefixSum
        // key - all prefix sums; values - count of the prefix sum
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            sum += i;
            // examine the current sum == k?
            if (sum == k) {
                ctr++;
            }
            
            // examine sum - k in hashMap's keys
            if (map.containsKey(sum - k)) {
                ctr += map.get(sum - k);
            }
            
            // add current sum to map 
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            
        }
        
        return ctr;
        
    }
    
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
