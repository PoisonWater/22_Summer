package Meta;

import java.util.HashMap;

public class S523 {

    // R2
    // map 存mod 
    // 类似prefixSum 有相减 mod 为0 则返回
    public boolean checkSubarraySumR2(int[] nums, int k) {
        
        // modular - index
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        // map
        int sum = 0;
        
        // Traverse
        for (int i = 0; i < nums.length; i++) {
            
            sum += nums[i];
            sum = sum % k;
            // contains subarray mod == sum && index diff > 1
            if (map.containsKey(sum) && i - map.get(sum) > 1) { return true; }
            
            // update map
            // 注意！map只保存第一次出现情况
            map.putIfAbsent(sum, i); // [2, 0], []
            
        }
        
        return false;
        
    }

    // prefix sum
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int[] sum = new int[nums.length+1];
        for (int i=1; i<sum.length; ++i){
            sum[i] = sum[i-1]+nums[i-1];
        }

        HashMap<Integer, Integer> mod = new HashMap<>();  // 保存余数对应的下标
        for (int i=0; i<sum.length; ++i){
            int sumMod = sum[i]%k;
            if (mod.containsKey(sumMod) && i>mod.get(sumMod)+1) return true;
            else if (!mod.containsKey(sumMod)) mod.put(sumMod, i);   // 只在不存在key时更新，保证子数组长度尽可能大。
        }
        return false;
    }
}
