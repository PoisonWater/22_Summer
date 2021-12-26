package Meta;

import java.util.HashMap;

public class S523 {
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
