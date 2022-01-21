package Meta;

import java.util.Arrays;
import java.util.Random;

// R2 - weighted random - prefix sum
// TODO: Math.random()
class S528R2 {
    
    int[] preSum;
    int totalSum;
    Random r = new Random();

    public S528R2(int[] w) {
        preSum = new int[w.length];
        
        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            preSum[i] = totalSum;
        }
        
        // after construction: presum ends at totalSum
    }
    
    public int pickIndex() {
        // random number
        // 用double不用考虑边界情况！！！！Math.random()为[0,1)的double
        double rand = Math.random() * totalSum;
        
        // rand < num[i] - return i; rand == num[i] - return i+1;
        if (rand < preSum[0]) {return 0;}
        
        int lo = 0, hi = preSum.length;
        
        // find first position larger or equals to rand
        while ( lo <= hi ) {
            int mid = (lo + hi) / 2;
            if (preSum[mid] < rand) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        
        return lo;
    }
}

// Revisit:
// 1. Arrays.binarySearch();
// 2. PrefixSum
class S528Revisit {
    
    private int[] prefix;
    private int maxVal;
    private Random random;
    public S528Revisit(int[] w) {
        this.prefix = w;
        for(int i = 1; i < w.length; i++)
          w[i] += w[i-1];
      
        this.maxVal = w[w.length-1];
        this.random = new Random();
    }
    
    public int pickIndex() {
        int key = random.nextInt(this.maxVal)+1; // 注意 range 左闭右开
        // https://blog.csdn.net/jhl8105/article/details/38264749
        // index < 0 : 没有match，第一个空档为-1，第二个为-2 以此类推。
        // index >= 0: 有match在index；
        int index = Arrays.binarySearch(this.prefix, key);
        if(index < 0)
          return -index-1;
        else
          return index;
    }
}

class S528 {

    private int[] prefixSum;
    
    public S528(int[] w) {
        
        // PrefixSum！
        //    1, 2, 3, 2, 1
        // 0, 1, 3, 6, 8, 9
        prefixSum = new int[w.length + 1];
        prefixSum[0] = 0;
        
        for (int i = 1; i < w.length + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i - 1];            
        }
        
    }
    
    public int pickIndex() {
        
        // Math.random 更快
        int randInt = (int)(Math.random() * prefixSum[prefixSum.length - 1]);
        
        for (int i = 1; i < prefixSum.length; i++) {
            if (randInt < prefixSum[i]) {
                return i - 1;
            }
        }
        
        return -1;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */