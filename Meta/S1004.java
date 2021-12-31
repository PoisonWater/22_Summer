package Meta;

public class S1004 {

    // 贪心 Sliding Window 好一点
    // 先判断复杂的0; 少一点continue会快很多
    public int longestOnes0(int[] nums, int k) {
        int i = 0, j = 0;
        int ctr0 = 0;
        int maxLen = 0;
        while (j < nums.length) {
            
            // 2. curr num is 0
            if (nums[j] == 0) {
                
                //2.2 cannot flip
                if (ctr0 >= k) {
                    while (nums[i] != 0) {
                        i++;
                    }
                    i++;
                    
                } else {
                //2.1 can flip
                    ctr0++;
                }

            }
            // 1. curr num is 1
            j++;
            maxLen = Math.max(j-i, maxLen);
        }
        
        return maxLen;
    }

    // 写太乱了 看 sliding window 模版
    // 贪心 Sliding Window
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;
        int ctr0 = 0;
        int maxLen = 0;
        while (j < nums.length) {
            maxLen = Math.max(j-i, maxLen);
            // 1. curr num is 1
            if (nums[j] == 1) {
                j++;
                continue;
            }
            // 2. curr num is 0
            //2.1 can flip
            if (ctr0 < k) {
                j++;
                ctr0++;
                continue;
            }
            //2.2 cannot flip
            while (nums[i] != 0) {
                i++;
            }
            i++;
            j++;
        }
        maxLen = Math.max(j-i, maxLen);
        
        return maxLen;
    }
}
