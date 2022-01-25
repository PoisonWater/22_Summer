package Meta;

public class S1004 {

    // r            |
    //   [1,1,1,0,0,0,1,1,1,1,0]
    // l          |
    // fliped 2 == k
    
    // 1. if r 1; r++
    // 2.    r 0; flip++
        // 3.   flip > k, l++ until skip 0
    // keep max len along the way
    
    public int longestOnesR2(int[] nums, int k) {
        
        // maxLen
        int maxLen = 0;
        int l = 0, r = 0, flip = 0;
        
        // traverse
        while (r < nums.length) {
            
            if (nums[r] == 0) {
                flip++;
            }
            if (flip > k) {
                while (nums[l] != 0) {
                    l++;
                }
                l++;
                flip--;
            }
            
            maxLen = Math.max(r - l + 1, maxLen);
            
            r++;
        }
        
        return maxLen;
        
    }

    // Revisit: TODO: REDO
    // 贪心 Sliding Window
    public int longestOnesR(int[] nums, int k) {
        int ctr = 0, max = 0, lenMax = 0;
        int p1 = 0, p2 = 0;
        
        while(p2 < nums.length) {
            
            // next number in is 1
            if (nums[p2] == 1) {
                p2++;
                max++;
                
            // next number in is 0
            } else {
                // can flip
                if (ctr < k) {
                    ctr++;
                    p2++;
                    max++;
                // cannot flip
                } else {
                    while (p1 < nums.length && nums[p1] == 1) {
                        max--;
                        p1++;
                    } 
                    p1++;
                    p2++;
                }
            }
            
            lenMax = Math.max(max, lenMax);
            
        }
        
        return lenMax;
        
    }


    
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
