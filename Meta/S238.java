package Meta;

public class S238 {
    public int[] productExceptSelf(int[] nums) {
        int product = 1, zeroCtr = 0;
        
        for (int num : nums) {
            if (num == 0) {
                zeroCtr++;
            } else {
                product *= num; // 注意如果是0就不累乘！
            }
        }
        
        int[] ret = new int[nums.length];
        
        // 多个0 返回全是0
        if (zeroCtr >= 2) {
            return ret;
        }
        
        // 一个0 就他不是0
        if (zeroCtr == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    ret[i] = product;
                }
            }
            return ret;
        }
        
        // 没有0 常规做
        for (int i = 0; i < nums.length; i++) { 
            ret[i] = product / nums[i];
        }
        return ret;
        
    }
}
